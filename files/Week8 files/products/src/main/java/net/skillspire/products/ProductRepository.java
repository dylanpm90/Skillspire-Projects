package net.skillspire.products;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// 3. Create a `ProductRepository` interface that extends `JpaRepository<Product, Long>`.
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(String category);

    List<Product> findByPriceLessThan(double price);

    List<Product> findByStockQuantity(int stockQuantity);

    @Query("SELECT p FROM Product p WHERE p.name = ?1")
    List<Product> findProductByName(String name);

    @Query(value = "SELECT AVG(p.price) FROM Product p")
    double findAveragePrice();

}
