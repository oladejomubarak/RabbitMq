package africa.irespond.rabbitmq;

import africa.irespond.rabbitmq.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("create/{customerName}")
    public ResponseEntity<?> bookOrder(@RequestBody Order order, @PathVariable String customerName){

        return new ResponseEntity<>(orderService.bookOrder(order, customerName), HttpStatus.OK);
    }
}
