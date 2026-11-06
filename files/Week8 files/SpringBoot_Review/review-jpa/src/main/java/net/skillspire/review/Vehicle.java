package net.skillspire.review;

// POINT: CHANGED from review-jdbc: annotations only. With @Entity, this class IS the table
//        definition: Hibernate creates the vehicles table from it, so schema.sql is gone.
// ASK:   "In review-jdbc, where was CREATE TABLE? Where is it now?"

// LMS Spring Data JPA P3. Monday's fleet Vehicle.

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity                       // SPOT THE BUG: comment out this line and run. (Startup fails: "Not a managed type")
@Table(name = "vehicles")     // without @Table the table would be named after the class: vehicle
public class Vehicle {

    @Id                                                    // the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)    // the database picks the id: 1, 2, 3...
    private Long id;                                       // null means "not saved yet"

    private String model;     // each field becomes a column
    private int year;

    // JPA needs a no-argument constructor: Hibernate calls it for every row it reads.
    public Vehicle() {
    }

    // Ours, for VehicleRunner. No id: the database assigns it on save().
    public Vehicle(String model, int year) {
        this.model = model;
        this.year = year;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    @Override
    public String toString() {
        return id + ": " + model + " (" + year + ")";
    }
}
