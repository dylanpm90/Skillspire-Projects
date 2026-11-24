package net.skillspire.fleet;

// POINT: Wednesday's Vehicle, plus @JsonBackReference on driver. The REST API returns Vehicle objects
//        as JSON; without it, vehicle -> driver -> vehicles -> driver ... never ends.
// ASK:   "Wednesday's rule was toString() in one direction only. What's the same rule for JSON?"

// LMS Params and Path Variables P5. Entities and Relationships P3, P4, P6, P9.

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private int year;         // column "year": the H2 URL needs NON_KEYWORDS=YEAR

    // MANY-TO-ONE (Wednesday): the owning side; the vehicles table has driver_id.
    @JsonBackReference        // new today: JSON leaves this side out, so the loop stops here
    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;
    // * SPOT THE BUG: comment out  @JsonBackReference , restart, GET /api/vehicles/1. Put it back before any POST.

    // MANY-TO-MANY (Wednesday): LAZY. In a web request the session stays open, so JSON can still read it.
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "vehicle_stations",
            joinColumns = @JoinColumn(name = "vehicle_id"),
            inverseJoinColumns = @JoinColumn(name = "station_id"))
    private List<ChargingStation> stations = new ArrayList<>();

    // JPA needs it, and so does Jackson: @RequestBody builds a Vehicle with it, then calls the setters.
    public Vehicle() {
    }

    public Vehicle(String model, int year) {
        this.model = model;
        this.year = year;
    }

    public void addStation(ChargingStation station) {
        stations.add(station);
    }

    // Jackson writes JSON from the getters: id, model, year, stations (driver is left out).
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public Driver getDriver() { return driver; }
    public void setDriver(Driver driver) { this.driver = driver; }

    public List<ChargingStation> getStations() { return stations; }

    @Override
    public String toString() {
        return id + ": " + model + " (" + year + ")";
    }
}
