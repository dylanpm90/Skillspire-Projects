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
        // customers
        Customer alice = new Customer(
                "Alice",
                new Address(
                        "Alice",
                        "123 Apple Blvd",
                        "TX",
                        78861
                ));

        Customer bob = new Customer(
                "Bob",
                new Address(
                        "Bob",
                        "456 Baker St",
                        "NY",
                        10101
                ));

        Customer charlie = new Customer(
                "Charlie",
                new Address(
                        "Charlie",
                        "789 Cobalt Ave",
                        "CA",
                        55555
                ));
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
        // orders
        Order toAlice = new Order("High");
        toAlice.setCustomer(alice);
        toAlice.addProduct(legendOfZeldaOOT);
        System.out.println(toAlice);

    }
}
