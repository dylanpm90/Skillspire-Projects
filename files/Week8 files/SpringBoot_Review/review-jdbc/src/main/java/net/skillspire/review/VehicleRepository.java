package net.skillspire.review;

// POINT: layer 3, the database layer. ALL the SQL lives here. JdbcTemplate gets a connection,
//        fills in each ?, runs the SQL, turns rows into Vehicles, and closes everything.
// ASK:   "We never wrote new JdbcTemplate(). Who made the one this constructor receives?"
//        (Spring Boot: JDBC API and H2 are in pom.xml, so it autoconfigured one.)

// LMS Spring JDBC P2 (JdbcTemplate) and P4 (CRUD). Week 7 Wednesday's file, TODOs done.

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository   // like @Service: "Spring, create one of these". @Repository marks the database layer.
public class VehicleRepository {

    private final JdbcTemplate jdbcTemplate;

    public VehicleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        System.out.println(">> VehicleRepository created by Spring, got a JdbcTemplate");
    }

    // READ all: query() returns a List, one Vehicle per row
    public List<Vehicle> getAllVehicles() {
        String sql = "SELECT * FROM vehicles";
        // For each row: new Vehicle(), then setId, setModel, setYear (matched by name)
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Vehicle.class));
    }

    // READ one: queryForObject() expects exactly one row. No row: it throws EmptyResultDataAccessException.
    public Vehicle getVehicleById(Long id) {
        String sql = "SELECT * FROM vehicles WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Vehicle.class), id);
    }

    // CREATE: update() runs INSERT, UPDATE and DELETE. The values fill the ?s in order.
    // It returns how many rows changed.
    public int addVehicle(Vehicle v) {
        String sql = "INSERT INTO vehicles (model, year) VALUES (?, ?)";
        return jdbcTemplate.update(sql, v.getModel(), v.getYear());
    }

    // UPDATE: 1 if the car was found, 0 if not
    public int updateVehicle(Vehicle v) {
        String sql = "UPDATE vehicles SET model = ?, year = ? WHERE id = ?";
        return jdbcTemplate.update(sql, v.getModel(), v.getYear(), v.getId());
    }

    // DELETE: careful, a DELETE without WHERE deletes every row
    public int deleteVehicle(Long id) {
        String sql = "DELETE FROM vehicles WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
