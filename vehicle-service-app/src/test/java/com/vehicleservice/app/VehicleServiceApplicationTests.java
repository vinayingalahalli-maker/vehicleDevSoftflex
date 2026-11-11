package com.vehicleservice.app;

import com.vehicleservice.app.service.VehicleService;
import com.vehicleservicecollectionsdk.VehicleServiceCollectionSdk;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

/**
 * Smoke test — verifies the Spring application context loads correctly.
 * The SDK bean is mocked so no real HTTP calls are made during the test.
 */
@SpringBootTest
@ActiveProfiles("test")
class VehicleServiceApplicationTests {

    @MockBean
    VehicleServiceCollectionSdk vehicleServiceCollectionSdk;

    @Test
    void contextLoads() {
        // If the context starts without errors, the test passes.
    }
}
