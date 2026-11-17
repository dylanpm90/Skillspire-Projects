package net.skillspire.relationships;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // TODO 1: Mark this field as a one-to-one relationship.
    //         Every customer must have a profile (not optional), and saving or
    //         deleting a customer should do the same to its profile (cascade all).
    // TODO 2: Customer owns the foreign key. Name the column "profile_id",
    //         make it required, and make it unique so no two customers share a profile.
    private Profile profile;

    protected Customer() {
    }

    public Customer(String name, Profile profile) {
        this.name = Objects.requireNonNull(name);
        this.profile = Objects.requireNonNull(profile);
        profile.linkCustomer(this);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Profile getProfile() {
        return profile;
    }
}
