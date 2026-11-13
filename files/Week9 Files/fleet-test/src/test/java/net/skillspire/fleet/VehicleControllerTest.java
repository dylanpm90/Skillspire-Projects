package net.skillspire.fleet;

// POINT: the same @WebMvcTest idea for the REST controller (VehicleController, /api/vehicles): the answer is JSON, not a view.
//        jsonPath reads one field of the JSON response. A JSON request body uses .content(...), not .param(...).
// ASK:   "The page test checked a view name. What does a REST test check instead?"

// LMS Testing Controllers, Services, and Repositories P1, "Controller test for a REST API".
// Not taught in class: self-study and lab. In the LMS the page tests are VehicleControllerTest; here VehicleController is the REST class.

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(VehicleController.class)
class VehicleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private VehicleService service;

    @Test
    void getVehicleReturnsJson() throws Exception {
        Vehicle modelS = new Vehicle("Model S", 2019);
        modelS.setId(1L);
        when(service.getVehicle(1L)).thenReturn(modelS);

        mockMvc.perform(get("/api/vehicles/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.model").value("Model S"))     // $.model = the "model" field of the JSON
                .andExpect(jsonPath("$.year").value(2019));
    }

    @Test
    void unknownVehicleReturns404() throws Exception {
        when(service.getVehicle(99L)).thenReturn(null);               // our service: null means not found

        mockMvc.perform(get("/api/vehicles/99"))
                .andExpect(status().isNotFound());                    // no view here: just the status
    }

    @Test
    void postJsonCreatesTheVehicle() throws Exception {
        Vehicle saved = new Vehicle("Model X", 2025);
        saved.setId(4L);
        when(service.addVehicle(any(Vehicle.class))).thenReturn(saved);

        mockMvc.perform(post("/api/vehicles")
                        .contentType(MediaType.APPLICATION_JSON)      // a JSON body, like Apidog sends
                        .content("{\"model\": \"Model X\", \"year\": 2025}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(4))
                .andExpect(jsonPath("$.model").value("Model X"));

        verify(service).addVehicle(any(Vehicle.class));
    }
}
