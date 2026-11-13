package net.skillspire.products;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

// 2. Define a JPA entity called `Product` with fields: `id`, `name`, `category`, `price`, and `stockQuantity`.
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    private double price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "products")     // optional back side
    private List<Order> orders = new ArrayList<>();

    public Product() {
    }

    public Product(String name, String category, double price, int stockQuantity) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @Override
    public String toString() {
        String newLine = System.getProperty("line.separator");
        return  newLine+
                "| Name: " + name + newLine +
                "| Category: " + category + newLine +
                "| Price: " + price + newLine +
                "| Qty: " + stockQuantity + newLine +
                "| id: " + id + newLine +
                "________________________________" + newLine;
    }


}


