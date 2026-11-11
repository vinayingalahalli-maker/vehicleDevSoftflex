package com.vehicleservice.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vehicleservice.app.dto.CreateVehicleRequest;
import com.vehicleservice.app.dto.UpdateVehicleRequest;
import com.vehicleservice.app.exception.VehicleNotFoundException;
import com.vehicleservice.app.service.VehicleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(VehicleController.class)
class VehicleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    VehicleService vehicleService;

    // -------------------------------------------------------------------------
    // GET /vehicles
    // -------------------------------------------------------------------------

    @Test
    void getAllVehicles_returns200() throws Exception {
        List<Map<String, Object>> vehicles = List.of(
            Map.of("id", 1, "nickName", "The Lisa Marie", "vin", "4M2DV11W4RDJ53329",
                   "make", "Mercury", "model", "Villager", "year", "1994", "miles", 159864)
        );
        when(vehicleService.getAllVehicles()).thenReturn(vehicles);

        mockMvc.perform(get("/vehicles").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].nickName").value("The Lisa Marie"));
    }

    // -------------------------------------------------------------------------
    // POST /vehicles
    // -------------------------------------------------------------------------

    @Test
    void createVehicle_returns201() throws Exception {
        CreateVehicleRequest req = CreateVehicleRequest.builder()
            .nickName("The Lisa Marie")
            .vin("4M2DV11W4RDJ53329")
            .make("Mercury")
            .model("Villager")
            .year("1994")
            .miles(159864L)
            .build();

        Map<String, Object> created = Map.of("id", 1, "nickName", "The Lisa Marie");
        when(vehicleService.createVehicle(any())).thenReturn(created);

        mockMvc.perform(post("/vehicles")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(req)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    void createVehicle_missingVin_returns400() throws Exception {
        CreateVehicleRequest req = CreateVehicleRequest.builder()
            .nickName("Test")
            .make("Ford")
            .model("F-150")
            .year("2020")
            .miles(10000L)
            .build(); // vin is missing

        mockMvc.perform(post("/vehicles")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(req)))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.fieldErrors[0].field").value("vin"));
    }

    // -------------------------------------------------------------------------
    // GET /vehicles/{id}
    // -------------------------------------------------------------------------

    @Test
    void getVehicleById_returns200() throws Exception {
        Map<String, Object> vehicle = Map.of("id", 1, "nickName", "The Lisa Marie");
        when(vehicleService.getVehicleById("1")).thenReturn(vehicle);

        mockMvc.perform(get("/vehicles/1").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    void getVehicleById_notFound_returns404() throws Exception {
        when(vehicleService.getVehicleById("99"))
            .thenThrow(new VehicleNotFoundException("Vehicle with id '99' not found."));

        mockMvc.perform(get("/vehicles/99").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.message").value("Vehicle with id '99' not found."));
    }

    // -------------------------------------------------------------------------
    // PATCH /vehicles/{id}
    // -------------------------------------------------------------------------

    @Test
    void updateVehicle_returns200() throws Exception {
        UpdateVehicleRequest req = UpdateVehicleRequest.builder().miles(200000L).build();
        Map<String, Object> updated = Map.of("id", 1, "miles", 200000);
        when(vehicleService.updateVehicle(eq("1"), any())).thenReturn(updated);

        mockMvc.perform(patch("/vehicles/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(req)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.miles").value(200000));
    }

    // -------------------------------------------------------------------------
    // DELETE /vehicles/{id}
    // -------------------------------------------------------------------------

    @Test
    void deleteVehicle_returns204() throws Exception {
        doNothing().when(vehicleService).deleteVehicle("1");

        mockMvc.perform(delete("/vehicles/1"))
            .andExpect(status().isNoContent());
    }

    @Test
    void deleteVehicle_notFound_returns404() throws Exception {
        doThrow(new VehicleNotFoundException("Vehicle with id '99' not found."))
            .when(vehicleService).deleteVehicle("99");

        mockMvc.perform(delete("/vehicles/99"))
            .andExpect(status().isNotFound());
    }
}
