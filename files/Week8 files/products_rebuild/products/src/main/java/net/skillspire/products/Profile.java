package net.skillspire.products;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private String phone;

    @JsonIgnore
    @OneToOne(mappedBy = "profile")
    private Customer customer;

    protected Profile() {
    }

    public Profile(String address, String phone) {
        this.address = address;
        this.phone = phone;
    }

    void linkCustomer(Customer customer) {
        if (this.customer != null && this.customer != customer) {
            throw new IllegalArgumentException("A profile cannot be shared by customers");
        }
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        String newLine = System.getProperty("line.separator");
        return
                "Address: " + address + newLine +
                "Phone #:" + phone + newLine +
                "________________________________";
    }

}

