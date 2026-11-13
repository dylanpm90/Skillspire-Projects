package net.skillspire.fleet;

// POINT: @WebMvcTest loads Spring MVC and ONE controller: no service, no repository, no database.
//        MockMvc sends a fake request (no server); @MockitoBean puts a mock service into Spring.
//        The real Thymeleaf template still renders.
// ASK:   "The service is a mock. So what is this test actually checking?"

// LMS Testing Controllers, Services, and Repositories P1. Assignment 2 Part 2, item 5 (GET + form POST).

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(VehiclePageController.class)
class VehiclePageControllerTest {

    @Autowired
    private MockMvc mockMvc;              // sends fake HTTP requests to the controller

    @MockitoBean                          // Boot 4's replacement for @MockBean (Assignment 2 now says @MockitoBean)
    private VehicleService service;
    // * SPOT THE BUG (only if on time): change @MockitoBean to @Mock (Alt+Enter adds the org.mockito.Mock import) and run.
    //   Who gives the controller its service now? @Mock makes a plain Mockito mock; it does not put a bean into Spring.

    // ===== Section 1: GET pages (MVC P6) =====
    @Test
    void listPageShowsTheVehicles() throws Exception {
        Vehicle modelS = new Vehicle("Model S", 2019);
        modelS.setId(1L);                 // the template builds links from the id
        when(service.getAllVehicles()).thenReturn(List.of(modelS));

        mockMvc.perform(get("/vehicles"))
                .andExpect(status().isOk())
                .andExpect(view().name("vehicle-list"))
                .andExpect(model().attribute("vehicles", List.of(modelS)));
    }

    @Test
    void detailsPageShowsTheVehicle() throws Exception {
        Vehicle model3 = new Vehicle("Model 3", 2021);
        model3.setId(2L);
        when(service.getVehicle(2L)).thenReturn(model3);

        mockMvc.perform(get("/vehicles/2"))
                .andExpect(status().isOk())
                .andExpect(view().name("vehicle-details"))
                .andExpect(model().attribute("vehicle", model3));
    }

    // TODO 3: an unknown id gets the friendly 404 page (Monday's local @ExceptionHandler).
    //         Write unknownVehicleGetsTheNotFoundPage(): make service.getVehicle(99L) return null,
    //         perform GET /vehicles/99, expect status().isNotFound() and view().name("vehicle-not-found").

    // ===== Section 2: the form POST (Requests P5-P6). Form fields, so .param, not JSON =====
    @Test
    void addFormSavesAndRedirects() throws Exception {
        mockMvc.perform(post("/vehicles")
                        .param("model", "Model X")
                        .param("year", "2025"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/vehicles"))
                .andExpect(flash().attribute("message", "Vehicle added!"));

        verify(service).addVehicle(any(Vehicle.class));      // the controller handed A vehicle to the service (not checking its field values)
    }
    // * PREDICT (optional): in VehiclePageController, return "vehicle-list" instead of the redirect. Does this test stay green?
}
