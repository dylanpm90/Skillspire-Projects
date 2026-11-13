package net.skillspire.fleet;

// POINT: a repository test needs a REAL database: a mock can't tell you whether a query is right.
//        @DataJpaTest loads only JPA, runs against H2, and rolls back after each test.
// ASK:   "Why is there no data at the start, when FleetRunner saves three vehicles?"

// LMS Testing Controllers, Services, and Repositories P3. Assignment 2 Part 2, item 3 (two custom queries).

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

// Fleet only: @DataJpaTest normally swaps in its own H2 database, which lacks our URL's NON_KEYWORDS=YEAR,
// so the "year" column fails. This keeps our application.properties database. (LMS projects don't need it.)
@DataJpaTest(properties = "spring.test.database.replace=none")
class VehicleRepositoryTest {

    @Autowired
    private VehicleRepository repo;

    @Autowired
    private DriverRepository driverRepo;

    // ===== Custom query 1: a derived query with two conditions =====
    @Test
    void findByModelAndMinYearFilters() {
        repo.save(new Vehicle("Model S", 2019));
        repo.save(new Vehicle("Model S", 2023));
        repo.save(new Vehicle("Model 3", 2023));

        List<Vehicle> results = repo.findByModelAndYearGreaterThanEqual("Model S", 2020);

        assertEquals(1, results.size());
        assertEquals(2023, results.get(0).getYear());
    }

    // ===== Custom query 2: Friday's ownership check (driver.id through the relationship) =====
    @Test
    void findByIdAndDriverIdOnlyFindsThatDriversVehicle() {
        Driver alice = new Driver("Alice", new Profile("206-555-0101", "Seattle"));
        Driver bob = new Driver("Bob", new Profile("253-555-0102", "Tacoma"));
        Vehicle model3 = new Vehicle("Model 3", 2021);
        alice.addVehicle(model3);
        driverRepo.save(alice);           // cascade saves the vehicle too
        driverRepo.save(bob);

        assertTrue(repo.findByIdAndDriverId(model3.getId(), alice.getId()).isPresent());
        assertTrue(repo.findByIdAndDriverId(model3.getId(), bob.getId()).isEmpty());   // not Bob's: empty
    }
}
