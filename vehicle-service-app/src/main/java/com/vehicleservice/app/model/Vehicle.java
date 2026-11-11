package com.vehicleservice.app.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Domain model representing a Vehicle record.
 * Mirrors the fields defined in the Vehicle Service OpenAPI spec.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Vehicle {

    private Integer id;

    private String nickName;

    private String vin;

    private String make;

    private String model;

    /** Manufacturing year, stored as a String per the spec (format: utc-millisec). */
    private String year;

    private Long miles;
}
