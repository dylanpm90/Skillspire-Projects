package net.skillspire.tesla;

// Point: @Service tells Spring "create one of these at startup and keep it." That object is a bean.
// Ask:   "Who calls this constructor?"

// Bridge, not in LMS lesson 1. Wednesday's JdbcTemplate (LMS JDBC lesson P2) and the
// Week 7 Worksheet's BankService get their parts exactly this way.

import org.springframework.stereotype.Service;

@Service    // SPOT THE BUG (run from StationController.java): comment out this line, then restart.
public class StationService {

    public StationService() {
        System.out.println("  StationService created by Spring");
    }

    public String status(String stationId) {
        return "Station " + stationId + ": 4 of 8 chargers free";
    }
}
