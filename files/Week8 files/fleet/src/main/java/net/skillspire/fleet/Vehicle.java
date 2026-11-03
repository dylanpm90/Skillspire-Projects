package net.skillspire.fleet;

// POINT: an @Entity class IS the table definition. Hibernate creates the vehicles table from it.
// ASK:   "Last week we wrote CREATE TABLE in schema.sql. Where is it now?"

// LMS Spring Data JPA P3 (Creating Entity Classes). No schema.sql this week.

import jakarta.persistence.*;

@Entity                       // * SPOT THE BUG: comment out this line and run.
@Table(name = "vehicles")     // without @Table, the table would be named after the class: vehicle
public class Vehicle {

    @Id                                                    // the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)    // the database picks the id: 1, 2, 3...
    private Long id;                                       // Long, not int: null means "not saved yet"

    private String model;     // each field becomes a column
    private int year;         // column "year": the H2 URL needs NON_KEYWORDS=YEAR

    // JPA needs a no-argument constructor: Hibernate calls it for every row it reads.
    public Vehicle() {
    }

    // Ours, for the runner. No id: the database assigns it on save().
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

    // EXTRA SPOT THE BUG: in application.properties delete  ;NON_KEYWORDS=YEAR  and run.
}
