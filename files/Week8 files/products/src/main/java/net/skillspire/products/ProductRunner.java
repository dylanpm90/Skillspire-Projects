package net.skillspire.products;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/*
4. Implement the following using Spring Data JPA's query derivation and/or
 `@Query`:
   - Find all products in a given category.
   - Find all products with a price less than a given value.
   - Find all products that are out of stock (`stockQuantity = 0`).
   - A custom `@Query` (JPQL or native SQL) that returns the average price
   of products per category.
5. Write a `CommandLineRunner` (or a simple test class) that saves at least
 8 sample products and calls each of the methods above, printing the results
 to the console.

 */
@Component
public class ProductRunner implements CommandLineRunner {
    private final ProductRepository repo;

    public ProductRunner(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {
        repo.save(new Product(
                "LoZ: Ocarina of Time",
                "adventure",
                69.99,
                100));
        repo.save(new Product(
                "Elden Ring",
                "adventure",
                69.99,
                50));
        repo.save(new Product(
                "The Last Spell",
                "turn-based",
                19.99,
                20));
        repo.save(new Product(
                "Super Hot",
                "first person shooter",
                9.99,
                5
        ));
        repo.save(new Product(
                "Half Life 2",
                "first person shooter",
                9.99,
                0));
        repo.save(new Product(
                "XCOM 2",
                "turn-based",
                15.99,
                50));
        repo.save(new Product(
                "Disco Elysium",
                "rpg",
                4.99,
                5));
        repo.save(new Product(
                "Skyrim",
                "rpg",
                24.99,
                60
        ));
        System.out.println("_____________________________");
        System.out.println("All:" + repo.findAll());
        System.out.println("_____________________________");
        System.out.printf("\n" +
                "All by category:" + "\n" +
                "Adventure: " + repo.findByCategory("adventure") +
                "\n" +
                "First Person Shooter: " + repo.findByCategory("first person shooter"));
        System.out.println("_____________________________");
        System.out.printf("\n" +
                "All products less than $50:" + repo.findByPriceLessThan(50.00));
        System.out.println(" ");
        System.out.println("_____________________________");
        System.out.println("Find by 0 Stock: " + repo.findByStockQuantity(0));
        System.out.println("_____________________________");
        System.out.println("Find average price: $" + repo.findAveragePrice());
        System.out.println("_____________________________");
        System.out.println("Find by name @QUERY: 'Elden Ring'" + repo.findProductByName("Elden Ring"));

    }

}
