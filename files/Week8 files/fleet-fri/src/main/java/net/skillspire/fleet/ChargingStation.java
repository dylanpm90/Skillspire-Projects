package net.skillspire.fleet;

// Wednesday's, unchanged.
// POINT: the other end of the many-to-many. Stations exist on their own and are shared by many vehicles.

// LMS Entities and Relationships P4 (many-to-many). One direction only, so no JSON loop here.

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
