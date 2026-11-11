package com.vehicleservice.app.exception;

/**
 * General-purpose exception wrapping unexpected SDK / backend errors (maps to HTTP 500).
 */
public class VehicleServiceException extends RuntimeException {

    public VehicleServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
