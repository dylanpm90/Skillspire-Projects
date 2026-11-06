package net.skillspire.fleet;

// POINT: the other end of the many-to-many. Stations exist on their own and are shared by many vehicles.
// ASK:   "Deleting a vehicle: should it delete the Tacoma station too?"

// LMS Entities and Relationships P4 (many-to-many). One direction is enough tonight (LMS P11).
// The back side would be:  @ManyToMany(mappedBy = "stations") private List<Vehicle> vehicles = new ArrayList<>();

import jakarta.persistence.*;

@Entity
@Table(name = "charging_stations")
public class ChargingStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;

    public ChargingStation() {
    }

    public ChargingStation(String location) {
        this.location = location;
    }

    public Long getId() { return id; }
    public String getLocation() { return location; }

    @Override
    public String toString() {
        return location;
    }
}
