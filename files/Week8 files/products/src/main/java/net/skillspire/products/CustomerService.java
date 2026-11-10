package net.skillspire.products;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
            System.out.println(" " + o + " | " + o.getPriority());
        }

    }
}
