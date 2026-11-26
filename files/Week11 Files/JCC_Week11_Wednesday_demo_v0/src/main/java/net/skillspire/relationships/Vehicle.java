package net.skillspire.relationships;

// Plain unit-test example, not a new JPA entity.
public class Vehicle {
    private final String model;
    private final int year;

    public Vehicle(String model, int year) {
        this.model = model;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
}
