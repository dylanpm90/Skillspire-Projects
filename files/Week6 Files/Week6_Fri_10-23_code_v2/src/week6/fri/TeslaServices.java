package week6.fri;

import java.util.ArrayList;

// POINT: the same tools model the people and services around the cars. Users share a parent
//        (abstract class); payment types share a contract (interface); the station guards its state.
// ASK:   "To add Apple Pay tomorrow, which existing lines have to change?"
// LINK:  uses TeslaCar and Battery from TeslaVehicles.java (same package).
// CHECKS: 4 in this file; 2 are required (the run sheet's never-cut list), 2 are reserves.
//         * = the one to do if you only do one. EXTRA = only if a block finishes early.

// LMS Modeling Tesla's Back-End P5 (users), P6 (charging stations), P7 (payments), P10 (mistakes)

// ===== Section 1: every user IS A User; each accesses the system its own way (LMS P5) =====

abstract class User {
    private String name;                // the LMS leaves these open; P10 says keep them private
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

class Technician extends User {
    Technician(String name, String email) {
        super(name, email);
    }

    @Override
    void accessSystem() {
        System.out.println(getName() + " is performing diagnostics.");
    }
}

// ===== Section 2: a station that charges one car at a time (LMS P6) =====

class ChargingStation {
    private String location;
    private boolean available = true;   // private: only startCharging and stopCharging change it

    ChargingStation(String location) {
        this.location = location;
    }

    void startCharging(TeslaCar car) {
        if (available) {
            System.out.println("Charging Tesla " + car.getVin() + " at " + location);
            available = false;
        } else {
            System.out.println("Station busy at " + location);
        }
    }

    void stopCharging() {
        available = true;
    }

    // Section 3: takes ANY Payment, so it never names a payment class (Worksheet C Q12)
    void payForCharge(Payment p, double amount) {
        p.process(amount);
    }
}

// ===== Section 3: every payment type keeps one contract (LMS P7) =====

interface Payment {                     // Wednesday's contract again
    void process(double amount);
}

class CreditCardPayment implements Payment {
    @Override
    public void process(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}

class CryptoPayment implements Payment {
    @Override
    public void process(double amount) {
        System.out.println("Processing crypto payment of $" + amount);
    }
}

public class TeslaServices {
    public static void main(String[] args) {

        // ----- Section 1 -----
        System.out.println("--- 1. Users ---");
        ArrayList<User> users = new ArrayList<>();
        users.add(new Driver("Alice", "alice@example.com"));
        users.add(new Technician("Bob", "bob@example.com"));
        for (User u : users) {
            u.accessSystem();           // PREDICT: which accessSystem() runs for each?
        }

        // ----- Section 2 -----
        System.out.println("--- 2. One car at a time ---");
        ChargingStation station = new ChargingStation("Seattle");
        TeslaCar car1 = new TeslaCar("VIN001", "Model 3", 2019, new Battery(75, 92));
        TeslaCar car2 = new TeslaCar("VIN002", "Model S", 2021, new Battery(100, 88));
        station.startCharging(car1);
        station.startCharging(car2);    // * PREDICT before running: what happens to the second car?
        station.stopCharging();
        station.startCharging(car2);

        // SPOT THE BUG: uncomment. LMS P10, "not protecting data".
        // station.available = true;

        // ----- Section 3 -----
        System.out.println("--- 3. Paying for a charge ---");
        station.payForCharge(new CreditCardPayment(), 12.5);
        station.payForCharge(new CryptoPayment(), 12.5);    // PREDICT: the two lines

        // EXTRA, WRITE ONE CLASS: write  class ApplePayPayment implements Payment  and pay with it.
        //        Which existing lines had to change? (Worksheet C Q28)
    }
}
