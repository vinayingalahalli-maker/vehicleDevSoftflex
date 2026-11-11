# VehicleServiceCollectionSdkService

A list of all methods in the `VehicleServiceCollectionSdkService` service. Click on the method name to view detailed information about that method.

| Methods                                 | Description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
| :-------------------------------------- | :---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| [createAVehicle](#createavehicle)       | ## Create a Vehicle Creates a new vehicle record in the system. **Method:** `POST` **Endpoint:** `{{baseUrl}}/vehicles` ### Request Headers \| Header \| Value \| Description \| \|--------\|-------\|-------------\| \| Content-Type \| application/json \| Required. Specifies the request body format. \| \| Accept \| application/json \| Expected response format. \| ### Request Body Send a JSON object with the following fields: \| Field \| Type \| Required \| Description \| \|-------\|------\|----------\|-------------\| \| nickName \| string \| Yes \| A friendly name for the vehicle. \| \| vin \| string \| Yes \| Vehicle Identification Number (17 characters). \| \| make \| string \| Yes \| Manufacturer of the vehicle (e.g., Mercury). \| \| model \| string \| Yes \| Model name of the vehicle (e.g., Villager). \| \| year \| string \| Yes \| Manufacturing year of the vehicle (e.g., "1994"). \| \| miles \| number \| Yes \| Current odometer reading in miles. \| **Example Request Body:** `json {   "nickName": "The Lisa Marie",   "vin": "4M2DV11W4RDJ53329",   "make": "Mercury",   "model": "Villager",   "year": "1994",   "miles": 159864 } ` ### Responses \| Status Code \| Description \| \|-------------\|-------------\| \| 201 \| Vehicle successfully created. Returns the created vehicle object. \| \| 400 \| Bad request — one or more required attributes are missing or invalid. \| \| 409 \| Conflict — a vehicle with the same VIN already exists. \| \| 500 \| Unexpected server error. \|                                                                                                                                                                    |
| [retrieveAVehicle](#retrieveavehicle)   | ## Retrieve a Vehicle Fetches the details of a single vehicle by its unique identifier. **Method:** `GET` **Endpoint:** `{{baseUrl}}/vehicles/:id` ### Path Parameters \| Parameter \| Type \| Required \| Description \| \|-----------\|------\|----------\|-------------\| \| id \| string \| Yes \| The unique identifier of the vehicle to retrieve. \| ### Request Headers \| Header \| Value \| Description \| \|--------\|-------\|-------------\| \| Accept \| application/json \| Expected response format. \| ### Request Body None required. ### Responses \| Status Code \| Description \| \|-------------\|-------------\| \| 200 \| Success — returns the vehicle object matching the given ID. \| \| 404 \| Not found — no vehicle exists with the specified ID. \| \| 500 \| Unexpected server error. \|                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
| [updateACollection](#updateacollection) | ## Update a Vehicle Partially updates an existing vehicle record using its unique identifier. Only the fields provided in the request body will be updated. **Method:** `PATCH` **Endpoint:** `{{baseUrl}}/vehicles/:id` ### Path Parameters \| Parameter \| Type \| Required \| Description \| \|-----------\|------\|----------\|-------------\| \| id \| string \| Yes \| The unique identifier of the vehicle to update. \| ### Request Headers \| Header \| Value \| Description \| \|--------\|-------\|-------------\| \| Content-Type \| application/json \| Required. Specifies the request body format. \| \| Accept \| application/json \| Expected response format. \| ### Request Body Send a JSON object with one or more of the following fields to update: \| Field \| Type \| Required \| Description \| \|-------\|------\|----------\|-------------\| \| nickName \| string \| No \| Updated friendly name for the vehicle. \| \| vin \| string \| No \| Updated Vehicle Identification Number. \| \| make \| string \| No \| Updated manufacturer name. \| \| model \| string \| No \| Updated model name. \| \| year \| string \| No \| Updated manufacturing year. \| \| miles \| number \| No \| Updated odometer reading in miles. \| **Example Request Body:** `json {   "nickName": "The Lisa Marie",   "vin": "4M2DV11W4RDJ53329",   "make": "Mercury",   "model": "Villager",   "year": "1994",   "miles": 159999 } ` ### Responses \| Status Code \| Description \| \|-------------\|-------------\| \| 200 \| Success — returns the updated vehicle object. \| \| 400 \| Bad request — the request body is malformed or contains invalid values. \| \| 500 \| Unexpected server error. \| |
| [deleteAVehicle](#deleteavehicle)       | ## Delete a Vehicle Permanently removes a vehicle record from the system using its unique identifier. **Method:** `DELETE` **Endpoint:** `{{baseUrl}}/vehicles/:id` ### Path Parameters \| Parameter \| Type \| Required \| Description \| \|-----------\|------\|----------\|-------------\| \| id \| string \| Yes \| The unique identifier of the vehicle to delete. \| ### Request Headers \| Header \| Value \| Description \| \|--------\|-------\|-------------\| \| Accept \| application/json \| Expected response format. \| ### Request Body None required. ### Responses \| Status Code \| Description \| \|-------------\|-------------\| \| 204 \| Success — vehicle deleted. No content returned. \| \| 500 \| Unexpected server error. \|                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
| [getAllVehicles](#getallvehicles)       | ## Get All Vehicles Retrieves a list of all vehicle records stored in the system. **Method:** `GET` **Endpoint:** `{{baseUrl}}/vehicles` ### Request Headers \| Header \| Value \| Description \| \|--------\|-------\|-------------\| \| Accept \| application/json \| Expected response format. \| ### Request Body None required. ### Responses \| Status Code \| Description \| \|-------------\|-------------\| \| 200 \| Success — returns an array of vehicle objects. \| \| 500 \| Unexpected server error. \| ### Example Response (200 - Success) Returns a JSON array of vehicle objects, each containing fields such as `id`, `nickName`, `vin`, `make`, `model`, `year`, and `miles`.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      |

## createAVehicle

## Create a Vehicle Creates a new vehicle record in the system. **Method:** `POST` **Endpoint:** `{{baseUrl}}/vehicles` ### Request Headers \| Header \| Value \| Description \| \|--------\|-------\|-------------\| \| Content-Type \| application/json \| Required. Specifies the request body format. \| \| Accept \| application/json \| Expected response format. \| ### Request Body Send a JSON object with the following fields: \| Field \| Type \| Required \| Description \| \|-------\|------\|----------\|-------------\| \| nickName \| string \| Yes \| A friendly name for the vehicle. \| \| vin \| string \| Yes \| Vehicle Identification Number (17 characters). \| \| make \| string \| Yes \| Manufacturer of the vehicle (e.g., Mercury). \| \| model \| string \| Yes \| Model name of the vehicle (e.g., Villager). \| \| year \| string \| Yes \| Manufacturing year of the vehicle (e.g., "1994"). \| \| miles \| number \| Yes \| Current odometer reading in miles. \| **Example Request Body:** `json {   "nickName": "The Lisa Marie",   "vin": "4M2DV11W4RDJ53329",   "make": "Mercury",   "model": "Villager",   "year": "1994",   "miles": 159864 } ` ### Responses \| Status Code \| Description \| \|-------------\|-------------\| \| 201 \| Vehicle successfully created. Returns the created vehicle object. \| \| 400 \| Bad request — one or more required attributes are missing or invalid. \| \| 409 \| Conflict — a vehicle with the same VIN already exists. \| \| 500 \| Unexpected server error. \|

- HTTP Method: `POST`
- Endpoint: `/vehicles`

**Parameters**

| Name              | Type                                                              | Required | Description               |
| :---------------- | :---------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [CreateAVehicleParameters](../models/CreateAVehicleParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.vehicleservicecollectionsdk.VehicleServiceCollectionSdk;
import com.vehicleservicecollectionsdk.config.ApiKeyAuthConfig;
import com.vehicleservicecollectionsdk.config.VehicleServiceCollectionSdkConfig;
import com.vehicleservicecollectionsdk.models.CreateAVehicleParameters;
import com.vehicleservicecollectionsdk.models.CreateAVehicleRequest;

public class Main {

  public static void main(String[] args) {
    VehicleServiceCollectionSdkConfig config = VehicleServiceCollectionSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    VehicleServiceCollectionSdk vehicleServiceCollectionSdk = new VehicleServiceCollectionSdk(
      config
    );

    CreateAVehicleRequest createAVehicleRequest = CreateAVehicleRequest.builder()
      .nickName("The Lisa Marie")
      .vin("4M2DV11W4RDJ53329")
      .make("Mercury")
      .model("Villager")
      .year("1994")
      .miles(159864L)
      .build();

    CreateAVehicleParameters requestParameters = CreateAVehicleParameters.builder()
      .xMockResponseCode("500")
      .requestBody(createAVehicleRequest)
      .build();

    Object response = vehicleServiceCollectionSdk.vehicleServiceCollectionSdk.createAVehicle(
      requestParameters
    );

    System.out.println(response);
  }
}

```

## retrieveAVehicle

## Retrieve a Vehicle Fetches the details of a single vehicle by its unique identifier. **Method:** `GET` **Endpoint:** `{{baseUrl}}/vehicles/:id` ### Path Parameters \| Parameter \| Type \| Required \| Description \| \|-----------\|------\|----------\|-------------\| \| id \| string \| Yes \| The unique identifier of the vehicle to retrieve. \| ### Request Headers \| Header \| Value \| Description \| \|--------\|-------\|-------------\| \| Accept \| application/json \| Expected response format. \| ### Request Body None required. ### Responses \| Status Code \| Description \| \|-------------\|-------------\| \| 200 \| Success — returns the vehicle object matching the given ID. \| \| 404 \| Not found — no vehicle exists with the specified ID. \| \| 500 \| Unexpected server error. \|

- HTTP Method: `GET`
- Endpoint: `/vehicles/{id}`

**Parameters**

| Name | Type   | Required | Description |
| :--- | :----- | :------- | :---------- |
| id   | String | ✅       |             |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.vehicleservicecollectionsdk.VehicleServiceCollectionSdk;
import com.vehicleservicecollectionsdk.config.ApiKeyAuthConfig;
import com.vehicleservicecollectionsdk.config.VehicleServiceCollectionSdkConfig;

public class Main {

  public static void main(String[] args) {
    VehicleServiceCollectionSdkConfig config = VehicleServiceCollectionSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    VehicleServiceCollectionSdk vehicleServiceCollectionSdk = new VehicleServiceCollectionSdk(
      config
    );

    Object response = vehicleServiceCollectionSdk.vehicleServiceCollectionSdk.retrieveAVehicle("1");

    System.out.println(response);
  }
}

```

## updateACollection

## Update a Vehicle Partially updates an existing vehicle record using its unique identifier. Only the fields provided in the request body will be updated. **Method:** `PATCH` **Endpoint:** `{{baseUrl}}/vehicles/:id` ### Path Parameters \| Parameter \| Type \| Required \| Description \| \|-----------\|------\|----------\|-------------\| \| id \| string \| Yes \| The unique identifier of the vehicle to update. \| ### Request Headers \| Header \| Value \| Description \| \|--------\|-------\|-------------\| \| Content-Type \| application/json \| Required. Specifies the request body format. \| \| Accept \| application/json \| Expected response format. \| ### Request Body Send a JSON object with one or more of the following fields to update: \| Field \| Type \| Required \| Description \| \|-------\|------\|----------\|-------------\| \| nickName \| string \| No \| Updated friendly name for the vehicle. \| \| vin \| string \| No \| Updated Vehicle Identification Number. \| \| make \| string \| No \| Updated manufacturer name. \| \| model \| string \| No \| Updated model name. \| \| year \| string \| No \| Updated manufacturing year. \| \| miles \| number \| No \| Updated odometer reading in miles. \| **Example Request Body:** `json {   "nickName": "The Lisa Marie",   "vin": "4M2DV11W4RDJ53329",   "make": "Mercury",   "model": "Villager",   "year": "1994",   "miles": 159999 } ` ### Responses \| Status Code \| Description \| \|-------------\|-------------\| \| 200 \| Success — returns the updated vehicle object. \| \| 400 \| Bad request — the request body is malformed or contains invalid values. \| \| 500 \| Unexpected server error. \|

- HTTP Method: `PATCH`
- Endpoint: `/vehicles/{id}`

**Parameters**

| Name                  | Type                                                        | Required | Description  |
| :-------------------- | :---------------------------------------------------------- | :------- | :----------- |
| id                    | String                                                      | ✅       |              |
| createAVehicleRequest | [CreateAVehicleRequest](../models/CreateAVehicleRequest.md) | ✅       | Request Body |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.vehicleservicecollectionsdk.VehicleServiceCollectionSdk;
import com.vehicleservicecollectionsdk.config.ApiKeyAuthConfig;
import com.vehicleservicecollectionsdk.config.VehicleServiceCollectionSdkConfig;
import com.vehicleservicecollectionsdk.models.CreateAVehicleRequest;

public class Main {

  public static void main(String[] args) {
    VehicleServiceCollectionSdkConfig config = VehicleServiceCollectionSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    VehicleServiceCollectionSdk vehicleServiceCollectionSdk = new VehicleServiceCollectionSdk(
      config
    );

    CreateAVehicleRequest createAVehicleRequest = CreateAVehicleRequest.builder()
      .nickName("The Lisa Marie")
      .vin("4M2DV11W4RDJ53329")
      .make("Mercury")
      .model("Villager")
      .year("1994")
      .miles(159864L)
      .build();

    Object response = vehicleServiceCollectionSdk.vehicleServiceCollectionSdk.updateACollection(
      "1",
      createAVehicleRequest
    );

    System.out.println(response);
  }
}

```

## deleteAVehicle

## Delete a Vehicle Permanently removes a vehicle record from the system using its unique identifier. **Method:** `DELETE` **Endpoint:** `{{baseUrl}}/vehicles/:id` ### Path Parameters \| Parameter \| Type \| Required \| Description \| \|-----------\|------\|----------\|-------------\| \| id \| string \| Yes \| The unique identifier of the vehicle to delete. \| ### Request Headers \| Header \| Value \| Description \| \|--------\|-------\|-------------\| \| Accept \| application/json \| Expected response format. \| ### Request Body None required. ### Responses \| Status Code \| Description \| \|-------------\|-------------\| \| 204 \| Success — vehicle deleted. No content returned. \| \| 500 \| Unexpected server error. \|

- HTTP Method: `DELETE`
- Endpoint: `/vehicles/{id}`

**Parameters**

| Name | Type   | Required | Description |
| :--- | :----- | :------- | :---------- |
| id   | String | ✅       |             |

**Return Type**

`String`

**Example Usage Code Snippet**

```java
import com.vehicleservicecollectionsdk.VehicleServiceCollectionSdk;
import com.vehicleservicecollectionsdk.config.ApiKeyAuthConfig;
import com.vehicleservicecollectionsdk.config.VehicleServiceCollectionSdkConfig;

public class Main {

  public static void main(String[] args) {
    VehicleServiceCollectionSdkConfig config = VehicleServiceCollectionSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    VehicleServiceCollectionSdk vehicleServiceCollectionSdk = new VehicleServiceCollectionSdk(
      config
    );

    String response = vehicleServiceCollectionSdk.vehicleServiceCollectionSdk.deleteAVehicle("1");

    System.out.println(response);
  }
}

```

## getAllVehicles

## Get All Vehicles Retrieves a list of all vehicle records stored in the system. **Method:** `GET` **Endpoint:** `{{baseUrl}}/vehicles` ### Request Headers \| Header \| Value \| Description \| \|--------\|-------\|-------------\| \| Accept \| application/json \| Expected response format. \| ### Request Body None required. ### Responses \| Status Code \| Description \| \|-------------\|-------------\| \| 200 \| Success — returns an array of vehicle objects. \| \| 500 \| Unexpected server error. \| ### Example Response (200 - Success) Returns a JSON array of vehicle objects, each containing fields such as `id`, `nickName`, `vin`, `make`, `model`, `year`, and `miles`.

- HTTP Method: `GET`
- Endpoint: `/vehicles`

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.vehicleservicecollectionsdk.VehicleServiceCollectionSdk;
import com.vehicleservicecollectionsdk.config.ApiKeyAuthConfig;
import com.vehicleservicecollectionsdk.config.VehicleServiceCollectionSdkConfig;

public class Main {

  public static void main(String[] args) {
    VehicleServiceCollectionSdkConfig config = VehicleServiceCollectionSdkConfig.builder()
      .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey("YOUR_API_KEY").build())
      .build();

    VehicleServiceCollectionSdk vehicleServiceCollectionSdk = new VehicleServiceCollectionSdk(
      config
    );

    Object response = vehicleServiceCollectionSdk.vehicleServiceCollectionSdk.getAllVehicles();

    System.out.println(response);
  }
}

```
