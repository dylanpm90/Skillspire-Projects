package net.skillspire.products;

import jakarta.persistence.*;
// 2. Define a JPA entity called `Product` with fields: `id`, `name`, `category`, `price`, and `stockQuantity`.
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String name;
    String category;
    double price;
    int stockQuantity;


}
