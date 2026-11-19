package net.skillspire.products;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
// acts kinda like Driver from wed starter code

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private Address address;

@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
private List<Order> orders = new ArrayList<>();
    public void addOrder(Order order) {
        orders.add(order);
    }

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
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

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public List<Order> getOrders() {
        return orders;
    }


    @Override
    public String toString() {
        String newLine = System.getProperty("line.separator");
        return  name + newLine +
                "Address: " + newLine +
                address + newLine;
    }

}
