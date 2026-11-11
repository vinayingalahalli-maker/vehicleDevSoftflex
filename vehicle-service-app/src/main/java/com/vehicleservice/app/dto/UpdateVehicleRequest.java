package com.vehicleservice.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request DTO for partially updating a vehicle (PATCH /vehicles/{id}).
 * All fields are optional — only provided fields will be forwarded to the SDK.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateVehicleRequest {

    private String nickName;

    @Size(min = 17, max = 17, message = "VIN must be exactly 17 characters")
    private String vin;

    private String make;

    private String model;

    private String year;

    @Positive(message = "miles must be a positive number")
    private Long miles;
}
