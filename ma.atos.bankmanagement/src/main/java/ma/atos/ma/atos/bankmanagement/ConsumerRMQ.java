package ma.atos.ma.atos.bankmanagement;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

//@Component
//public class ConsumerRMQ {
//    @RabbitListener(queues = "${eventqueue}")
//    public void receiver(@Payload String payload) {
//        System.out.println("This a message : " + payload);
//    }
//}
