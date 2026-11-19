package net.skillspire.products;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", nullable = false, unique = true)
    private Profile profile;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    protected Customer() {
    }

    public Customer(String name, Profile profile) {
        this.name = Objects.requireNonNull(name);
        this.profile = Objects.requireNonNull(profile);
        profile.linkCustomer(this);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Profile getProfile() {
        return profile;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
        order.setCustomer(this);
    }


    @Override
    public String toString() {
        String newLine = System.getProperty("line.separator");
        return "________________________________" + newLine +
                "Customer ID: " + id + newLine +
                "Name: " + name + newLine +
                profile;
    }


}
