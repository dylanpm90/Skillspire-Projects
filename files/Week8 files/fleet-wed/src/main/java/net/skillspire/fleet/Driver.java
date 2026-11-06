package net.skillspire.fleet;

// POINT: a relationship is a field. The annotation says which kind; the OWNING side decides
//        where the foreign key goes, and only the owning side writes it.
// ASK:   "The runner saved 3 vehicles. Why did Alice have none before TODO 1?"

// LMS Entities and Relationships P2 (one-to-one), P3 (one-to-many), P5 (cascade), P6 (fetch), P9 (mistakes)

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

    // ===== ONE-TO-ONE (LMS P2): a driver has one profile =====
    // Owning side: the drivers table gets a profile_id column.
    // cascade ALL (LMS P5): saving or deleting a driver also saves or deletes the profile.
    @OneToOne(cascade = CascadeType.ALL)        // SPOT THE BUG: change this line to  @OneToOne  and run.
    @JoinColumn(name = "profile_id")
    private Profile profile;                    // a single object: EAGER by default

    // ===== ONE-TO-MANY (LMS P3): a driver owns many vehicles =====
    // mappedBy = "driver": the real mapping is the field named driver in Vehicle. This list only mirrors it.
    // cascade ALL: saving a driver also saves the vehicles in this list.
    // LAZY: the default for lists, written out to show the choice. The vehicles load only when the list is used.
    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Vehicle> vehicles = new ArrayList<>();
    // SPOT THE BUG (Sean only): delete  mappedBy = "driver",  and run. Look for one more  create table  line.

    // JPA needs a no-argument constructor (Monday).
    public Driver() {
    }

    public Driver(String name, Profile profile) {
        this.name = name;
        this.profile = profile;
    }

    // Keeps BOTH sides in sync (LMS P9). The list is for Java; Vehicle.driver is what fills driver_id.
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        // * PREDICT before TODO 1: the runner saves 3 vehicles. What will Alice's list show when we read her back?
        // TODO 1: one line: set the vehicle's driver to this driver (Vehicle has setDriver).
        vehicle.setDriver(this);
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

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    @Override
    public String toString() {
        return name + " (" + profile + ")";     // no vehicles here, and Vehicle's toString() has no driver
    }
    // EXTRA SPOT THE BUG: add  + " " + vehicles  to this toString() and  + " by " + driver  to Vehicle's. Run.
}
