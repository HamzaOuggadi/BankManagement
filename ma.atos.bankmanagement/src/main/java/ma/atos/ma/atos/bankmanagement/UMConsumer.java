package ma.atos.ma.atos.bankmanagement;

import com.pcbsys.nirvana.client.*;
import jdk.nashorn.internal.objects.annotations.Constructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
@Service
public class UMConsumer implements ApplicationListener<ApplicationReadyEvent> {


    static final String RNAME = "nhp://localhost:9001";
    static final String QUEUE_IN = "QUEUE_TEST";   // mock

    nSession session = null;

    nQueue queueOut = null;


    @PostConstruct
    public void init () throws Exception {
        session = connect(RNAME);
        queueOut = getQueue(session, QUEUE_IN);
    }

    static nQueue getQueue(nSession session, String queueName) throws Exception {
        nChannelAttributes cattrib = new nChannelAttributes();
        cattrib.setName(queueName);
        nQueue queue = session.findQueue(cattrib);
        System.out.println("Queue Retrieved: " + queue.getName());
        return queue;
    }


    /**
     * Connexion et obtention d'une session
     *
     * @param rnames
     * @return session
     * @throws Exception
     */
    static public nSession connect(String rnames) throws Exception {
        nSessionAttributes sessionAttributes = new nSessionAttributes(rnames);
        nSession connectionObject = nSessionFactory.create(sessionAttributes);
        connectionObject.init();
        return connectionObject;
    }

    static void disconnect(nSession session) {
        session.close();
        session = null;
    }

    static String receive(nQueue queue) throws Exception {

        nQueueSyncReader reader = queue.createTransactionalReader(new nQueueReaderContext());
        nConsumeEvent evt = reader.pop(1);
        if (evt != null) {
            long id = evt.getEventID();
            nEventProperties nEventProperties = evt.getProperties();
            String message = new String(evt.getEventData(), StandardCharsets.ISO_8859_1);
            System.out.println("*********>" +message);
            if (nEventProperties != null)
            System.out.println("---------->" + (String) nEventProperties.get("testKey"));
        }
        return "Queue vide";
    }
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

        while (true) {
            try {
                receive(queueOut);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
