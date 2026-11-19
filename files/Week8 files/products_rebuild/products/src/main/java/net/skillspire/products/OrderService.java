package net.skillspire.products;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepo;

    public OrderService(OrderRepository orderRepo){
        this.orderRepo = orderRepo;
    }

    public List<Order> getAllOrders(){
        return orderRepo.findAll();
    }

    public Order addOrder(Order order) {
        return orderRepo.save(order);
    }

    public Order getOrder(Long id){
        return orderRepo.findById(id).orElse(null);
    }

    public Order updateOrder(Long id, Order changes, Customer customer){
        Order existing = orderRepo.findById(id).orElse(null);
        if(existing == null){
            return null;
        }
        existing.setId(changes.getId());
        existing.setCustomer(changes.getCustomer());

        return orderRepo.save(existing);
    }

}
