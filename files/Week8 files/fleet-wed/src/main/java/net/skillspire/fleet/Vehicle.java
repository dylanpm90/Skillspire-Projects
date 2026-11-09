package net.skillspire.fleet;

// POINT: Vehicle is the OWNING side of both its relationships: its table holds driver_id,
//        and its stations field names the join table.
// ASK:   "Why does driver_id go in the vehicles table and not in drivers?"

// LMS Entities and Relationships P3 (many-to-one), P4 (many-to-many), P6 (fetch types).
// Monday's entity, with two fields added: driver and stations.

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

    // ===== MANY-TO-ONE (LMS P3): many vehicles belong to one driver =====
    // OWNING side: the vehicles table gets a driver_id column, filled from THIS field only.
    @ManyToOne                            // a single object: EAGER by default (one row, read with the vehicle)
    @JoinColumn(name = "driver_id")
    private Driver driver;

    // ===== MANY-TO-MANY (LMS P4): a vehicle charges at many stations; a station serves many vehicles =====
    // OWNING side: this field names the join table, and Hibernate writes its rows from this list.
    // TODO 2: replace @Transient with the many-to-many mapping. Copy the shape of LMS P4 (student_course):
    //         @ManyToMany(fetch = FetchType.LAZY), then a @JoinTable named vehicle_stations
    //         with join column vehicle_id and inverse join column station_id.
    @ManyToMany(fetch = FetchType.LAZY)
// until TODO 2: Hibernate ignores this field (no column, no table, nothing saved)
    @JoinTable(
            name = "vehicle_stations",
            joinColumns = @JoinColumn(name = "vehicle_id"),
            inverseJoinColumns = @JoinColumn(name = "station_id"))
    private List<ChargingStation> stations = new ArrayList<>();
    // * PREDICT before running: how many rows will vehicle_stations get?
    // No cascade: stations are shared and exist on their own, so the runner saves them first.

    // JPA needs a no-argument constructor: Hibernate calls it for every row it reads.
    public Vehicle() {
    }

    // Ours, for the runner. No id: the database assigns it on save().
    public Vehicle(String model, int year) {
        this.model = model;
        this.year = year;
    }

    public void addStation(ChargingStation station) {
        stations.add(station);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<ChargingStation> getStations() {
        return stations;
    }

    @Override
    public String toString() {
        return id + ": " + model + " (" + year + ")";     // Monday's, unchanged: no driver here
    }
}
