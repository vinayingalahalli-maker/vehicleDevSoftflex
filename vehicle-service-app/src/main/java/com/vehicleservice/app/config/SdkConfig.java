package com.vehicleservice.app.config;

import com.vehicleservicecollectionsdk.VehicleServiceCollectionSdk;
import com.vehicleservicecollectionsdk.config.VehicleServiceCollectionSdkConfig;
import com.vehicleservicecollectionsdk.http.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring configuration that wires the Vehicle Service Collection SDK
 * as a managed bean. The baseUrl is read from application properties so
 * it can be overridden per environment (local mock, staging, production).
 */
@Configuration
public class SdkConfig {

    @Value("${vehicle.sdk.base-url:http://localhost:3000}")
    private String baseUrl;

    @Bean
    public VehicleServiceCollectionSdk vehicleServiceCollectionSdk() {
        VehicleServiceCollectionSdkConfig config = VehicleServiceCollectionSdkConfig
            .builder()
            .environment(Environment.DEFAULT)
            .baseUrl(baseUrl)
            .build();

        return new VehicleServiceCollectionSdk(config);
    }
}
