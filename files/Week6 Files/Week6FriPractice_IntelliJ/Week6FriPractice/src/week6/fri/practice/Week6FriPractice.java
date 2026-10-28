package week6.fri.practice;

import java.util.ArrayList;

// Week 6 Friday: in-class practice, modeling a Tesla back end.
// The file compiles and runs as given. Do each TODO when Sean says so.
// After each TODO: compile, read the error if there is one, fix it, run.

// ===== Given: an abstract Vehicle and a Battery =====

abstract class Vehicle {
    private final String vin;
    private String model;
    private int year;

    protected Vehicle(String vin, String model, int year) {
        this.vin = vin;
        this.model = model;
        this.year = year;
    }

    public String getVin() { return vin; }
    public String getModel() { return model; }
    public int getYear() { return year; }

    public abstract void diagnostics();
}

class Battery {
    private int capacity;   // kWh
    private int health;     // %

    Battery(int capacity, int health) {
        this.capacity = capacity;
        this.health = health;
    }

    void healthCheck() {
        System.out.println("  Battery health: " + health + "%");
    }
}

// TODO 1: uncomment the two lines below. A TeslaCar IS A Vehicle and HAS A Battery.
//         Give it a private Battery field and a constructor (vin, model, year, battery).
//         diagnostics() prints "Running diagnostics on Tesla <vin>", then asks its battery
//         for a healthCheck(). Then uncomment the TODO 1 lines in main.
// class TeslaCar extends Vehicle {
// }

// ===== Given: an abstract User and a Driver =====

abstract class User {
    private String name;
    private String email;

    User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    String getName() { return name; }

    abstract void accessSystem();
}

class Driver extends User {
    Driver(String name, String email) {
        super(name, email);
    }

    @Override
    void accessSystem() {
        System.out.println(getName() + " is driving with personalized settings.");
    }
}

// TODO 2: write  class Technician  that IS A User. accessSystem() prints
//         "<name> is performing diagnostics." Then uncomment the TODO 2 line in main.

// TODO 3 (after TODO 1): uncomment the class below and fill in both methods.
//         A FleetManager HAS MANY TeslaCars. Then uncomment the TODO 3 lines in main.
// class FleetManager {
//     private ArrayList<TeslaCar> fleet = new ArrayList<>();
//
//     void addCar(TeslaCar car) {
//         // add the car to the fleet
//     }
//
//     void runDiagnostics() {
//         // run diagnostics() on every car in the fleet
//     }
//
//     // TODO 4, only if there is time: a sortByYear() method that sorts the fleet,
//     //         oldest first, with a lambda:  fleet.sort((a, b) -> ...);
// }

public class Week6FriPractice {
    public static void main(String[] args) {

        System.out.println("--- 1. A TeslaCar ---");
        Battery battery = new Battery(75, 92);
        battery.healthCheck();
        // TeslaCar tesla = new TeslaCar("VIN001", "Model 3", 2019, battery);     // TODO 1
        // tesla.diagnostics();                                                  // TODO 1

        System.out.println("--- 2. Users ---");
        ArrayList<User> users = new ArrayList<>();
        users.add(new Driver("Alice", "alice@example.com"));
        // users.add(new Technician("Bob", "bob@example.com"));                  // TODO 2
        for (User u : users) {
            u.accessSystem();
        }

        System.out.println("--- 3. A fleet ---");
        // FleetManager manager = new FleetManager();                            // TODO 3
        // manager.addCar(tesla);                                                // TODO 3
        // manager.addCar(new TeslaCar("VIN002", "Model S", 2021, new Battery(100, 88)));  // TODO 3
        // manager.runDiagnostics();                                             // TODO 3
    }
}
