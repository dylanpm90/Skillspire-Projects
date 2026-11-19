package net.skillspire.products;

import java.nio.file.Path;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/orders")
public class OrderController {
    private final OrderService orderService;
    private final OrderRepository orderRepo;

    public OrderController(OrderService orderService,
                           OrderRepository orderRepo){
        this.orderService = orderService;
        this.orderRepo = orderRepo;
    }

    @GetMapping // get all orders
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Long order_id){
        Order order = orderService.getOrder(order_id);
        if (order == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(order);
    }

}
