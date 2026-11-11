package net.skillspire.products;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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


    // create products
    @Override
    public void run(String... args) {
        // orders
        Order toAlice = orderRepo.save(new Order("high"));
        Order toBob = orderRepo.save(new Order("normal"));
        Order toCharlie = orderRepo.save(new Order("low"));
        toAlice.addProduct(new Product(
                "LoZ: Ocarina of Time",
                "adventure",
                69.99,
                100));
        toAlice.addProduct(new Product(
                "Elden Ring",
                "adventure",
                69.99,
                50));
        toBob.addProduct(new Product(
                "The Last Spell",
                "turn-based",
                19.99,
                20));
        toBob.addProduct(new Product(
                "XCOM 2",
                "turn-based",
                15.99,
                50));
        toCharlie.addProduct(new Product(
                "LoZ: Ocarina of Time",
                "adventure",
                69.99,
                100));
        toCharlie.addProduct(new Product(
                "XCOM 2",
                "turn-based",
                15.99,
                50));
        toCharlie.addProduct(new Product(
                "The Last Spell",
                "turn-based",
                19.99,
                20));
        // products
//        productRepo.save(new Product(
//                "LoZ: Ocarina of Time",
//                "adventure",
//                69.99,
//                100));
//        productRepo.save(new Product(
//                "Elden Ring",
//                "adventure",
//                69.99,
//                50));
//        productRepo.save(new Product(
//                "The Last Spell",
//                "turn-based",
//                19.99,
//                20));
//        productRepo.save(new Product(
//                "Super Hot",
//                "first person shooter",
//                9.99,
//                5
//        ));
//        productRepo.save(new Product(
//                "Half Life 2",
//                "first person shooter",
//                9.99,
//                0));
//        productRepo.save(new Product(
//                "XCOM 2",
//                "turn-based",
//                15.99,
//                50));
//        productRepo.save(new Product(
//                "Disco Elysium",
//                "rpg",
//                4.99,
//                5));
//        productRepo.save(new Product(
//                "Skyrim",
//                "rpg",
//                24.99,
//                60
//        ));

        // customers
        Customer alice = new Customer(
                "Alice",
                new Address(
                        "Alice",
                        "123 Apple Blvd",
                        "TX",
                        78861
                ));
        alice.addOrder(toAlice);
        Customer bob = new Customer(
                "Bob",
                new Address(
                        "Bob",
                        "456 Baker St",
                        "NY",
                        10101
                ));
        bob.addOrder(toBob);
        Customer charlie = new Customer(
                "Charlie",
                new Address(
                        "Charlie",
                        "789 Cobalt Ave",
                        "CA",
                        55555
                ));
        charlie.addOrder(toCharlie);

        System.out.println("Alice's order:");
        System.out.println(toAlice + newLine);

        System.out.println("Bob's order:");
        System.out.println(toBob + newLine);

        System.out.println("Charlie's order:");
        System.out.println(toCharlie + newLine);
    }
}
