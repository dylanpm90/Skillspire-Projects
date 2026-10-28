package week6.fri;

import java.util.ArrayList;

// POINT: a FleetManager HAS MANY TeslaCars: a private list, like Monday's Order with its products.
//        One loop runs diagnostics on every car, and each car checks itself.
// ASK:   "Why does FleetManager hold a list of cars instead of extending ArrayList?"
// LINK:  uses TeslaCar and Battery from TeslaVehicles.java (same package).
// CHECKS: 2 in this file; the * one is required, the other is a reserve.

// LMS Modeling Tesla's Back-End P8 (fleet management); Worksheet C Q13, Q19

class FleetManager {
    private ArrayList<TeslaCar> fleet = new ArrayList<>();   // HAS MANY TeslaCars

    void addCar(TeslaCar car) {
        fleet.add(car);
    }

    void runDiagnostics() {
        for (TeslaCar car : fleet) {
            car.diagnostics();
        }
    }

    // ===== Section 2: sort with a lambda (Worksheet C Q19) =====
    void sortByYear() {
        fleet.sort((a, b) -> Integer.compare(a.getYear(), b.getYear()));   // Comparator: one method, compare(a, b)
    }

    void printFleet() {
        for (TeslaCar car : fleet) {
            System.out.println("  " + car);         // toString()
        }
    }
}

public class TeslaFleet {
    public static void main(String[] args) {

        // ----- Section 1: a fleet (LMS P8) -----
        System.out.println("--- 1. A fleet ---");
        FleetManager manager = new FleetManager();
        manager.addCar(new TeslaCar("VIN003", "Model Y", 2023, new Battery(75, 99)));
        manager.addCar(new TeslaCar("VIN001", "Model 3", 2019, new Battery(75, 92)));
        manager.addCar(new TeslaCar("VIN002", "Model S", 2021, new Battery(100, 88)));
        manager.runDiagnostics();       // * PREDICT before running: how many lines, in what order?

        // ----- Section 2: sorted by year (optional) -----
        System.out.println("--- 2. Sorted by year ---");
        manager.sortByYear();
        manager.printFleet();           // PREDICT: the order after sorting
    }
}
