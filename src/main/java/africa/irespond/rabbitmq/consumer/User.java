package africa.irespond.rabbitmq.consumer;

import africa.irespond.rabbitmq.config.MessagingConfig;
import africa.irespond.rabbitmq.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class User {
    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus){
        System.out.println("Message received from queue : "+orderStatus);
    }
}
