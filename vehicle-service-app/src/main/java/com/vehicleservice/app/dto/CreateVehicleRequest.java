package com.vehicleservice.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request DTO for creating a new vehicle (POST /vehicles).
 * All fields are required per the API spec.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateVehicleRequest {

    @NotBlank(message = "nickName is required")
    private String nickName;

    @NotBlank(message = "vin is required")
    @Size(min = 17, max = 17, message = "VIN must be exactly 17 characters")
    private String vin;

    @NotBlank(message = "make is required")
    private String make;

    @NotBlank(message = "model is required")
    private String model;

    @NotBlank(message = "year is required")
    private String year;

    @NotNull(message = "miles is required")
    @Positive(message = "miles must be a positive number")
    private Long miles;
}
