import { z } from 'zod';
import { BaseService } from '../base-service';
import { ContentType, HttpResponse, SdkConfig } from '../../http/types';
import { RequestBuilder } from '../../http/transport/request-builder';
import { SerializationStyle } from '../../http/serialization/base-serializer';
import { ThrowableError } from '../../http/errors/throwable-error';
import { Environment } from '../../http/environment';
import {
  CreateAVehicleRequest,
  createAVehicleRequestRequest,
} from './models/create-a-vehicle-request';
import { CreateAVehicleParams } from './request-params';

/**
 * Service class for VehicleServiceCollectionSdkService operations.
 * Provides methods to interact with VehicleServiceCollectionSdkService-related API endpoints.
 * All methods return promises and handle request/response serialization automatically.
 */
export class VehicleServiceCollectionSdkService extends BaseService {
  protected createAVehicleConfig?: Partial<SdkConfig>;

  protected retrieveAVehicleConfig?: Partial<SdkConfig>;

  protected updateACollectionConfig?: Partial<SdkConfig>;

  protected deleteAVehicleConfig?: Partial<SdkConfig>;

  protected getAllVehiclesConfig?: Partial<SdkConfig>;

  /**
   * Sets method-level configuration for createAVehicle.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setCreateAVehicleConfig(config: Partial<SdkConfig>): this {
    this.createAVehicleConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for retrieveAVehicle.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setRetrieveAVehicleConfig(config: Partial<SdkConfig>): this {
    this.retrieveAVehicleConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for updateACollection.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setUpdateACollectionConfig(config: Partial<SdkConfig>): this {
    this.updateACollectionConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for deleteAVehicle.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setDeleteAVehicleConfig(config: Partial<SdkConfig>): this {
    this.deleteAVehicleConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for getAllVehicles.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setGetAllVehiclesConfig(config: Partial<SdkConfig>): this {
    this.getAllVehiclesConfig = config;
    return this;
  }

  /**
 * ## Create a Vehicle
Creates a new vehicle record in the system.

**Method:** `POST`  
**Endpoint:** `{{baseUrl}}/vehicles`

### Request Headers
| Header | Value | Description |
|--------|-------|-------------|
| Content-Type | application/json | Required. Specifies the request body format. |
| Accept | application/json | Expected response format. |

### Request Body
Send a JSON object with the following fields:

| Field | Type | Required | Description |
|-------|------|----------|-------------|
| nickName | string | Yes | A friendly name for the vehicle. |
| vin | string | Yes | Vehicle Identification Number (17 characters). |
| make | string | Yes | Manufacturer of the vehicle (e.g., Mercury). |
| model | string | Yes | Model name of the vehicle (e.g., Villager). |
| year | string | Yes | Manufacturing year of the vehicle (e.g., "1994"). |
| miles | number | Yes | Current odometer reading in miles. |

**Example Request Body:**
```json
{
  "nickName": "The Lisa Marie",
  "vin": "4M2DV11W4RDJ53329",
  "make": "Mercury",
  "model": "Villager",
  "year": "1994",
  "miles": 159864
}
```

### Responses
| Status Code | Description |
|-------------|-------------|
| 201 | Vehicle successfully created. Returns the created vehicle object. |
| 400 | Bad request — one or more required attributes are missing or invalid. |
| 409 | Conflict — a vehicle with the same VIN already exists. |
| 500 | Unexpected server error. |
 * @param {string} [params.xMockResponseCode] - 
 * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
 * @returns {Promise<HttpResponse<any>>} - 201 - Success
 */
  async createAVehicle(
    body: CreateAVehicleRequest,
    params?: CreateAVehicleParams,
    requestConfig?: Partial<SdkConfig>,
  ): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.createAVehicleConfig, requestConfig);
    z.object({ xMockResponseCode: z.string().optional() }).parse(params ?? {});
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('POST')
      .setPath('/vehicles')
      .setRequestSchema(createAVehicleRequestRequest)
      .addApiKeyAuth(resolvedConfig?.apiKey, 'X-API-Key', 'header')
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 201,
      })
      .addError({
        error: ThrowableError,
        contentType: ContentType.Json,
        status: 400,
      })
      .addError({
        error: ThrowableError,
        contentType: ContentType.Json,
        status: 409,
      })
      .addError({
        error: ThrowableError,
        contentType: ContentType.Json,
        status: 500,
      })
      .addHeaderParam({
        key: 'x-mock-response-code',
        value: params?.xMockResponseCode,
      })
      .addHeaderParam({ key: 'Content-Type', value: 'application/json' })
      .addBody(body)
      .build();
    return this.client.callDirect<any>(request);
  }

  /**
 * ## Retrieve a Vehicle
Fetches the details of a single vehicle by its unique identifier.

**Method:** `GET`  
**Endpoint:** `{{baseUrl}}/vehicles/:id`

### Path Parameters
| Parameter | Type | Required | Description |
|-----------|------|----------|-------------|
| id | string | Yes | The unique identifier of the vehicle to retrieve. |

### Request Headers
| Header | Value | Description |
|--------|-------|-------------|
| Accept | application/json | Expected response format. |

### Request Body
None required.

### Responses
| Status Code | Description |
|-------------|-------------|
| 200 | Success — returns the vehicle object matching the given ID. |
| 404 | Not found — no vehicle exists with the specified ID. |
| 500 | Unexpected server error. |
 * @param {string} id - 
 * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
 * @returns {Promise<HttpResponse<any>>} - 200 - Success
 */
  async retrieveAVehicle(id: string, requestConfig?: Partial<SdkConfig>): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.retrieveAVehicleConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('GET')
      .setPath('/vehicles/{id}')
      .setRequestSchema(z.any())
      .addApiKeyAuth(resolvedConfig?.apiKey, 'X-API-Key', 'header')
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 200,
      })
      .addError({
        error: ThrowableError,
        contentType: ContentType.Json,
        status: 404,
      })
      .addError({
        error: ThrowableError,
        contentType: ContentType.Json,
        status: 500,
      })
      .addPathParam({
        key: 'id',
        value: id,
      })
      .build();
    return this.client.callDirect<any>(request);
  }

  /**
 * ## Update a Vehicle
Partially updates an existing vehicle record using its unique identifier. Only the fields provided in the request body will be updated.

**Method:** `PATCH`  
**Endpoint:** `{{baseUrl}}/vehicles/:id`

### Path Parameters
| Parameter | Type | Required | Description |
|-----------|------|----------|-------------|
| id | string | Yes | The unique identifier of the vehicle to update. |

### Request Headers
| Header | Value | Description |
|--------|-------|-------------|
| Content-Type | application/json | Required. Specifies the request body format. |
| Accept | application/json | Expected response format. |

### Request Body
Send a JSON object with one or more of the following fields to update:

| Field | Type | Required | Description |
|-------|------|----------|-------------|
| nickName | string | No | Updated friendly name for the vehicle. |
| vin | string | No | Updated Vehicle Identification Number. |
| make | string | No | Updated manufacturer name. |
| model | string | No | Updated model name. |
| year | string | No | Updated manufacturing year. |
| miles | number | No | Updated odometer reading in miles. |

**Example Request Body:**
```json
{
  "nickName": "The Lisa Marie",
  "vin": "4M2DV11W4RDJ53329",
  "make": "Mercury",
  "model": "Villager",
  "year": "1994",
  "miles": 159999
}
```

### Responses
| Status Code | Description |
|-------------|-------------|
| 200 | Success — returns the updated vehicle object. |
| 400 | Bad request — the request body is malformed or contains invalid values. |
| 500 | Unexpected server error. |
 * @param {string} id - 
 * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
 * @returns {Promise<HttpResponse<any>>} - 200 - Success
 */
  async updateACollection(
    id: string,
    body: CreateAVehicleRequest,
    requestConfig?: Partial<SdkConfig>,
  ): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.updateACollectionConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('PATCH')
      .setPath('/vehicles/{id}')
      .setRequestSchema(createAVehicleRequestRequest)
      .addApiKeyAuth(resolvedConfig?.apiKey, 'X-API-Key', 'header')
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 200,
      })
      .addError({
        error: ThrowableError,
        contentType: ContentType.Json,
        status: 400,
      })
      .addError({
        error: ThrowableError,
        contentType: ContentType.Json,
        status: 500,
      })
      .addPathParam({
        key: 'id',
        value: id,
      })
      .addHeaderParam({ key: 'Content-Type', value: 'application/json' })
      .addBody(body)
      .build();
    return this.client.callDirect<any>(request);
  }

  /**
 * ## Delete a Vehicle
Permanently removes a vehicle record from the system using its unique identifier.

**Method:** `DELETE`  
**Endpoint:** `{{baseUrl}}/vehicles/:id`

### Path Parameters
| Parameter | Type | Required | Description |
|-----------|------|----------|-------------|
| id | string | Yes | The unique identifier of the vehicle to delete. |

### Request Headers
| Header | Value | Description |
|--------|-------|-------------|
| Accept | application/json | Expected response format. |

### Request Body
None required.

### Responses
| Status Code | Description |
|-------------|-------------|
| 204 | Success — vehicle deleted. No content returned. |
| 500 | Unexpected server error. |
 * @param {string} id - 
 * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
 * @returns {Promise<HttpResponse<string>>} - 204 - Success
 */
  async deleteAVehicle(id: string, requestConfig?: Partial<SdkConfig>): Promise<string> {
    const resolvedConfig = this.getResolvedConfig(this.deleteAVehicleConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('DELETE')
      .setPath('/vehicles/{id}')
      .setRequestSchema(z.any())
      .addApiKeyAuth(resolvedConfig?.apiKey, 'X-API-Key', 'header')
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.string(),
        contentType: ContentType.Json,
        status: 204,
      })
      .addError({
        error: ThrowableError,
        contentType: ContentType.Json,
        status: 500,
      })
      .addPathParam({
        key: 'id',
        value: id,
      })
      .build();
    return this.client.callDirect<string>(request);
  }

  /**
 * ## Get All Vehicles
Retrieves a list of all vehicle records stored in the system.

**Method:** `GET`  
**Endpoint:** `{{baseUrl}}/vehicles`

### Request Headers
| Header | Value | Description |
|--------|-------|-------------|
| Accept | application/json | Expected response format. |

### Request Body
None required.

### Responses
| Status Code | Description |
|-------------|-------------|
| 200 | Success — returns an array of vehicle objects. |
| 500 | Unexpected server error. |

### Example Response (200 - Success)
Returns a JSON array of vehicle objects, each containing fields such as `id`, `nickName`, `vin`, `make`, `model`, `year`, and `miles`.
 * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
 * @returns {Promise<HttpResponse<any>>} - 200 - Success
 */
  async getAllVehicles(requestConfig?: Partial<SdkConfig>): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.getAllVehiclesConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('GET')
      .setPath('/vehicles')
      .setRequestSchema(z.any())
      .addApiKeyAuth(resolvedConfig?.apiKey, 'X-API-Key', 'header')
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 200,
      })
      .addError({
        error: ThrowableError,
        contentType: ContentType.Json,
        status: 500,
      })
      .build();
    return this.client.callDirect<any>(request);
  }
}
