package com.vehicleservice.app.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vehicleservice.app.dto.CreateVehicleRequest;
import com.vehicleservice.app.dto.UpdateVehicleRequest;
import com.vehicleservice.app.exception.VehicleConflictException;
import com.vehicleservice.app.exception.VehicleNotFoundException;
import com.vehicleservice.app.exception.VehicleServiceException;
import com.vehicleservicecollectionsdk.VehicleServiceCollectionSdk;
import com.vehicleservicecollectionsdk.exceptions.ApiError;
import com.vehicleservicecollectionsdk.models.CreateAVehicleParameters;
import com.vehicleservicecollectionsdk.models.CreateAVehicleRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * VehicleService delegates all CRUD operations to the Vehicle Service Collection SDK.
 * It maps SDK responses/errors to application-level domain objects and exceptions.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleServiceCollectionSdk sdk;
    private final ObjectMapper objectMapper;

    // -------------------------------------------------------------------------
    // GET /vehicles
    // -------------------------------------------------------------------------

    /**
     * Retrieve all vehicles from the backend via the SDK.
     *
     * @return raw Object (list of vehicle maps) as returned by the SDK
     */
    public Object getAllVehicles() {
        log.info("Fetching all vehicles via SDK");
        try {
            var response = sdk.vehicleServiceCollectionSdk().getAllVehicles();
            log.debug("getAllVehicles SDK status: {}", response.getStatus());
            return response.getData();
        } catch (ApiError e) {
            log.error("SDK error fetching all vehicles: status={}", e.getStatusCode(), e);
            throw new VehicleServiceException("Failed to retrieve vehicles: " + e.getMessage(), e);
        }
    }

    // -------------------------------------------------------------------------
    // POST /vehicles
    // -------------------------------------------------------------------------

    /**
     * Create a new vehicle record via the SDK.
     *
     * @param request validated DTO from the controller
     * @return the created vehicle object returned by the backend
     */
    public Object createVehicle(CreateVehicleRequest request) {
        log.info("Creating vehicle with VIN={}", request.getVin());

        CreateAVehicleRequest sdkRequest = CreateAVehicleRequest.builder()
            .nickName(request.getNickName())
            .vin(request.getVin())
            .make(request.getMake())
            .model(request.getModel())
            .year(request.getYear())
            .miles(request.getMiles())
            .build();

        CreateAVehicleParameters params = CreateAVehicleParameters.builder()
            .createAVehicleRequest(sdkRequest)
            .build();

        try {
            var response = sdk.vehicleServiceCollectionSdk().createAVehicle(params);
            log.debug("createVehicle SDK status: {}", response.getClass().getSimpleName());
            return response;
        } catch (ApiError e) {
            log.error("SDK error creating vehicle: status={}", e.getStatusCode(), e);
            if (e.getStatusCode() == 409) {
                throw new VehicleConflictException(
                    "A vehicle with VIN '" + request.getVin() + "' already exists.");
            }
            throw new VehicleServiceException("Failed to create vehicle: " + e.getMessage(), e);
        }
    }

    // -------------------------------------------------------------------------
    // GET /vehicles/{id}
    // -------------------------------------------------------------------------

    /**
     * Retrieve a single vehicle by its ID via the SDK.
     *
     * @param id vehicle identifier
     * @return the vehicle object returned by the backend
     */
    public Object getVehicleById(String id) {
        log.info("Fetching vehicle id={}", id);
        try {
            var response = sdk.vehicleServiceCollectionSdk().retrieveAVehicle(id);
            log.debug("retrieveAVehicle SDK status: {}", response.getStatus());
            return response.getData();
        } catch (ApiError e) {
            log.error("SDK error fetching vehicle id={}: status={}", id, e.getStatusCode(), e);
            if (e.getStatusCode() == 404) {
                throw new VehicleNotFoundException("Vehicle with id '" + id + "' not found.");
            }
            throw new VehicleServiceException("Failed to retrieve vehicle: " + e.getMessage(), e);
        }
    }

    // -------------------------------------------------------------------------
    // PATCH /vehicles/{id}
    // -------------------------------------------------------------------------

    /**
     * Partially update a vehicle via the SDK.
     *
     * @param id      vehicle identifier
     * @param request DTO containing only the fields to update
     * @return the updated vehicle object returned by the backend
     */
    public Object updateVehicle(String id, UpdateVehicleRequest request) {
        log.info("Updating vehicle id={}", id);

        // Build SDK request — only set fields that were provided in the DTO
        CreateAVehicleRequest.CreateAVehicleRequestBuilder builder =
            CreateAVehicleRequest.builder();

        if (request.getNickName() != null) builder.nickName(request.getNickName());
        if (request.getVin()      != null) builder.vin(request.getVin());
        if (request.getMake()     != null) builder.make(request.getMake());
        if (request.getModel()    != null) builder.model(request.getModel());
        if (request.getYear()     != null) builder.year(request.getYear());
        if (request.getMiles()    != null) builder.miles(request.getMiles());

        try {
            var response = sdk.vehicleServiceCollectionSdk()
                .updateACollection(id, builder.build());
            log.debug("updateACollection SDK status: {}", response.getClass().getSimpleName());
            return response;
        } catch (ApiError e) {
            log.error("SDK error updating vehicle id={}: status={}", id, e.getStatusCode(), e);
            if (e.getStatusCode() == 404) {
                throw new VehicleNotFoundException("Vehicle with id '" + id + "' not found.");
            }
            throw new VehicleServiceException("Failed to update vehicle: " + e.getMessage(), e);
        }
    }

    // -------------------------------------------------------------------------
    // DELETE /vehicles/{id}
    // -------------------------------------------------------------------------

    /**
     * Delete a vehicle by its ID via the SDK.
     *
     * @param id vehicle identifier
     */
    public void deleteVehicle(String id) {
        log.info("Deleting vehicle id={}", id);
        try {
            sdk.vehicleServiceCollectionSdk().deleteAVehicle(id);
            log.debug("deleteAVehicle completed for id={}", id);
        } catch (ApiError e) {
            log.error("SDK error deleting vehicle id={}: status={}", id, e.getStatusCode(), e);
            if (e.getStatusCode() == 404) {
                throw new VehicleNotFoundException("Vehicle with id '" + id + "' not found.");
            }
            throw new VehicleServiceException("Failed to delete vehicle: " + e.getMessage(), e);
        }
    }
}
