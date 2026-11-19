package net.skillspire.products;


import org.aspectj.weaver.ast.Or;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductRunner implements CommandLineRunner {
    private final ProductRepository productRepo;
    private final CustomerRepository customerRepo;
    private final OrderRepository orderRepo;
    private final CustomerService customerService;

    String newLine = System.getProperty("line.separator");

    public ProductRunner(
            ProductRepository productRepo,
            CustomerRepository customerRepo,
            OrderRepository orderRepo,
            CustomerService customerService) {
        this.productRepo = productRepo;
        this.customerRepo = customerRepo;
        this.orderRepo = orderRepo;
        this.customerService = customerService;
    }



    @Override
    public void run(String... args) {
        // customers
        Customer alice = new Customer("Alice");

        Customer bob = new Customer(
                "Bob"
        );

        Customer charlie = new Customer(
                "Charlie"
        );
        // products

        Product legendOfZeldaOOT = productRepo.save(new Product(
                "LoZ: Ocarina of Time",
                "adventure",
                69.99,
                100));
        Product eldenRing = productRepo.save(new Product(
                "Elden Ring",
                "adventure",
                69.99,
                50));
        Product theLastSpell = productRepo.save(new Product(
                "The Last Spell",
                "turn-based",
                19.99,
                20));
        Product superHot = productRepo.save(new Product(
                "Super Hot",
                "first person shooter",
                9.99,
                5
        ));
        Product halfLife2 = productRepo.save(new Product(
                "Half Life 2",
                "first person shooter",
                9.99,
                0));
        Product xCom2 = productRepo.save(new Product(
                "XCOM 2",
                "turn-based",
                15.99,
                50));
        Product discoElysium = productRepo.save(new Product(
                "Disco Elysium",
                "rpg",
                4.99,
                5));
        Product skyrim = productRepo.save(new Product(
                "Skyrim",
                "rpg",
                24.99,
                60
        ));
        // alice orders
        Order toAlice = new Order();
        Order toAlice2 = new Order();
        toAlice.addProduct(skyrim);
        toAlice2.addProduct(eldenRing);
        customerService.addCustomer(alice);
        alice.addOrder(toAlice);
        alice.addOrder(toAlice2);
        orderRepo.save(toAlice);
        orderRepo.save(toAlice2);

        // bob orders
        Order toBob = new Order();
        Order toBob2 = new Order();
        toBob.addProduct(superHot);
        toBob.addProduct(theLastSpell);
        toBob2.addProduct(skyrim);
        toBob2.addProduct(discoElysium);
        customerService.addCustomer(bob);
        bob.addOrder(toBob);
        bob.addOrder(toBob2);
        orderRepo.save(toBob);
        orderRepo.save(toBob2);
        System.out.println(toAlice);



        Order toCharlie = new Order();



        customerService.addCustomer(bob);
        customerService.addCustomer(charlie);

    }
}
