package net.skillspire.review;

// POINT: one Vehicle object = one row of the vehicles table. Fields match the columns by name.
// ASK:   "When we read rows from the database, who calls new Vehicle()?"
//        (BeanPropertyRowMapper, in VehicleRepository. Spring's JSON reader does it too for POST and PUT.)

// LMS Spring JDBC P3. The id is a Long, as in Monday's fleet project.

public class Vehicle {
    private Long id;         // column ID: the database picks it
    private String model;    // column MODEL
    private int year;        // column YEAR

    // Required: the row mapper and the JSON reader both call new Vehicle(), then the setters.
    public Vehicle() {
    }

    // Ours, for PlainJavaWiring. No id: it's assigned when the vehicle is saved.
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
