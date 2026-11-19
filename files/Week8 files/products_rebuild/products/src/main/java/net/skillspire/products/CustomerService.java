package net.skillspire.products;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CustomerService {
    private final CustomerRepository customerRepo;
    private final OrderService orderService;

    public CustomerService(CustomerRepository customerRepo,
                           OrderService orderService) {
        this.customerRepo = customerRepo;
        this.orderService = orderService;
    }

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();

    }

    public Customer addCustomer(Customer customer){
        return customerRepo.save(customer);
    }

    public Customer getCustomer(Long id){
        return customerRepo.findById(id).orElse(null);
    }

    public Customer updateCustomer(Long id, Customer changes){
        Customer existing = customerRepo.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setId(changes.getId());
        existing.setName(changes.getName());
        existing.setProfile(changes.getProfile());

        return customerRepo.save(existing);
    }

    public Order getCustomerOrderById(Long orderId) {
        Order targetOrder = orderService.getOrder(orderId);
        if (targetOrder == null){
            return null;
        }
        return targetOrder;
    }

}
