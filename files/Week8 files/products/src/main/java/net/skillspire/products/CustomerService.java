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

    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }



    @Transactional(readOnly = true)
    public void printCustomer(Long id) {
        Customer customer = customerRepo.findById(id).orElse(null);
        if (customer == null) {
            System.out.println("No customer " + id);
            return;
        }
        System.out.println(customer);
        if (customer.getOrders().isEmpty()) {
            System.out.println(" has no orders.");
        }
        for (Order o : customer.getOrders()) {
            System.out.println(" " + o + " | ");
        }

    }

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public Customer addCustomer(Customer c) { return customerRepo.save(c);}


    public Customer getCustomer(Long id) {
        return customerRepo.findById(id).orElse(null);
    }

    public Customer updateCustomer(Long id, Customer changes) {
        Customer existing = customerRepo.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setId(changes.getId());
        existing.setName(changes.getName());
        existing.setAddress(changes.getAddress());

        return customerRepo.save(existing);
    }

    public List<Order> getOrders(){ return getOrders();}
}
