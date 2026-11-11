# VehicleServiceCollectionSdkService

A list of all methods in the `VehicleServiceCollectionSdkService` service. Click on the method name to view detailed information about that method.

| Methods                                     | Description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
| :------------------------------------------ | :---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| [create_a_vehicle](#create_a_vehicle)       | ## Create a Vehicle Creates a new vehicle record in the system. **Method:** `POST` **Endpoint:** `{{baseUrl}}/vehicles` ### Request Headers \| Header \| Value \| Description \| \|--------\|-------\|-------------\| \| Content-Type \| application/json \| Required. Specifies the request body format. \| \| Accept \| application/json \| Expected response format. \| ### Request Body Send a JSON object with the following fields: \| Field \| Type \| Required \| Description \| \|-------\|------\|----------\|-------------\| \| nickName \| string \| Yes \| A friendly name for the vehicle. \| \| vin \| string \| Yes \| Vehicle Identification Number (17 characters). \| \| make \| string \| Yes \| Manufacturer of the vehicle (e.g., Mercury). \| \| model \| string \| Yes \| Model name of the vehicle (e.g., Villager). \| \| year \| string \| Yes \| Manufacturing year of the vehicle (e.g., "1994"). \| \| miles \| number \| Yes \| Current odometer reading in miles. \| **Example Request Body:** `json {   "nickName": "The Lisa Marie",   "vin": "4M2DV11W4RDJ53329",   "make": "Mercury",   "model": "Villager",   "year": "1994",   "miles": 159864 } ` ### Responses \| Status Code \| Description \| \|-------------\|-------------\| \| 201 \| Vehicle successfully created. Returns the created vehicle object. \| \| 400 \| Bad request — one or more required attributes are missing or invalid. \| \| 409 \| Conflict — a vehicle with the same VIN already exists. \| \| 500 \| Unexpected server error. \|                                                                                                                                                                    |
| [retrieve_a_vehicle](#retrieve_a_vehicle)   | ## Retrieve a Vehicle Fetches the details of a single vehicle by its unique identifier. **Method:** `GET` **Endpoint:** `{{baseUrl}}/vehicles/:id` ### Path Parameters \| Parameter \| Type \| Required \| Description \| \|-----------\|------\|----------\|-------------\| \| id \| string \| Yes \| The unique identifier of the vehicle to retrieve. \| ### Request Headers \| Header \| Value \| Description \| \|--------\|-------\|-------------\| \| Accept \| application/json \| Expected response format. \| ### Request Body None required. ### Responses \| Status Code \| Description \| \|-------------\|-------------\| \| 200 \| Success — returns the vehicle object matching the given ID. \| \| 404 \| Not found — no vehicle exists with the specified ID. \| \| 500 \| Unexpected server error. \|                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
| [update_a_collection](#update_a_collection) | ## Update a Vehicle Partially updates an existing vehicle record using its unique identifier. Only the fields provided in the request body will be updated. **Method:** `PATCH` **Endpoint:** `{{baseUrl}}/vehicles/:id` ### Path Parameters \| Parameter \| Type \| Required \| Description \| \|-----------\|------\|----------\|-------------\| \| id \| string \| Yes \| The unique identifier of the vehicle to update. \| ### Request Headers \| Header \| Value \| Description \| \|--------\|-------\|-------------\| \| Content-Type \| application/json \| Required. Specifies the request body format. \| \| Accept \| application/json \| Expected response format. \| ### Request Body Send a JSON object with one or more of the following fields to update: \| Field \| Type \| Required \| Description \| \|-------\|------\|----------\|-------------\| \| nickName \| string \| No \| Updated friendly name for the vehicle. \| \| vin \| string \| No \| Updated Vehicle Identification Number. \| \| make \| string \| No \| Updated manufacturer name. \| \| model \| string \| No \| Updated model name. \| \| year \| string \| No \| Updated manufacturing year. \| \| miles \| number \| No \| Updated odometer reading in miles. \| **Example Request Body:** `json {   "nickName": "The Lisa Marie",   "vin": "4M2DV11W4RDJ53329",   "make": "Mercury",   "model": "Villager",   "year": "1994",   "miles": 159999 } ` ### Responses \| Status Code \| Description \| \|-------------\|-------------\| \| 200 \| Success — returns the updated vehicle object. \| \| 400 \| Bad request — the request body is malformed or contains invalid values. \| \| 500 \| Unexpected server error. \| |
| [delete_a_vehicle](#delete_a_vehicle)       | ## Delete a Vehicle Permanently removes a vehicle record from the system using its unique identifier. **Method:** `DELETE` **Endpoint:** `{{baseUrl}}/vehicles/:id` ### Path Parameters \| Parameter \| Type \| Required \| Description \| \|-----------\|------\|----------\|-------------\| \| id \| string \| Yes \| The unique identifier of the vehicle to delete. \| ### Request Headers \| Header \| Value \| Description \| \|--------\|-------\|-------------\| \| Accept \| application/json \| Expected response format. \| ### Request Body None required. ### Responses \| Status Code \| Description \| \|-------------\|-------------\| \| 204 \| Success — vehicle deleted. No content returned. \| \| 500 \| Unexpected server error. \|                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
| [get_all_vehicles](#get_all_vehicles)       | ## Get All Vehicles Retrieves a list of all vehicle records stored in the system. **Method:** `GET` **Endpoint:** `{{baseUrl}}/vehicles` ### Request Headers \| Header \| Value \| Description \| \|--------\|-------\|-------------\| \| Accept \| application/json \| Expected response format. \| ### Request Body None required. ### Responses \| Status Code \| Description \| \|-------------\|-------------\| \| 200 \| Success — returns an array of vehicle objects. \| \| 500 \| Unexpected server error. \| ### Example Response (200 - Success) Returns a JSON array of vehicle objects, each containing fields such as `id`, `nickName`, `vin`, `make`, `model`, `year`, and `miles`.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      |

## create_a_vehicle

## Create a Vehicle Creates a new vehicle record in the system. **Method:** `POST` **Endpoint:** `{{baseUrl}}/vehicles` ### Request Headers \| Header \| Value \| Description \| \|--------\|-------\|-------------\| \| Content-Type \| application/json \| Required. Specifies the request body format. \| \| Accept \| application/json \| Expected response format. \| ### Request Body Send a JSON object with the following fields: \| Field \| Type \| Required \| Description \| \|-------\|------\|----------\|-------------\| \| nickName \| string \| Yes \| A friendly name for the vehicle. \| \| vin \| string \| Yes \| Vehicle Identification Number (17 characters). \| \| make \| string \| Yes \| Manufacturer of the vehicle (e.g., Mercury). \| \| model \| string \| Yes \| Model name of the vehicle (e.g., Villager). \| \| year \| string \| Yes \| Manufacturing year of the vehicle (e.g., "1994"). \| \| miles \| number \| Yes \| Current odometer reading in miles. \| **Example Request Body:** `json {   "nickName": "The Lisa Marie",   "vin": "4M2DV11W4RDJ53329",   "make": "Mercury",   "model": "Villager",   "year": "1994",   "miles": 159864 } ` ### Responses \| Status Code \| Description \| \|-------------\|-------------\| \| 201 \| Vehicle successfully created. Returns the created vehicle object. \| \| 400 \| Bad request — one or more required attributes are missing or invalid. \| \| 409 \| Conflict — a vehicle with the same VIN already exists. \| \| 500 \| Unexpected server error. \|

- HTTP Method: `POST`
- Endpoint: `/vehicles`

**Parameters**

| Name                 | Type                                                        | Required | Description       |
| :------------------- | :---------------------------------------------------------- | :------- | :---------------- |
| request_body         | [CreateAVehicleRequest](../models/CreateAVehicleRequest.md) | ✅       | The request body. |
| x_mock_response_code | str                                                         | ❌       |                   |

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from vehicle_service_collection_sdk import VehicleServiceCollectionSdk, Environment
from vehicle_service_collection_sdk.models import CreateAVehicleRequest

sdk = VehicleServiceCollectionSdk(
    api_key="YOUR_API_KEY",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

request_body = CreateAVehicleRequest(
    nick_name="The Lisa Marie",
    vin="4M2DV11W4RDJ53329",
    make="Mercury",
    model="Villager",
    year="1994",
    miles=159864
)

result = sdk.vehicle_service_collection_sdk.create_a_vehicle(
    request_body=request_body,
    x_mock_response_code="500"
)

print(result)
```

## retrieve_a_vehicle

## Retrieve a Vehicle Fetches the details of a single vehicle by its unique identifier. **Method:** `GET` **Endpoint:** `{{baseUrl}}/vehicles/:id` ### Path Parameters \| Parameter \| Type \| Required \| Description \| \|-----------\|------\|----------\|-------------\| \| id \| string \| Yes \| The unique identifier of the vehicle to retrieve. \| ### Request Headers \| Header \| Value \| Description \| \|--------\|-------\|-------------\| \| Accept \| application/json \| Expected response format. \| ### Request Body None required. ### Responses \| Status Code \| Description \| \|-------------\|-------------\| \| 200 \| Success — returns the vehicle object matching the given ID. \| \| 404 \| Not found — no vehicle exists with the specified ID. \| \| 500 \| Unexpected server error. \|

- HTTP Method: `GET`
- Endpoint: `/vehicles/{id}`

**Parameters**

| Name | Type | Required | Description |
| :--- | :--- | :------- | :---------- |
| id\_ | str  | ✅       |             |

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from vehicle_service_collection_sdk import VehicleServiceCollectionSdk, Environment

sdk = VehicleServiceCollectionSdk(
    api_key="YOUR_API_KEY",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

result = sdk.vehicle_service_collection_sdk.retrieve_a_vehicle(id_="1")

print(result)
```

## update_a_collection

## Update a Vehicle Partially updates an existing vehicle record using its unique identifier. Only the fields provided in the request body will be updated. **Method:** `PATCH` **Endpoint:** `{{baseUrl}}/vehicles/:id` ### Path Parameters \| Parameter \| Type \| Required \| Description \| \|-----------\|------\|----------\|-------------\| \| id \| string \| Yes \| The unique identifier of the vehicle to update. \| ### Request Headers \| Header \| Value \| Description \| \|--------\|-------\|-------------\| \| Content-Type \| application/json \| Required. Specifies the request body format. \| \| Accept \| application/json \| Expected response format. \| ### Request Body Send a JSON object with one or more of the following fields to update: \| Field \| Type \| Required \| Description \| \|-------\|------\|----------\|-------------\| \| nickName \| string \| No \| Updated friendly name for the vehicle. \| \| vin \| string \| No \| Updated Vehicle Identification Number. \| \| make \| string \| No \| Updated manufacturer name. \| \| model \| string \| No \| Updated model name. \| \| year \| string \| No \| Updated manufacturing year. \| \| miles \| number \| No \| Updated odometer reading in miles. \| **Example Request Body:** `json {   "nickName": "The Lisa Marie",   "vin": "4M2DV11W4RDJ53329",   "make": "Mercury",   "model": "Villager",   "year": "1994",   "miles": 159999 } ` ### Responses \| Status Code \| Description \| \|-------------\|-------------\| \| 200 \| Success — returns the updated vehicle object. \| \| 400 \| Bad request — the request body is malformed or contains invalid values. \| \| 500 \| Unexpected server error. \|

- HTTP Method: `PATCH`
- Endpoint: `/vehicles/{id}`

**Parameters**

| Name         | Type                                                        | Required | Description       |
| :----------- | :---------------------------------------------------------- | :------- | :---------------- |
| request_body | [CreateAVehicleRequest](../models/CreateAVehicleRequest.md) | ✅       | The request body. |
| id\_         | str                                                         | ✅       |                   |

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from vehicle_service_collection_sdk import VehicleServiceCollectionSdk, Environment
from vehicle_service_collection_sdk.models import CreateAVehicleRequest

sdk = VehicleServiceCollectionSdk(
    api_key="YOUR_API_KEY",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

request_body = CreateAVehicleRequest(
    nick_name="The Lisa Marie",
    vin="4M2DV11W4RDJ53329",
    make="Mercury",
    model="Villager",
    year="1994",
    miles=159864
)

result = sdk.vehicle_service_collection_sdk.update_a_collection(
    request_body=request_body,
    id_="1"
)

print(result)
```

## delete_a_vehicle

## Delete a Vehicle Permanently removes a vehicle record from the system using its unique identifier. **Method:** `DELETE` **Endpoint:** `{{baseUrl}}/vehicles/:id` ### Path Parameters \| Parameter \| Type \| Required \| Description \| \|-----------\|------\|----------\|-------------\| \| id \| string \| Yes \| The unique identifier of the vehicle to delete. \| ### Request Headers \| Header \| Value \| Description \| \|--------\|-------\|-------------\| \| Accept \| application/json \| Expected response format. \| ### Request Body None required. ### Responses \| Status Code \| Description \| \|-------------\|-------------\| \| 204 \| Success — vehicle deleted. No content returned. \| \| 500 \| Unexpected server error. \|

- HTTP Method: `DELETE`
- Endpoint: `/vehicles/{id}`

**Parameters**

| Name | Type | Required | Description |
| :--- | :--- | :------- | :---------- |
| id\_ | str  | ✅       |             |

**Return Type**

`str`

**Example Usage Code Snippet**

```python
from vehicle_service_collection_sdk import VehicleServiceCollectionSdk, Environment

sdk = VehicleServiceCollectionSdk(
    api_key="YOUR_API_KEY",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

result = sdk.vehicle_service_collection_sdk.delete_a_vehicle(id_="1")

with open("output-file.ext", "w") as f:
    f.write(result if isinstance(result, str) else result.decode(errors="replace") if isinstance(result, (bytes, bytearray)) else str(result))
```

## get_all_vehicles

## Get All Vehicles Retrieves a list of all vehicle records stored in the system. **Method:** `GET` **Endpoint:** `{{baseUrl}}/vehicles` ### Request Headers \| Header \| Value \| Description \| \|--------\|-------\|-------------\| \| Accept \| application/json \| Expected response format. \| ### Request Body None required. ### Responses \| Status Code \| Description \| \|-------------\|-------------\| \| 200 \| Success — returns an array of vehicle objects. \| \| 500 \| Unexpected server error. \| ### Example Response (200 - Success) Returns a JSON array of vehicle objects, each containing fields such as `id`, `nickName`, `vin`, `make`, `model`, `year`, and `miles`.

- HTTP Method: `GET`
- Endpoint: `/vehicles`

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from vehicle_service_collection_sdk import VehicleServiceCollectionSdk, Environment

sdk = VehicleServiceCollectionSdk(
    api_key="YOUR_API_KEY",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

result = sdk.vehicle_service_collection_sdk.get_all_vehicles()

print(result)
```
