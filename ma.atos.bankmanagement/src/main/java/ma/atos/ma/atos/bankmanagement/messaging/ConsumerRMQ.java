package ma.atos.ma.atos.bankmanagement.messaging;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
public class ConsumerRMQ {
    @RabbitListener(queues = "${eventqueue}")
    public void receive(@Payload String message)
    {
        System.out.printf("message received "+message+" \n");
    }
}
