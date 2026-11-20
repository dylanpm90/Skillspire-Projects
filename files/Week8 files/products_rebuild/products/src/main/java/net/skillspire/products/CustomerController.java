package net.skillspire.products;

import java.nio.file.Path;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/customers")
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerRepository customerRepo;


    public CustomerController(CustomerService customerService,
                              CustomerRepository customerRepo) {
        this.customerService = customerService;
        this.customerRepo = customerRepo;
    }

    @GetMapping // get all customers
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}") // get customer by ID
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long customer_id){
        Customer customer = customerService.getCustomer(customer_id);

        if(customer == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(customer);

    }

    @GetMapping("/{customer_id}/orders/{order_id}")
    public ResponseEntity<Order> getCustomerOrderById(@PathVariable("customer_id") Long customer_id,
                                                      @PathVariable("order_id") Long order_id){
        Order order = customerService.getCustomerOrderById(order_id);
        if (order == null){
            return ResponseEntity.notFound().build();
        }

        Long targetOrderCustomerId = order.getCustomerId();

        if (targetOrderCustomerId != customer_id){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(order);

    }

}
