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
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    public CustomerController(CustomerService customerService,
                              CustomerRepository customerRepository,
                              OrderRepository orderRepository){
        this.customerService = customerService;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping // get all customers
    public List<Customer>getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("customer_id") Long customer_id){
        Customer c = customerService.getCustomer(customer_id);

        if (c == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(c);
    }
//    @GetMapping("/{customer_id}/orders/{order_id}")
//    public ResponseEntity<Order> getCustomerByIdAndOrderById(@PathVariable("customer_id") Long customer_id,
//                                                                @PathVariable("order_id") Long order_id){
//        Customer c = customerService.getCustomer(customer_id);
//        Order o = customerService.getOrders(order_id);
//
//
//
//        if (c == null){
//            return ResponseEntity.notFound().build();
//        }
//
//        if(o == null){
//            return ResponseEntity.notFound().build();
//        }
//
//        return ResponseEntity.ok(o);
//    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer c){
        Customer saved = customerService.addCustomer(c);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long id, @RequestBody Customer c){
        Customer updated = customerService.updateCustomer(id, c);
        if (c == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(c);
    }

}
