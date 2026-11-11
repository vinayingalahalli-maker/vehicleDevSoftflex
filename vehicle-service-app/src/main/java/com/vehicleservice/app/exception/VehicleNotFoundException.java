package com.vehicleservice.app.exception;

/**
 * Thrown when a requested vehicle cannot be found (maps to HTTP 404).
 */
public class VehicleNotFoundException extends RuntimeException {

    public VehicleNotFoundException(String message) {
        super(message);
    }
}
