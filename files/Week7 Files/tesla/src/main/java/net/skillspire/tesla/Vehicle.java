package net.skillspire.tesla;

// Point: one Vehicle object = one row of the vehicles table.
//        The columns ID, MODEL, YEAR match the fields id, model, year by name.
// Ask:   "We never write new Vehicle() for the rows we read. Who does?"

// LMS Spring JDBC P3. Not Friday's abstract Vehicle: this one is plain data, one row.

public class Vehicle {
    private int id;          // column ID: the database picks it
    private String model;    // column MODEL
    private int year;        // column YEAR

    // Needed twice tonight: BeanPropertyRowMapper (reading rows) and Spring's JSON reader
    // (POST and PUT bodies) both call new Vehicle(), then the setters.
    public Vehicle() {
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getYear() { return year; }
    // EXTRA SPOT THE BUG: rename  setYear  to  setModelYear  and run again, then open /vehicles. What changed?
    public void setYear(int year) { this.year = year; }
}
