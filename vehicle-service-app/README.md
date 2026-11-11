# Vehicle Service Application

A **Spring Boot 3 / Java 17** REST API that implements the Vehicle Service, powered by the
**Vehicle Service Collection SDK** generated from the Postman collection.

---

## Architecture

```
HTTP Client
    │
    ▼
VehicleController   ← validates input (Jakarta Bean Validation)
    │
    ▼
VehicleService      ← orchestrates calls, maps errors to domain exceptions
    │
    ▼
VehicleServiceCollectionSdk  ← generated SDK (OkHttp-based)
    │
    ▼
Vehicle Service Backend / Local Mock (http://localhost:3000)
```

---

## Prerequisites

| Tool | Version |
|------|---------|
| Java | 17+ |
| Maven | 3.9+ |
| Vehicle Service Collection SDK | installed locally (see below) |

---

## Install the SDK locally

The SDK must be installed into your local Maven repository before building this app.

```bash
cd ../postman/sdks/Collections\ SDKs/Vehicle\ Service\ Collection/java
mvn install -DskipTests
```

---

## Build & Run

### With the Postman local mock (default)

Start the local mock first (from Postman → Vehicle Service Local Mock), then:

```bash
cd vehicle-service-app
mvn spring-boot:run
```

The app starts on **http://localhost:8080** and proxies all requests to the mock on port 3000.

### With a custom backend URL

```bash
mvn spring-boot:run -Dvehicle.sdk.base-url=https://your-backend.example.com
```

---

## API Endpoints

| Method | Path | Description |
|--------|------|-------------|
| `GET` | `/vehicles` | List all vehicles |
| `POST` | `/vehicles` | Create a vehicle |
| `GET` | `/vehicles/{id}` | Retrieve a vehicle |
| `PATCH` | `/vehicles/{id}` | Partially update a vehicle |
| `DELETE` | `/vehicles/{id}` | Delete a vehicle |

### Swagger UI

Once running, open: **http://localhost:8080/swagger-ui.html**

### OpenAPI JSON

**http://localhost:8080/api-docs**

---

## Running Tests

```bash
mvn test
```

Tests use `@WebMvcTest` with a mocked `VehicleService` — no real HTTP calls are made.

---

## Configuration Reference

| Property | Default | Description |
|----------|---------|-------------|
| `vehicle.sdk.base-url` | `http://localhost:3000` | Backend / mock base URL |
| `server.port` | `8080` | HTTP port for this app |

---

## Project Structure

```
vehicle-service-app/
├── pom.xml
└── src/
    ├── main/
    │   ├── java/com/vehicleservice/app/
    │   │   ├── VehicleServiceApplication.java   ← entry point
    │   │   ├── config/
    │   │   │   └── SdkConfig.java               ← wires SDK as Spring bean
    │   │   ├── controller/
    │   │   │   └── VehicleController.java        ← REST endpoints
    │   │   ├── service/
    │   │   │   └── VehicleService.java           ← SDK delegation layer
    │   │   ├── dto/
    │   │   │   ├── CreateVehicleRequest.java
    │   │   │   ├── UpdateVehicleRequest.java
    │   │   │   └── ErrorResponse.java
    │   │   ├── model/
    │   │   │   └── Vehicle.java
    │   │   └── exception/
    │   │       ├── GlobalExceptionHandler.java
    │   │       ├── VehicleNotFoundException.java
    │   │       ├── VehicleConflictException.java
    │   │       └── VehicleServiceException.java
    │   └── resources/
    │       ├── application.yml
    │       └── application-local.yml
    └── test/
        ├── java/com/vehicleservice/app/
        │   ├── VehicleServiceApplicationTests.java
        │   └── controller/
        │       └── VehicleControllerTest.java
        └── resources/
            └── application-test.yml
```
