package ma.atos.ma.atos.bankmanagement.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ConsumerRMQ {

    @RabbitListener(queues = "incoming")
    public void receive(@Payload String message){

        System.out.println("this a message from rmq : "+message);

}

}
