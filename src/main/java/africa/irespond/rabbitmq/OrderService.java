package africa.irespond.rabbitmq;

import africa.irespond.rabbitmq.config.MessagingConfig;
import africa.irespond.rabbitmq.dto.Order;
import africa.irespond.rabbitmq.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public String bookOrder(Order order, String customerName){
        order.setOrderId(UUID.randomUUID().toString());
        OrderStatus orderStatus =  new OrderStatus(order, "PROCESS", "order successfully " +
                "placed by "+customerName);
        rabbitTemplate.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, orderStatus);
        return "Success!";
    }
}
