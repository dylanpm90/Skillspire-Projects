package net.skillspire.products;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

// kinda acts like ChargingStation in the starter code
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String priority;

    @ManyToMany
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products = new ArrayList<>();

    public Order() {
    }

    public Order(String priority) {
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public String getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Order Priority: " + priority;
    }
}
