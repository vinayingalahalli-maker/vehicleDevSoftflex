package com.vehicleservice.app.controller;

import com.vehicleservice.app.dto.CreateVehicleRequest;
import com.vehicleservice.app.dto.UpdateVehicleRequest;
import com.vehicleservice.app.service.VehicleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller exposing the Vehicle Service API.
 *
 * Endpoints:
 *   GET    /vehicles          – list all vehicles
 *   POST   /vehicles          – create a vehicle
 *   GET    /vehicles/{id}     – retrieve a vehicle
 *   PATCH  /vehicles/{id}     – partially update a vehicle
 *   DELETE /vehicles/{id}     – delete a vehicle
 */
@Slf4j
@RestController
@RequestMapping(value = "/vehicles", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name = "Vehicles", description = "CRUD operations for vehicle records")
public class VehicleController {

    private final VehicleService vehicleService;

    // -------------------------------------------------------------------------
    // GET /vehicles
    // -------------------------------------------------------------------------

    @Operation(summary = "Get all vehicles",
               description = "Retrieves a list of all vehicle records stored in the system.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Success – returns an array of vehicle objects"),
        @ApiResponse(responseCode = "500", description = "Unexpected server error")
    })
    @GetMapping
    public ResponseEntity<Object> getAllVehicles() {
        log.info("GET /vehicles");
        Object result = vehicleService.getAllVehicles();
        return ResponseEntity.ok(result);
    }

    // -------------------------------------------------------------------------
    // POST /vehicles
    // -------------------------------------------------------------------------

    @Operation(summary = "Create a vehicle",
               description = "Creates a new vehicle record in the system.")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Vehicle successfully created"),
        @ApiResponse(responseCode = "400", description = "Bad request – missing or invalid fields"),
        @ApiResponse(responseCode = "409", description = "Conflict – a vehicle with the same VIN already exists"),
        @ApiResponse(responseCode = "500", description = "Unexpected server error")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createVehicle(
            @Valid @RequestBody CreateVehicleRequest request) {
        log.info("POST /vehicles  vin={}", request.getVin());
        Object created = vehicleService.createVehicle(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // -------------------------------------------------------------------------
    // GET /vehicles/{id}
    // -------------------------------------------------------------------------

    @Operation(summary = "Retrieve a vehicle",
               description = "Retrieves a single vehicle record by its unique identifier.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Success – returns the vehicle object"),
        @ApiResponse(responseCode = "404", description = "Vehicle not found"),
        @ApiResponse(responseCode = "500", description = "Unexpected server error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Object> getVehicleById(
            @Parameter(description = "Unique identifier of the vehicle", required = true)
            @PathVariable String id) {
        log.info("GET /vehicles/{}", id);
        Object vehicle = vehicleService.getVehicleById(id);
        return ResponseEntity.ok(vehicle);
    }

    // -------------------------------------------------------------------------
    // PATCH /vehicles/{id}
    // -------------------------------------------------------------------------

    @Operation(summary = "Update a vehicle",
               description = "Partially updates an existing vehicle record. Only provided fields are updated.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Success – returns the updated vehicle object"),
        @ApiResponse(responseCode = "400", description = "Bad request – malformed body or invalid values"),
        @ApiResponse(responseCode = "404", description = "Vehicle not found"),
        @ApiResponse(responseCode = "500", description = "Unexpected server error")
    })
    @PatchMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateVehicle(
            @Parameter(description = "Unique identifier of the vehicle to update", required = true)
            @PathVariable String id,
            @Valid @RequestBody UpdateVehicleRequest request) {
        log.info("PATCH /vehicles/{}", id);
        Object updated = vehicleService.updateVehicle(id, request);
        return ResponseEntity.ok(updated);
    }

    // -------------------------------------------------------------------------
    // DELETE /vehicles/{id}
    // -------------------------------------------------------------------------

    @Operation(summary = "Delete a vehicle",
               description = "Permanently removes a vehicle record from the system.")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Success – vehicle deleted, no content returned"),
        @ApiResponse(responseCode = "404", description = "Vehicle not found"),
        @ApiResponse(responseCode = "500", description = "Unexpected server error")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(
            @Parameter(description = "Unique identifier of the vehicle to delete", required = true)
            @PathVariable String id) {
        log.info("DELETE /vehicles/{}", id);
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }
}
