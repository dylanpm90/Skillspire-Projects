package net.skillspire.relationships;

// Plain classroom rules. No hardware, authentication or external billing service.
public class TeslaService {
    private final VehicleService vehicles;

    public TeslaService(VehicleRepository repo) {
        this.vehicles = new VehicleService(repo);
    }

    public String unlockVehicle(Long id) {
        Vehicle vehicle = vehicles.getVehicle(id);
        return "Unlocked " + vehicle.getModel();
    }

    // Whole kWh and whole cents only; small classroom inputs, no tariffs or tax.
    public int chargingCostCents(int kwh, int centsPerKwh) {
        // TODO 1: Write calculatesChargingCost in ChargingCostTest first; run it red.


        // TODO 2: Green: handle kwh == 0 explicitly, otherwise return kwh * centsPerKwh.


        // TODO 3: Refactor: remove that redundant zero branch; rerun the same tests.


        // TODO 4: Write rejectsNegativeEnergy and rejectsNonpositiveRate, run red,
        // then reject kwh < 0 and centsPerKwh <= 0 before returning the product.
        // Messages: "Energy must not be negative" and "Rate must be positive".


        return 0; // Intentional starting behavior, not the completed calculation.
    }
}
