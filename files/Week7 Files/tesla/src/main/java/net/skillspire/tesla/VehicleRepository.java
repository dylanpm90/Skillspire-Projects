package net.skillspire.tesla;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// Point: all the SQL lives here. JdbcTemplate gets a connection, fills in each ?, runs the SQL,
//        turns rows into Vehicle objects and closes everything. We write only the SQL and the values.
// Ask:   "Who made the JdbcTemplate this constructor receives?"

// LMS Spring JDBC P2 (JdbcTemplate), P4 (CRUD), P6 (errors)
// Starter file: you write TODO 1 (UPDATE) and TODO 2 (DELETE). It runs before you do.

@Repository   // like @Service: "Spring, create one of these". @Repository marks the database layer.
public class VehicleRepository {

    private final JdbcTemplate jdbcTemplate;

    // Monday's constructor injection. The LMS writes @Autowired on the field instead: same result.
    public VehicleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        System.out.println("  VehicleRepository created by Spring, got a JdbcTemplate");
    }

    // ===== READ: SELECT =====
    public List<Vehicle> getAllVehicles() {
        String sql = "SELECT * FROM vehicles";
        // For each row: new Vehicle(), then setId, setModel, setYear. Returns them in a List.
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Vehicle.class));
    }

    public Vehicle getVehicleById(int id) {
        String sql = "SELECT * FROM vehicles WHERE id = ?";
        // * PREDICT: open localhost:9090/vehicles/99 (there is no car 99). What do we see?
        // EXTRA SPOT THE BUG: change  FROM vehicles  to  FROM vehicle  above, run again, open /vehicles/1.
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Vehicle.class), id);
    }

    // ===== CREATE: INSERT =====
    public int addVehicle(Vehicle v) {
        String sql = "INSERT INTO vehicles (model, year) VALUES (?, ?)";
        // update() runs INSERT, UPDATE and DELETE. The values fill the ?s in order.
        // It returns how many rows changed.
        return jdbcTemplate.update(sql, v.getModel(), v.getYear());
    }

    // ===== UPDATE =====
    // TODO 1: change the model and year of the car with this id.
    //   a. String sql = "UPDATE vehicles SET ... WHERE ...";   a ? for each of the three values
    //   b. return jdbcTemplate.update(sql, ...);                the values in the same order as the ?s
    //   c. delete the  return 0;  line.   Pattern: addVehicle above.
    public int updateVehicle(Vehicle v) {
        String sql = "UPDATE vehicles SET model = ?, year = ? WHERE id = ?";
        return jdbcTemplate.update(sql, v.getModel(), v.getYear(), v.getId()); // TODO 1: "0 rows changed"
    }

    // ===== DELETE =====
    // TODO 2: delete the car with this id. Same steps as TODO 1, with one ?.
    //   Careful: a DELETE without WHERE deletes every row.
    public int deleteVehicle(int id) {
        String sql = "DELETE FROM vehicles WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
