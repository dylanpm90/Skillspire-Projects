package net.skillspire.fleet;

// POINT: Wednesday's Driver, plus one JSON annotation. @JsonManagedReference marks the side Jackson writes;
//        Vehicle.driver (@JsonBackReference) is the side it leaves out, so the JSON can't loop.
// ASK:   "A vehicle points to its driver, and the driver lists the vehicle. What happens when Jackson follows both?"

// LMS Params and Path Variables P5 (the JSON loop). Entities and Relationships P2, P3, P5, P6, P9.

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // ONE-TO-ONE (Wednesday): the drivers table has profile_id; cascade saves the profile with the driver.
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    // ONE-TO-MANY (Wednesday): mappedBy = "driver", the real mapping is Vehicle.driver.
    @JsonManagedReference     // new today: JSON writes this side (no endpoint returns a Driver yet)
    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Vehicle> vehicles = new ArrayList<>();

    // JPA needs a no-argument constructor.
    public Driver() {
    }

    public Driver(String name, Profile profile) {
        this.name = name;
        this.profile = profile;
    }

    // Keeps BOTH sides in sync (Wednesday's TODO 1).
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        vehicle.setDriver(this);
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public Profile getProfile() { return profile; }
    public List<Vehicle> getVehicles() { return vehicles; }

    @Override
    public String toString() {
        return name + " (" + profile + ")";     // one direction only (Wednesday): no vehicles here
    }
}
