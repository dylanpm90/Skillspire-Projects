package net.skillspire.products;

import jakarta.persistence.*;

// kinda acts like Profile from the wed code starter
// one to one
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String streetAddress;
    private String stateResidence;
    private int zipCode;

    public Address() {
    }

    public Address(
            String name,
            String streetAddress,
            String stateResidence,
            int zipCode) {
        this.name = name;
        this.streetAddress = streetAddress;
        this.stateResidence = stateResidence;
        this.zipCode = zipCode;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getStateResidence() {
        return stateResidence;
    }

    public int getZipCode() {
        return zipCode;
    }

    @Override
    public String toString() {
        String newLine = System.getProperty("line.separator");
        return name + newLine +
                streetAddress + newLine +
                stateResidence + newLine +
                zipCode + newLine +
                "________________________________" + newLine;

    }
}
