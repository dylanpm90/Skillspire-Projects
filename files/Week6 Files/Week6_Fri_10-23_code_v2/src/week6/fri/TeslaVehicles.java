package week6.fri;

// POINT: a real system uses every tool from Weeks 5 and 6 at once. A TeslaCar IS A Vehicle (extends),
//        HAS A Battery and HAS AN updater (private fields). The updater field's type is an interface;
//        SoftwareUpdate is the class that implements it.
// ASK:   "A Tesla is a kind of vehicle, comes with a battery, and installs updates using an updater.
//         What does each look like in code?"
// LINK:  Monday's Car that has an Engine; Wednesday's abstract class and interfaces.
// CHECKS: 2 in this file; the * one is required, the other is a reserve.
//         EXTRA = only if a block finishes early.

// LMS Modeling Tesla's Back-End P2 (vehicles), P3 (battery), P4 (updates)

// ===== Section 1: Vehicle is the parent; TeslaCar IS A Vehicle and HAS A Battery (LMS P2, P3) =====

abstract class Vehicle {
    private final String vin;           // final: set once in the constructor, never changed
    private String model;
    private int year;

    protected Vehicle(String vin, String model, int year) {   // protected: children and the same package can call it
        this.vin = vin;
        this.model = model;
        this.year = year;
    }

    public String getVin() { return vin; }
    public String getModel() { return model; }
    public int getYear() { return year; }

    public abstract void diagnostics();  // every kind of vehicle checks itself its own way

    // EXTRA, SPOT THE BUG: uncomment. Week 5's final field again.
    // public void setVin(String vin) { this.vin = vin; }
}

class Battery {
    private int capacity;               // kWh. private: no outside code can fake a reading
    private int health;                 // %

    Battery(int capacity, int health) {
        this.capacity = capacity;
        this.health = health;
    }

    void healthCheck() {
        System.out.println("  Battery health: " + health + "%");
    }
}

// ===== Section 2: SoftwareUpdate CAN DO updates; TeslaCar HAS AN updater (LMS P4) =====

interface Updatable {
    void installUpdate(String version);
}

class SoftwareUpdate implements Updatable {     // the class that implements Updatable
    private String version;

    @Override
    public void installUpdate(String version) {
        this.version = version;
        System.out.println("  Installing Tesla software update: " + version);
    }
}

class TeslaCar extends Vehicle {        // IS A Vehicle. It does NOT implement Updatable.
    private Battery battery;            // HAS A Battery (Monday)
    private Updatable updater;          // HAS AN updater: a field whose type is an interface

    TeslaCar(String vin, String model, int year, Battery battery) {
        super(vin, model, year);        // SPOT THE BUG: comment out this line and compile
        this.battery = battery;
        this.updater = new SoftwareUpdate();   // made here. To swap in another updater, TeslaCar would
                                               // take an Updatable in its constructor, like Monday's Car(Engine engine)
    }

    @Override
    public void diagnostics() {
        System.out.println("Running diagnostics on Tesla " + getVin());
        battery.healthCheck();          // delegation: the car asks its battery
    }

    void updateSoftware(String version) {
        updater.installUpdate(version); // delegation: the car asks its updater
    }

    @Override
    public String toString() {
        return getModel() + " " + getYear() + " (" + getVin() + ")";
    }
}

public class TeslaVehicles {
    public static void main(String[] args) {

        // ----- Section 1 -----
        System.out.println("--- 1. A TeslaCar ---");
        TeslaCar tesla = new TeslaCar("VIN001", "Model 3", 2019, new Battery(75, 92));
        tesla.diagnostics();            // * PREDICT before running: the two lines

        // ----- Section 2 -----
        System.out.println("--- 2. A software update ---");
        tesla.updateSoftware("2025.9");
    }
}
