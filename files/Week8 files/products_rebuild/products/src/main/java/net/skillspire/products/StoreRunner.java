package net.skillspire.products;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StoreRunner implements CommandLineRunner {
    private final ProductRepository productRepo;
    private final CustomerRepository customerRepo;
    private final OrderRepository orderRepo;
    private final ProductService productService;
    private final CustomerService customerService;
    private final OrderService orderService;

    String newLine = System.getProperty("line.separator");

    public StoreRunner(
            ProductRepository productRepo,
            CustomerRepository customerRepo,
            OrderRepository orderRepo,
            ProductService productService,
            CustomerService customerService,
            OrderService orderService) {
        this.productRepo = productRepo;
        this.customerRepo = customerRepo;
        this.orderRepo = orderRepo;
        this.productService = productService;
        this.customerService = customerService;
        this.orderService = orderService;
    }

    @Override
    public void run(String... args) {
        // customers
        Customer alice = customerService.addCustomer(new Customer(
                "Alice",
                new Profile(
                        "123 Apple Avenue",
                        "111-111-1111"
                )));


        Customer bob = customerService.addCustomer(new Customer(
                "Bob",
                new Profile(
                        "456 Baker Boulevard",
                        "222-222-2222"
                )));

        Customer charlie = customerService.addCustomer(new Customer(
                "Charlie",
                new Profile(
                        "789 Cobalt Street",
                        "333-333-3333"
                )));

        Customer daniel = customerService.addCustomer(new Customer(
                "Daniel",
                new Profile(
                        "101112 Danvers Drive",
                        "444-444-4444"
                )

        ));

        //products
        Product legendOfZeldaOOT = productService.addProduct(new Product(
                "LoZ: Ocarina of Time",
                "adventure",
                69.99,
                100));
        Product eldenRing = productService.addProduct(new Product(
                "Elden Ring",
                "adventure",
                69.99,
                50));
        Product theLastSpell = productService.addProduct(new Product(
                "The Last Spell",
                "turn-based",
                19.99,
                20));
        Product superHot = productService.addProduct(new Product(
                "Super Hot",
                "first person shooter",
                9.99,
                5
        ));
        Product halfLife2 = productService.addProduct(new Product(
                "Half Life 2",
                "first person shooter",
                9.99,
                0));
        Product xCom2 = productService.addProduct(new Product(
                "XCOM 2",
                "turn-based",
                15.99,
                50));
        Product discoElysium = productService.addProduct(new Product(
                "Disco Elysium",
                "rpg",
                4.99,
                5));
        Product skyrim = productService.addProduct(new Product(
                "Skyrim",
                "rpg",
                24.99,
                60
        ));

        // alice's orders
        Order toAlice1 = new Order();
        toAlice1.addProduct(skyrim);
        Order toAlice2 = new Order();
        toAlice2.addProduct(discoElysium);
        toAlice2.addProduct(eldenRing);
        alice.addOrder(toAlice1);
        alice.addOrder(toAlice2);
        orderService.addOrder(toAlice1);
        orderService.addOrder(toAlice2);

        // bob's orders
        Order toBob1 = new Order();
        toBob1.addProduct(legendOfZeldaOOT);
        toBob1.addProduct(theLastSpell);
        toBob1.addProduct(eldenRing);
        bob.addOrder(toBob1);
        orderService.addOrder(toBob1);

        //test
        System.out.println("Alice's info and orders");
        System.out.println(alice);
        System.out.println(toAlice1);
        System.out.println(toAlice2);
        System.out.println("++++++++++++++++++++++++");

        System.out.println("Bob's info and orders");
        System.out.println(bob);
        System.out.println(toBob1);
        System.out.println("++++++++++++++++++++++++");

    }

}
