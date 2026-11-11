package com.vehicleservice.app.exception;

/**
 * Thrown when a vehicle with the same VIN already exists (maps to HTTP 409).
 */
public class VehicleConflictException extends RuntimeException {

    public VehicleConflictException(String message) {
        super(message);
    }
}
