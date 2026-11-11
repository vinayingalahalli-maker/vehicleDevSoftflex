package com.vehicleservicecollectionsdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.vehicleservicecollectionsdk.config.RequestConfig;
import com.vehicleservicecollectionsdk.config.VehicleServiceCollectionSdkConfig;
import com.vehicleservicecollectionsdk.exceptions.ApiError;
import com.vehicleservicecollectionsdk.http.Environment;
import com.vehicleservicecollectionsdk.http.HttpMethod;
import com.vehicleservicecollectionsdk.http.ModelConverter;
import com.vehicleservicecollectionsdk.http.VehicleServiceCollectionSdkResponse;
import com.vehicleservicecollectionsdk.http.util.RequestBuilder;
import com.vehicleservicecollectionsdk.models.CreateAVehicleParameters;
import com.vehicleservicecollectionsdk.models.CreateAVehicleRequest;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * VehicleServiceCollectionSdkService Service
 */
public class VehicleServiceCollectionSdkService extends BaseService {

  private RequestConfig createAVehicleConfig;
  private RequestConfig retrieveAVehicleConfig;
  private RequestConfig updateACollectionConfig;
  private RequestConfig deleteAVehicleConfig;
  private RequestConfig getAllVehiclesConfig;

  /**
   * Constructs a new instance of VehicleServiceCollectionSdkService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public VehicleServiceCollectionSdkService(
    @NonNull OkHttpClient httpClient,
    VehicleServiceCollectionSdkConfig config
  ) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code createAVehicle}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public VehicleServiceCollectionSdkService setCreateAVehicleConfig(RequestConfig config) {
    this.createAVehicleConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code retrieveAVehicle}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public VehicleServiceCollectionSdkService setRetrieveAVehicleConfig(RequestConfig config) {
    this.retrieveAVehicleConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code updateACollection}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public VehicleServiceCollectionSdkService setUpdateACollectionConfig(RequestConfig config) {
    this.updateACollectionConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code deleteAVehicle}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public VehicleServiceCollectionSdkService setDeleteAVehicleConfig(RequestConfig config) {
    this.deleteAVehicleConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code getAllVehicles}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public VehicleServiceCollectionSdkService setGetAllVehiclesConfig(RequestConfig config) {
    this.getAllVehiclesConfig = config;
    return this;
  }

  /**
   * ## Create a Vehicle
   *
   * Creates a new vehicle record in the system.
   *
   * **Method:** `POST`
   * **Endpoint:** `{{baseUrl}}/vehicles`
   *
   * ### Request Headers
   * | Header | Value | Description |
   * |--------|-------|-------------|
   * | Content-Type | application/json | Required. Specifies the request body format. |
   * | Accept | application/json | Expected response format. |
   *
   * ### Request Body
   * Send a JSON object with the following fields:
   *
   * | Field | Type | Required | Description |
   * |-------|------|----------|-------------|
   * | nickName | string | Yes | A friendly name for the vehicle. |
   * | vin | string | Yes | Vehicle Identification Number (17 characters). |
   * | make | string | Yes | Manufacturer of the vehicle (e.g., Mercury). |
   * | model | string | Yes | Model name of the vehicle (e.g., Villager). |
   * | year | string | Yes | Manufacturing year of the vehicle (e.g., "1994"). |
   * | miles | number | Yes | Current odometer reading in miles. |
   *
   * **Example Request Body:**
   * ```json
   * {
   * "nickName": "The Lisa Marie",
   * "vin": "4M2DV11W4RDJ53329",
   * "make": "Mercury",
   * "model": "Villager",
   * "year": "1994",
   * "miles": 159864
   * }
   * ```
   *
   * ### Responses
   * | Status Code | Description |
   * |-------------|-------------|
   * | 201 | Vehicle successfully created. Returns the created vehicle object. |
   * | 400 | Bad request — one or more required attributes are missing or invalid. |
   * | 409 | Conflict — a vehicle with the same VIN already exists. |
   * | 500 | Unexpected server error. |
   *
   * @param requestParameters {@link CreateAVehicleParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object createAVehicle(@NonNull CreateAVehicleParameters requestParameters)
    throws ApiError {
    return this.createAVehicle(requestParameters, null);
  }

  /**
   * ## Create a Vehicle
   *
   * Creates a new vehicle record in the system.
   *
   * **Method:** `POST`
   * **Endpoint:** `{{baseUrl}}/vehicles`
   *
   * ### Request Headers
   * | Header | Value | Description |
   * |--------|-------|-------------|
   * | Content-Type | application/json | Required. Specifies the request body format. |
   * | Accept | application/json | Expected response format. |
   *
   * ### Request Body
   * Send a JSON object with the following fields:
   *
   * | Field | Type | Required | Description |
   * |-------|------|----------|-------------|
   * | nickName | string | Yes | A friendly name for the vehicle. |
   * | vin | string | Yes | Vehicle Identification Number (17 characters). |
   * | make | string | Yes | Manufacturer of the vehicle (e.g., Mercury). |
   * | model | string | Yes | Model name of the vehicle (e.g., Villager). |
   * | year | string | Yes | Manufacturing year of the vehicle (e.g., "1994"). |
   * | miles | number | Yes | Current odometer reading in miles. |
   *
   * **Example Request Body:**
   * ```json
   * {
   * "nickName": "The Lisa Marie",
   * "vin": "4M2DV11W4RDJ53329",
   * "make": "Mercury",
   * "model": "Villager",
   * "year": "1994",
   * "miles": 159864
   * }
   * ```
   *
   * ### Responses
   * | Status Code | Description |
   * |-------------|-------------|
   * | 201 | Vehicle successfully created. Returns the created vehicle object. |
   * | 400 | Bad request — one or more required attributes are missing or invalid. |
   * | 409 | Conflict — a vehicle with the same VIN already exists. |
   * | 500 | Unexpected server error. |
   *
   * @param requestParameters {@link CreateAVehicleParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object createAVehicle(
    @NonNull CreateAVehicleParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse().createAVehicle(requestParameters, requestConfig).getData();
  }

  /**
   * ## Create a Vehicle
   *
   * Creates a new vehicle record in the system.
   *
   * **Method:** `POST`
   * **Endpoint:** `{{baseUrl}}/vehicles`
   *
   * ### Request Headers
   * | Header | Value | Description |
   * |--------|-------|-------------|
   * | Content-Type | application/json | Required. Specifies the request body format. |
   * | Accept | application/json | Expected response format. |
   *
   * ### Request Body
   * Send a JSON object with the following fields:
   *
   * | Field | Type | Required | Description |
   * |-------|------|----------|-------------|
   * | nickName | string | Yes | A friendly name for the vehicle. |
   * | vin | string | Yes | Vehicle Identification Number (17 characters). |
   * | make | string | Yes | Manufacturer of the vehicle (e.g., Mercury). |
   * | model | string | Yes | Model name of the vehicle (e.g., Villager). |
   * | year | string | Yes | Manufacturing year of the vehicle (e.g., "1994"). |
   * | miles | number | Yes | Current odometer reading in miles. |
   *
   * **Example Request Body:**
   * ```json
   * {
   * "nickName": "The Lisa Marie",
   * "vin": "4M2DV11W4RDJ53329",
   * "make": "Mercury",
   * "model": "Villager",
   * "year": "1994",
   * "miles": 159864
   * }
   * ```
   *
   * ### Responses
   * | Status Code | Description |
   * |-------------|-------------|
   * | 201 | Vehicle successfully created. Returns the created vehicle object. |
   * | 400 | Bad request — one or more required attributes are missing or invalid. |
   * | 409 | Conflict — a vehicle with the same VIN already exists. |
   * | 500 | Unexpected server error. |
   *
   * @param requestParameters {@link CreateAVehicleParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createAVehicleAsync(
    @NonNull CreateAVehicleParameters requestParameters
  ) throws ApiError {
    return this.createAVehicleAsync(requestParameters, null);
  }

  /**
   * ## Create a Vehicle
   *
   * Creates a new vehicle record in the system.
   *
   * **Method:** `POST`
   * **Endpoint:** `{{baseUrl}}/vehicles`
   *
   * ### Request Headers
   * | Header | Value | Description |
   * |--------|-------|-------------|
   * | Content-Type | application/json | Required. Specifies the request body format. |
   * | Accept | application/json | Expected response format. |
   *
   * ### Request Body
   * Send a JSON object with the following fields:
   *
   * | Field | Type | Required | Description |
   * |-------|------|----------|-------------|
   * | nickName | string | Yes | A friendly name for the vehicle. |
   * | vin | string | Yes | Vehicle Identification Number (17 characters). |
   * | make | string | Yes | Manufacturer of the vehicle (e.g., Mercury). |
   * | model | string | Yes | Model name of the vehicle (e.g., Villager). |
   * | year | string | Yes | Manufacturing year of the vehicle (e.g., "1994"). |
   * | miles | number | Yes | Current odometer reading in miles. |
   *
   * **Example Request Body:**
   * ```json
   * {
   * "nickName": "The Lisa Marie",
   * "vin": "4M2DV11W4RDJ53329",
   * "make": "Mercury",
   * "model": "Villager",
   * "year": "1994",
   * "miles": 159864
   * }
   * ```
   *
   * ### Responses
   * | Status Code | Description |
   * |-------------|-------------|
   * | 201 | Vehicle successfully created. Returns the created vehicle object. |
   * | 400 | Bad request — one or more required attributes are missing or invalid. |
   * | 409 | Conflict — a vehicle with the same VIN already exists. |
   * | 500 | Unexpected server error. |
   *
   * @param requestParameters {@link CreateAVehicleParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createAVehicleAsync(
    @NonNull CreateAVehicleParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .createAVehicleAsync(requestParameters, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildCreateAVehicleRequest(
    @NonNull CreateAVehicleParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "vehicles"
    )
      .setApiKeyAuth(resolveApiKeyAuthConfig(resolvedConfig))
      .setOptionalHeader("x-mock-response-code", requestParameters.getXMockResponseCode())
      .setJsonContent(requestParameters.getRequestBody())
      .build();
  }

  /**
   * ## Retrieve a Vehicle
   *
   * Fetches the details of a single vehicle by its unique identifier.
   *
   * **Method:** `GET`
   * **Endpoint:** `{{baseUrl}}/vehicles/:id`
   *
   * ### Path Parameters
   * | Parameter | Type | Required | Description |
   * |-----------|------|----------|-------------|
   * | id | string | Yes | The unique identifier of the vehicle to retrieve. |
   *
   * ### Request Headers
   * | Header | Value | Description |
   * |--------|-------|-------------|
   * | Accept | application/json | Expected response format. |
   *
   * ### Request Body
   * None required.
   *
   * ### Responses
   * | Status Code | Description |
   * |-------------|-------------|
   * | 200 | Success — returns the vehicle object matching the given ID. |
   * | 404 | Not found — no vehicle exists with the specified ID. |
   * | 500 | Unexpected server error. |
   *
   * @param id String
   * @return response of {@code Object}
   */
  public Object retrieveAVehicle(@NonNull String id) throws ApiError {
    return this.retrieveAVehicle(id, null);
  }

  /**
   * ## Retrieve a Vehicle
   *
   * Fetches the details of a single vehicle by its unique identifier.
   *
   * **Method:** `GET`
   * **Endpoint:** `{{baseUrl}}/vehicles/:id`
   *
   * ### Path Parameters
   * | Parameter | Type | Required | Description |
   * |-----------|------|----------|-------------|
   * | id | string | Yes | The unique identifier of the vehicle to retrieve. |
   *
   * ### Request Headers
   * | Header | Value | Description |
   * |--------|-------|-------------|
   * | Accept | application/json | Expected response format. |
   *
   * ### Request Body
   * None required.
   *
   * ### Responses
   * | Status Code | Description |
   * |-------------|-------------|
   * | 200 | Success — returns the vehicle object matching the given ID. |
   * | 404 | Not found — no vehicle exists with the specified ID. |
   * | 500 | Unexpected server error. |
   *
   * @param id String
   * @return response of {@code Object}
   */
  public Object retrieveAVehicle(@NonNull String id, RequestConfig requestConfig) throws ApiError {
    return withRawResponse().retrieveAVehicle(id, requestConfig).getData();
  }

  /**
   * ## Retrieve a Vehicle
   *
   * Fetches the details of a single vehicle by its unique identifier.
   *
   * **Method:** `GET`
   * **Endpoint:** `{{baseUrl}}/vehicles/:id`
   *
   * ### Path Parameters
   * | Parameter | Type | Required | Description |
   * |-----------|------|----------|-------------|
   * | id | string | Yes | The unique identifier of the vehicle to retrieve. |
   *
   * ### Request Headers
   * | Header | Value | Description |
   * |--------|-------|-------------|
   * | Accept | application/json | Expected response format. |
   *
   * ### Request Body
   * None required.
   *
   * ### Responses
   * | Status Code | Description |
   * |-------------|-------------|
   * | 200 | Success — returns the vehicle object matching the given ID. |
   * | 404 | Not found — no vehicle exists with the specified ID. |
   * | 500 | Unexpected server error. |
   *
   * @param id String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> retrieveAVehicleAsync(@NonNull String id) throws ApiError {
    return this.retrieveAVehicleAsync(id, null);
  }

  /**
   * ## Retrieve a Vehicle
   *
   * Fetches the details of a single vehicle by its unique identifier.
   *
   * **Method:** `GET`
   * **Endpoint:** `{{baseUrl}}/vehicles/:id`
   *
   * ### Path Parameters
   * | Parameter | Type | Required | Description |
   * |-----------|------|----------|-------------|
   * | id | string | Yes | The unique identifier of the vehicle to retrieve. |
   *
   * ### Request Headers
   * | Header | Value | Description |
   * |--------|-------|-------------|
   * | Accept | application/json | Expected response format. |
   *
   * ### Request Body
   * None required.
   *
   * ### Responses
   * | Status Code | Description |
   * |-------------|-------------|
   * | 200 | Success — returns the vehicle object matching the given ID. |
   * | 404 | Not found — no vehicle exists with the specified ID. |
   * | 500 | Unexpected server error. |
   *
   * @param id String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> retrieveAVehicleAsync(
    @NonNull String id,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .retrieveAVehicleAsync(id, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildRetrieveAVehicleRequest(@NonNull String id, RequestConfig resolvedConfig) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "vehicles/{id}"
    )
      .setApiKeyAuth(resolveApiKeyAuthConfig(resolvedConfig))
      .setPathParameter("id", id)
      .build();
  }

  /**
   * ## Update a Vehicle
   *
   * Partially updates an existing vehicle record using its unique identifier. Only the fields provided in the request body will be updated.
   *
   * **Method:** `PATCH`
   * **Endpoint:** `{{baseUrl}}/vehicles/:id`
   *
   * ### Path Parameters
   * | Parameter | Type | Required | Description |
   * |-----------|------|----------|-------------|
   * | id | string | Yes | The unique identifier of the vehicle to update. |
   *
   * ### Request Headers
   * | Header | Value | Description |
   * |--------|-------|-------------|
   * | Content-Type | application/json | Required. Specifies the request body format. |
   * | Accept | application/json | Expected response format. |
   *
   * ### Request Body
   * Send a JSON object with one or more of the following fields to update:
   *
   * | Field | Type | Required | Description |
   * |-------|------|----------|-------------|
   * | nickName | string | No | Updated friendly name for the vehicle. |
   * | vin | string | No | Updated Vehicle Identification Number. |
   * | make | string | No | Updated manufacturer name. |
   * | model | string | No | Updated model name. |
   * | year | string | No | Updated manufacturing year. |
   * | miles | number | No | Updated odometer reading in miles. |
   *
   * **Example Request Body:**
   * ```json
   * {
   * "nickName": "The Lisa Marie",
   * "vin": "4M2DV11W4RDJ53329",
   * "make": "Mercury",
   * "model": "Villager",
   * "year": "1994",
   * "miles": 159999
   * }
   * ```
   *
   * ### Responses
   * | Status Code | Description |
   * |-------------|-------------|
   * | 200 | Success — returns the updated vehicle object. |
   * | 400 | Bad request — the request body is malformed or contains invalid values. |
   * | 500 | Unexpected server error. |
   *
   * @param id String
   * @param createAVehicleRequest {@link CreateAVehicleRequest} Request Body
   * @return response of {@code Object}
   */
  public Object updateACollection(
    @NonNull String id,
    @NonNull CreateAVehicleRequest createAVehicleRequest
  ) throws ApiError {
    return this.updateACollection(id, createAVehicleRequest, null);
  }

  /**
   * ## Update a Vehicle
   *
   * Partially updates an existing vehicle record using its unique identifier. Only the fields provided in the request body will be updated.
   *
   * **Method:** `PATCH`
   * **Endpoint:** `{{baseUrl}}/vehicles/:id`
   *
   * ### Path Parameters
   * | Parameter | Type | Required | Description |
   * |-----------|------|----------|-------------|
   * | id | string | Yes | The unique identifier of the vehicle to update. |
   *
   * ### Request Headers
   * | Header | Value | Description |
   * |--------|-------|-------------|
   * | Content-Type | application/json | Required. Specifies the request body format. |
   * | Accept | application/json | Expected response format. |
   *
   * ### Request Body
   * Send a JSON object with one or more of the following fields to update:
   *
   * | Field | Type | Required | Description |
   * |-------|------|----------|-------------|
   * | nickName | string | No | Updated friendly name for the vehicle. |
   * | vin | string | No | Updated Vehicle Identification Number. |
   * | make | string | No | Updated manufacturer name. |
   * | model | string | No | Updated model name. |
   * | year | string | No | Updated manufacturing year. |
   * | miles | number | No | Updated odometer reading in miles. |
   *
   * **Example Request Body:**
   * ```json
   * {
   * "nickName": "The Lisa Marie",
   * "vin": "4M2DV11W4RDJ53329",
   * "make": "Mercury",
   * "model": "Villager",
   * "year": "1994",
   * "miles": 159999
   * }
   * ```
   *
   * ### Responses
   * | Status Code | Description |
   * |-------------|-------------|
   * | 200 | Success — returns the updated vehicle object. |
   * | 400 | Bad request — the request body is malformed or contains invalid values. |
   * | 500 | Unexpected server error. |
   *
   * @param id String
   * @param createAVehicleRequest {@link CreateAVehicleRequest} Request Body
   * @return response of {@code Object}
   */
  public Object updateACollection(
    @NonNull String id,
    @NonNull CreateAVehicleRequest createAVehicleRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse().updateACollection(id, createAVehicleRequest, requestConfig).getData();
  }

  /**
   * ## Update a Vehicle
   *
   * Partially updates an existing vehicle record using its unique identifier. Only the fields provided in the request body will be updated.
   *
   * **Method:** `PATCH`
   * **Endpoint:** `{{baseUrl}}/vehicles/:id`
   *
   * ### Path Parameters
   * | Parameter | Type | Required | Description |
   * |-----------|------|----------|-------------|
   * | id | string | Yes | The unique identifier of the vehicle to update. |
   *
   * ### Request Headers
   * | Header | Value | Description |
   * |--------|-------|-------------|
   * | Content-Type | application/json | Required. Specifies the request body format. |
   * | Accept | application/json | Expected response format. |
   *
   * ### Request Body
   * Send a JSON object with one or more of the following fields to update:
   *
   * | Field | Type | Required | Description |
   * |-------|------|----------|-------------|
   * | nickName | string | No | Updated friendly name for the vehicle. |
   * | vin | string | No | Updated Vehicle Identification Number. |
   * | make | string | No | Updated manufacturer name. |
   * | model | string | No | Updated model name. |
   * | year | string | No | Updated manufacturing year. |
   * | miles | number | No | Updated odometer reading in miles. |
   *
   * **Example Request Body:**
   * ```json
   * {
   * "nickName": "The Lisa Marie",
   * "vin": "4M2DV11W4RDJ53329",
   * "make": "Mercury",
   * "model": "Villager",
   * "year": "1994",
   * "miles": 159999
   * }
   * ```
   *
   * ### Responses
   * | Status Code | Description |
   * |-------------|-------------|
   * | 200 | Success — returns the updated vehicle object. |
   * | 400 | Bad request — the request body is malformed or contains invalid values. |
   * | 500 | Unexpected server error. |
   *
   * @param id String
   * @param createAVehicleRequest {@link CreateAVehicleRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> updateACollectionAsync(
    @NonNull String id,
    @NonNull CreateAVehicleRequest createAVehicleRequest
  ) throws ApiError {
    return this.updateACollectionAsync(id, createAVehicleRequest, null);
  }

  /**
   * ## Update a Vehicle
   *
   * Partially updates an existing vehicle record using its unique identifier. Only the fields provided in the request body will be updated.
   *
   * **Method:** `PATCH`
   * **Endpoint:** `{{baseUrl}}/vehicles/:id`
   *
   * ### Path Parameters
   * | Parameter | Type | Required | Description |
   * |-----------|------|----------|-------------|
   * | id | string | Yes | The unique identifier of the vehicle to update. |
   *
   * ### Request Headers
   * | Header | Value | Description |
   * |--------|-------|-------------|
   * | Content-Type | application/json | Required. Specifies the request body format. |
   * | Accept | application/json | Expected response format. |
   *
   * ### Request Body
   * Send a JSON object with one or more of the following fields to update:
   *
   * | Field | Type | Required | Description |
   * |-------|------|----------|-------------|
   * | nickName | string | No | Updated friendly name for the vehicle. |
   * | vin | string | No | Updated Vehicle Identification Number. |
   * | make | string | No | Updated manufacturer name. |
   * | model | string | No | Updated model name. |
   * | year | string | No | Updated manufacturing year. |
   * | miles | number | No | Updated odometer reading in miles. |
   *
   * **Example Request Body:**
   * ```json
   * {
   * "nickName": "The Lisa Marie",
   * "vin": "4M2DV11W4RDJ53329",
   * "make": "Mercury",
   * "model": "Villager",
   * "year": "1994",
   * "miles": 159999
   * }
   * ```
   *
   * ### Responses
   * | Status Code | Description |
   * |-------------|-------------|
   * | 200 | Success — returns the updated vehicle object. |
   * | 400 | Bad request — the request body is malformed or contains invalid values. |
   * | 500 | Unexpected server error. |
   *
   * @param id String
   * @param createAVehicleRequest {@link CreateAVehicleRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> updateACollectionAsync(
    @NonNull String id,
    @NonNull CreateAVehicleRequest createAVehicleRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .updateACollectionAsync(id, createAVehicleRequest, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildUpdateACollectionRequest(
    @NonNull String id,
    @NonNull CreateAVehicleRequest createAVehicleRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PATCH,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "vehicles/{id}"
    )
      .setApiKeyAuth(resolveApiKeyAuthConfig(resolvedConfig))
      .setPathParameter("id", id)
      .setJsonContent(createAVehicleRequest)
      .build();
  }

  /**
   * ## Delete a Vehicle
   *
   * Permanently removes a vehicle record from the system using its unique identifier.
   *
   * **Method:** `DELETE`
   * **Endpoint:** `{{baseUrl}}/vehicles/:id`
   *
   * ### Path Parameters
   * | Parameter | Type | Required | Description |
   * |-----------|------|----------|-------------|
   * | id | string | Yes | The unique identifier of the vehicle to delete. |
   *
   * ### Request Headers
   * | Header | Value | Description |
   * |--------|-------|-------------|
   * | Accept | application/json | Expected response format. |
   *
   * ### Request Body
   * None required.
   *
   * ### Responses
   * | Status Code | Description |
   * |-------------|-------------|
   * | 204 | Success — vehicle deleted. No content returned. |
   * | 500 | Unexpected server error. |
   *
   * @param id String
   * @return response of {@code String}
   */
  public String deleteAVehicle(@NonNull String id) throws ApiError {
    return this.deleteAVehicle(id, null);
  }

  /**
   * ## Delete a Vehicle
   *
   * Permanently removes a vehicle record from the system using its unique identifier.
   *
   * **Method:** `DELETE`
   * **Endpoint:** `{{baseUrl}}/vehicles/:id`
   *
   * ### Path Parameters
   * | Parameter | Type | Required | Description |
   * |-----------|------|----------|-------------|
   * | id | string | Yes | The unique identifier of the vehicle to delete. |
   *
   * ### Request Headers
   * | Header | Value | Description |
   * |--------|-------|-------------|
   * | Accept | application/json | Expected response format. |
   *
   * ### Request Body
   * None required.
   *
   * ### Responses
   * | Status Code | Description |
   * |-------------|-------------|
   * | 204 | Success — vehicle deleted. No content returned. |
   * | 500 | Unexpected server error. |
   *
   * @param id String
   * @return response of {@code String}
   */
  public String deleteAVehicle(@NonNull String id, RequestConfig requestConfig) throws ApiError {
    return withRawResponse().deleteAVehicle(id, requestConfig).getData();
  }

  /**
   * ## Delete a Vehicle
   *
   * Permanently removes a vehicle record from the system using its unique identifier.
   *
   * **Method:** `DELETE`
   * **Endpoint:** `{{baseUrl}}/vehicles/:id`
   *
   * ### Path Parameters
   * | Parameter | Type | Required | Description |
   * |-----------|------|----------|-------------|
   * | id | string | Yes | The unique identifier of the vehicle to delete. |
   *
   * ### Request Headers
   * | Header | Value | Description |
   * |--------|-------|-------------|
   * | Accept | application/json | Expected response format. |
   *
   * ### Request Body
   * None required.
   *
   * ### Responses
   * | Status Code | Description |
   * |-------------|-------------|
   * | 204 | Success — vehicle deleted. No content returned. |
   * | 500 | Unexpected server error. |
   *
   * @param id String
   * @return response of {@code CompletableFuture<String>}
   */
  public CompletableFuture<String> deleteAVehicleAsync(@NonNull String id) throws ApiError {
    return this.deleteAVehicleAsync(id, null);
  }

  /**
   * ## Delete a Vehicle
   *
   * Permanently removes a vehicle record from the system using its unique identifier.
   *
   * **Method:** `DELETE`
   * **Endpoint:** `{{baseUrl}}/vehicles/:id`
   *
   * ### Path Parameters
   * | Parameter | Type | Required | Description |
   * |-----------|------|----------|-------------|
   * | id | string | Yes | The unique identifier of the vehicle to delete. |
   *
   * ### Request Headers
   * | Header | Value | Description |
   * |--------|-------|-------------|
   * | Accept | application/json | Expected response format. |
   *
   * ### Request Body
   * None required.
   *
   * ### Responses
   * | Status Code | Description |
   * |-------------|-------------|
   * | 204 | Success — vehicle deleted. No content returned. |
   * | 500 | Unexpected server error. |
   *
   * @param id String
   * @return response of {@code CompletableFuture<String>}
   */
  public CompletableFuture<String> deleteAVehicleAsync(
    @NonNull String id,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .deleteAVehicleAsync(id, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildDeleteAVehicleRequest(@NonNull String id, RequestConfig resolvedConfig) {
    return new RequestBuilder(
      HttpMethod.DELETE,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "vehicles/{id}"
    )
      .setApiKeyAuth(resolveApiKeyAuthConfig(resolvedConfig))
      .setPathParameter("id", id)
      .build();
  }

  /**
   * ## Get All Vehicles
   *
   * Retrieves a list of all vehicle records stored in the system.
   *
   * **Method:** `GET`
   * **Endpoint:** `{{baseUrl}}/vehicles`
   *
   * ### Request Headers
   * | Header | Value | Description |
   * |--------|-------|-------------|
   * | Accept | application/json | Expected response format. |
   *
   * ### Request Body
   * None required.
   *
   * ### Responses
   * | Status Code | Description |
   * |-------------|-------------|
   * | 200 | Success — returns an array of vehicle objects. |
   * | 500 | Unexpected server error. |
   *
   * ### Example Response (200 - Success)
   * Returns a JSON array of vehicle objects, each containing fields such as `id`, `nickName`, `vin`, `make`, `model`, `year`, and `miles`.
   *
   * @return response of {@code Object}
   */
  public Object getAllVehicles() throws ApiError {
    return this.getAllVehicles(null);
  }

  /**
   * ## Get All Vehicles
   *
   * Retrieves a list of all vehicle records stored in the system.
   *
   * **Method:** `GET`
   * **Endpoint:** `{{baseUrl}}/vehicles`
   *
   * ### Request Headers
   * | Header | Value | Description |
   * |--------|-------|-------------|
   * | Accept | application/json | Expected response format. |
   *
   * ### Request Body
   * None required.
   *
   * ### Responses
   * | Status Code | Description |
   * |-------------|-------------|
   * | 200 | Success — returns an array of vehicle objects. |
   * | 500 | Unexpected server error. |
   *
   * ### Example Response (200 - Success)
   * Returns a JSON array of vehicle objects, each containing fields such as `id`, `nickName`, `vin`, `make`, `model`, `year`, and `miles`.
   *
   * @return response of {@code Object}
   */
  public Object getAllVehicles(RequestConfig requestConfig) throws ApiError {
    return withRawResponse().getAllVehicles(requestConfig).getData();
  }

  /**
   * ## Get All Vehicles
   *
   * Retrieves a list of all vehicle records stored in the system.
   *
   * **Method:** `GET`
   * **Endpoint:** `{{baseUrl}}/vehicles`
   *
   * ### Request Headers
   * | Header | Value | Description |
   * |--------|-------|-------------|
   * | Accept | application/json | Expected response format. |
   *
   * ### Request Body
   * None required.
   *
   * ### Responses
   * | Status Code | Description |
   * |-------------|-------------|
   * | 200 | Success — returns an array of vehicle objects. |
   * | 500 | Unexpected server error. |
   *
   * ### Example Response (200 - Success)
   * Returns a JSON array of vehicle objects, each containing fields such as `id`, `nickName`, `vin`, `make`, `model`, `year`, and `miles`.
   *
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getAllVehiclesAsync() throws ApiError {
    return this.getAllVehiclesAsync(null);
  }

  /**
   * ## Get All Vehicles
   *
   * Retrieves a list of all vehicle records stored in the system.
   *
   * **Method:** `GET`
   * **Endpoint:** `{{baseUrl}}/vehicles`
   *
   * ### Request Headers
   * | Header | Value | Description |
   * |--------|-------|-------------|
   * | Accept | application/json | Expected response format. |
   *
   * ### Request Body
   * None required.
   *
   * ### Responses
   * | Status Code | Description |
   * |-------------|-------------|
   * | 200 | Success — returns an array of vehicle objects. |
   * | 500 | Unexpected server error. |
   *
   * ### Example Response (200 - Success)
   * Returns a JSON array of vehicle objects, each containing fields such as `id`, `nickName`, `vin`, `make`, `model`, `year`, and `miles`.
   *
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getAllVehiclesAsync(RequestConfig requestConfig)
    throws ApiError {
    return withRawResponse()
      .getAllVehiclesAsync(requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildGetAllVehiclesRequest(RequestConfig resolvedConfig) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "vehicles"
    )
      .setApiKeyAuth(resolveApiKeyAuthConfig(resolvedConfig))
      .build();
  }

  /**
   * Returns an accessor whose methods mirror this service but return the full HTTP response
   * (status code, headers, and raw body) wrapped alongside the parsed data.
   *
   * @return An accessor exposing raw-response variants of this service's methods
   */
  public WithRawResponse withRawResponse() {
    return new WithRawResponse();
  }

  /**
   * Per-call accessor exposing raw-response variants of {@link VehicleServiceCollectionSdkService}'s methods.
   * Reuses the enclosing service's request builders and configuration.
   */
  public class WithRawResponse {

    /**
     * ## Create a Vehicle
     *
     * Creates a new vehicle record in the system.
     *
     * **Method:** `POST`
     * **Endpoint:** `{{baseUrl}}/vehicles`
     *
     * ### Request Headers
     * | Header | Value | Description |
     * |--------|-------|-------------|
     * | Content-Type | application/json | Required. Specifies the request body format. |
     * | Accept | application/json | Expected response format. |
     *
     * ### Request Body
     * Send a JSON object with the following fields:
     *
     * | Field | Type | Required | Description |
     * |-------|------|----------|-------------|
     * | nickName | string | Yes | A friendly name for the vehicle. |
     * | vin | string | Yes | Vehicle Identification Number (17 characters). |
     * | make | string | Yes | Manufacturer of the vehicle (e.g., Mercury). |
     * | model | string | Yes | Model name of the vehicle (e.g., Villager). |
     * | year | string | Yes | Manufacturing year of the vehicle (e.g., "1994"). |
     * | miles | number | Yes | Current odometer reading in miles. |
     *
     * **Example Request Body:**
     * ```json
     * {
     * "nickName": "The Lisa Marie",
     * "vin": "4M2DV11W4RDJ53329",
     * "make": "Mercury",
     * "model": "Villager",
     * "year": "1994",
     * "miles": 159864
     * }
     * ```
     *
     * ### Responses
     * | Status Code | Description |
     * |-------------|-------------|
     * | 201 | Vehicle successfully created. Returns the created vehicle object. |
     * | 400 | Bad request — one or more required attributes are missing or invalid. |
     * | 409 | Conflict — a vehicle with the same VIN already exists. |
     * | 500 | Unexpected server error. |
     *
     * @param requestParameters {@link CreateAVehicleParameters} Request Parameters Object
     * @return response of {@code VehicleServiceCollectionSdkResponse<Object>}
     */
    public VehicleServiceCollectionSdkResponse<Object> createAVehicle(
      @NonNull CreateAVehicleParameters requestParameters
    ) throws ApiError {
      return this.createAVehicle(requestParameters, null);
    }

    /**
     * ## Create a Vehicle
     *
     * Creates a new vehicle record in the system.
     *
     * **Method:** `POST`
     * **Endpoint:** `{{baseUrl}}/vehicles`
     *
     * ### Request Headers
     * | Header | Value | Description |
     * |--------|-------|-------------|
     * | Content-Type | application/json | Required. Specifies the request body format. |
     * | Accept | application/json | Expected response format. |
     *
     * ### Request Body
     * Send a JSON object with the following fields:
     *
     * | Field | Type | Required | Description |
     * |-------|------|----------|-------------|
     * | nickName | string | Yes | A friendly name for the vehicle. |
     * | vin | string | Yes | Vehicle Identification Number (17 characters). |
     * | make | string | Yes | Manufacturer of the vehicle (e.g., Mercury). |
     * | model | string | Yes | Model name of the vehicle (e.g., Villager). |
     * | year | string | Yes | Manufacturing year of the vehicle (e.g., "1994"). |
     * | miles | number | Yes | Current odometer reading in miles. |
     *
     * **Example Request Body:**
     * ```json
     * {
     * "nickName": "The Lisa Marie",
     * "vin": "4M2DV11W4RDJ53329",
     * "make": "Mercury",
     * "model": "Villager",
     * "year": "1994",
     * "miles": 159864
     * }
     * ```
     *
     * ### Responses
     * | Status Code | Description |
     * |-------------|-------------|
     * | 201 | Vehicle successfully created. Returns the created vehicle object. |
     * | 400 | Bad request — one or more required attributes are missing or invalid. |
     * | 409 | Conflict — a vehicle with the same VIN already exists. |
     * | 500 | Unexpected server error. |
     *
     * @param requestParameters {@link CreateAVehicleParameters} Request Parameters Object
     * @return response of {@code VehicleServiceCollectionSdkResponse<Object>}
     */
    public VehicleServiceCollectionSdkResponse<Object> createAVehicle(
      @NonNull CreateAVehicleParameters requestParameters,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(createAVehicleConfig, requestConfig);
      Request request = buildCreateAVehicleRequest(requestParameters, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new VehicleServiceCollectionSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * ## Create a Vehicle
     *
     * Creates a new vehicle record in the system.
     *
     * **Method:** `POST`
     * **Endpoint:** `{{baseUrl}}/vehicles`
     *
     * ### Request Headers
     * | Header | Value | Description |
     * |--------|-------|-------------|
     * | Content-Type | application/json | Required. Specifies the request body format. |
     * | Accept | application/json | Expected response format. |
     *
     * ### Request Body
     * Send a JSON object with the following fields:
     *
     * | Field | Type | Required | Description |
     * |-------|------|----------|-------------|
     * | nickName | string | Yes | A friendly name for the vehicle. |
     * | vin | string | Yes | Vehicle Identification Number (17 characters). |
     * | make | string | Yes | Manufacturer of the vehicle (e.g., Mercury). |
     * | model | string | Yes | Model name of the vehicle (e.g., Villager). |
     * | year | string | Yes | Manufacturing year of the vehicle (e.g., "1994"). |
     * | miles | number | Yes | Current odometer reading in miles. |
     *
     * **Example Request Body:**
     * ```json
     * {
     * "nickName": "The Lisa Marie",
     * "vin": "4M2DV11W4RDJ53329",
     * "make": "Mercury",
     * "model": "Villager",
     * "year": "1994",
     * "miles": 159864
     * }
     * ```
     *
     * ### Responses
     * | Status Code | Description |
     * |-------------|-------------|
     * | 201 | Vehicle successfully created. Returns the created vehicle object. |
     * | 400 | Bad request — one or more required attributes are missing or invalid. |
     * | 409 | Conflict — a vehicle with the same VIN already exists. |
     * | 500 | Unexpected server error. |
     *
     * @param requestParameters {@link CreateAVehicleParameters} Request Parameters Object
     * @return response of {@code CompletableFuture<VehicleServiceCollectionSdkResponse<Object>>}
     */
    public CompletableFuture<VehicleServiceCollectionSdkResponse<Object>> createAVehicleAsync(
      @NonNull CreateAVehicleParameters requestParameters
    ) throws ApiError {
      return this.createAVehicleAsync(requestParameters, null);
    }

    /**
     * ## Create a Vehicle
     *
     * Creates a new vehicle record in the system.
     *
     * **Method:** `POST`
     * **Endpoint:** `{{baseUrl}}/vehicles`
     *
     * ### Request Headers
     * | Header | Value | Description |
     * |--------|-------|-------------|
     * | Content-Type | application/json | Required. Specifies the request body format. |
     * | Accept | application/json | Expected response format. |
     *
     * ### Request Body
     * Send a JSON object with the following fields:
     *
     * | Field | Type | Required | Description |
     * |-------|------|----------|-------------|
     * | nickName | string | Yes | A friendly name for the vehicle. |
     * | vin | string | Yes | Vehicle Identification Number (17 characters). |
     * | make | string | Yes | Manufacturer of the vehicle (e.g., Mercury). |
     * | model | string | Yes | Model name of the vehicle (e.g., Villager). |
     * | year | string | Yes | Manufacturing year of the vehicle (e.g., "1994"). |
     * | miles | number | Yes | Current odometer reading in miles. |
     *
     * **Example Request Body:**
     * ```json
     * {
     * "nickName": "The Lisa Marie",
     * "vin": "4M2DV11W4RDJ53329",
     * "make": "Mercury",
     * "model": "Villager",
     * "year": "1994",
     * "miles": 159864
     * }
     * ```
     *
     * ### Responses
     * | Status Code | Description |
     * |-------------|-------------|
     * | 201 | Vehicle successfully created. Returns the created vehicle object. |
     * | 400 | Bad request — one or more required attributes are missing or invalid. |
     * | 409 | Conflict — a vehicle with the same VIN already exists. |
     * | 500 | Unexpected server error. |
     *
     * @param requestParameters {@link CreateAVehicleParameters} Request Parameters Object
     * @return response of {@code CompletableFuture<VehicleServiceCollectionSdkResponse<Object>>}
     */
    public CompletableFuture<VehicleServiceCollectionSdkResponse<Object>> createAVehicleAsync(
      @NonNull CreateAVehicleParameters requestParameters,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(createAVehicleConfig, requestConfig);
      Request request = buildCreateAVehicleRequest(requestParameters, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new VehicleServiceCollectionSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * ## Retrieve a Vehicle
     *
     * Fetches the details of a single vehicle by its unique identifier.
     *
     * **Method:** `GET`
     * **Endpoint:** `{{baseUrl}}/vehicles/:id`
     *
     * ### Path Parameters
     * | Parameter | Type | Required | Description |
     * |-----------|------|----------|-------------|
     * | id | string | Yes | The unique identifier of the vehicle to retrieve. |
     *
     * ### Request Headers
     * | Header | Value | Description |
     * |--------|-------|-------------|
     * | Accept | application/json | Expected response format. |
     *
     * ### Request Body
     * None required.
     *
     * ### Responses
     * | Status Code | Description |
     * |-------------|-------------|
     * | 200 | Success — returns the vehicle object matching the given ID. |
     * | 404 | Not found — no vehicle exists with the specified ID. |
     * | 500 | Unexpected server error. |
     *
     * @param id String
     * @return response of {@code VehicleServiceCollectionSdkResponse<Object>}
     */
    public VehicleServiceCollectionSdkResponse<Object> retrieveAVehicle(@NonNull String id)
      throws ApiError {
      return this.retrieveAVehicle(id, null);
    }

    /**
     * ## Retrieve a Vehicle
     *
     * Fetches the details of a single vehicle by its unique identifier.
     *
     * **Method:** `GET`
     * **Endpoint:** `{{baseUrl}}/vehicles/:id`
     *
     * ### Path Parameters
     * | Parameter | Type | Required | Description |
     * |-----------|------|----------|-------------|
     * | id | string | Yes | The unique identifier of the vehicle to retrieve. |
     *
     * ### Request Headers
     * | Header | Value | Description |
     * |--------|-------|-------------|
     * | Accept | application/json | Expected response format. |
     *
     * ### Request Body
     * None required.
     *
     * ### Responses
     * | Status Code | Description |
     * |-------------|-------------|
     * | 200 | Success — returns the vehicle object matching the given ID. |
     * | 404 | Not found — no vehicle exists with the specified ID. |
     * | 500 | Unexpected server error. |
     *
     * @param id String
     * @return response of {@code VehicleServiceCollectionSdkResponse<Object>}
     */
    public VehicleServiceCollectionSdkResponse<Object> retrieveAVehicle(
      @NonNull String id,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(retrieveAVehicleConfig, requestConfig);
      Request request = buildRetrieveAVehicleRequest(id, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new VehicleServiceCollectionSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * ## Retrieve a Vehicle
     *
     * Fetches the details of a single vehicle by its unique identifier.
     *
     * **Method:** `GET`
     * **Endpoint:** `{{baseUrl}}/vehicles/:id`
     *
     * ### Path Parameters
     * | Parameter | Type | Required | Description |
     * |-----------|------|----------|-------------|
     * | id | string | Yes | The unique identifier of the vehicle to retrieve. |
     *
     * ### Request Headers
     * | Header | Value | Description |
     * |--------|-------|-------------|
     * | Accept | application/json | Expected response format. |
     *
     * ### Request Body
     * None required.
     *
     * ### Responses
     * | Status Code | Description |
     * |-------------|-------------|
     * | 200 | Success — returns the vehicle object matching the given ID. |
     * | 404 | Not found — no vehicle exists with the specified ID. |
     * | 500 | Unexpected server error. |
     *
     * @param id String
     * @return response of {@code CompletableFuture<VehicleServiceCollectionSdkResponse<Object>>}
     */
    public CompletableFuture<VehicleServiceCollectionSdkResponse<Object>> retrieveAVehicleAsync(
      @NonNull String id
    ) throws ApiError {
      return this.retrieveAVehicleAsync(id, null);
    }

    /**
     * ## Retrieve a Vehicle
     *
     * Fetches the details of a single vehicle by its unique identifier.
     *
     * **Method:** `GET`
     * **Endpoint:** `{{baseUrl}}/vehicles/:id`
     *
     * ### Path Parameters
     * | Parameter | Type | Required | Description |
     * |-----------|------|----------|-------------|
     * | id | string | Yes | The unique identifier of the vehicle to retrieve. |
     *
     * ### Request Headers
     * | Header | Value | Description |
     * |--------|-------|-------------|
     * | Accept | application/json | Expected response format. |
     *
     * ### Request Body
     * None required.
     *
     * ### Responses
     * | Status Code | Description |
     * |-------------|-------------|
     * | 200 | Success — returns the vehicle object matching the given ID. |
     * | 404 | Not found — no vehicle exists with the specified ID. |
     * | 500 | Unexpected server error. |
     *
     * @param id String
     * @return response of {@code CompletableFuture<VehicleServiceCollectionSdkResponse<Object>>}
     */
    public CompletableFuture<VehicleServiceCollectionSdkResponse<Object>> retrieveAVehicleAsync(
      @NonNull String id,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(retrieveAVehicleConfig, requestConfig);
      Request request = buildRetrieveAVehicleRequest(id, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new VehicleServiceCollectionSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * ## Update a Vehicle
     *
     * Partially updates an existing vehicle record using its unique identifier. Only the fields provided in the request body will be updated.
     *
     * **Method:** `PATCH`
     * **Endpoint:** `{{baseUrl}}/vehicles/:id`
     *
     * ### Path Parameters
     * | Parameter | Type | Required | Description |
     * |-----------|------|----------|-------------|
     * | id | string | Yes | The unique identifier of the vehicle to update. |
     *
     * ### Request Headers
     * | Header | Value | Description |
     * |--------|-------|-------------|
     * | Content-Type | application/json | Required. Specifies the request body format. |
     * | Accept | application/json | Expected response format. |
     *
     * ### Request Body
     * Send a JSON object with one or more of the following fields to update:
     *
     * | Field | Type | Required | Description |
     * |-------|------|----------|-------------|
     * | nickName | string | No | Updated friendly name for the vehicle. |
     * | vin | string | No | Updated Vehicle Identification Number. |
     * | make | string | No | Updated manufacturer name. |
     * | model | string | No | Updated model name. |
     * | year | string | No | Updated manufacturing year. |
     * | miles | number | No | Updated odometer reading in miles. |
     *
     * **Example Request Body:**
     * ```json
     * {
     * "nickName": "The Lisa Marie",
     * "vin": "4M2DV11W4RDJ53329",
     * "make": "Mercury",
     * "model": "Villager",
     * "year": "1994",
     * "miles": 159999
     * }
     * ```
     *
     * ### Responses
     * | Status Code | Description |
     * |-------------|-------------|
     * | 200 | Success — returns the updated vehicle object. |
     * | 400 | Bad request — the request body is malformed or contains invalid values. |
     * | 500 | Unexpected server error. |
     *
     * @param id String
     * @param createAVehicleRequest {@link CreateAVehicleRequest} Request Body
     * @return response of {@code VehicleServiceCollectionSdkResponse<Object>}
     */
    public VehicleServiceCollectionSdkResponse<Object> updateACollection(
      @NonNull String id,
      @NonNull CreateAVehicleRequest createAVehicleRequest
    ) throws ApiError {
      return this.updateACollection(id, createAVehicleRequest, null);
    }

    /**
     * ## Update a Vehicle
     *
     * Partially updates an existing vehicle record using its unique identifier. Only the fields provided in the request body will be updated.
     *
     * **Method:** `PATCH`
     * **Endpoint:** `{{baseUrl}}/vehicles/:id`
     *
     * ### Path Parameters
     * | Parameter | Type | Required | Description |
     * |-----------|------|----------|-------------|
     * | id | string | Yes | The unique identifier of the vehicle to update. |
     *
     * ### Request Headers
     * | Header | Value | Description |
     * |--------|-------|-------------|
     * | Content-Type | application/json | Required. Specifies the request body format. |
     * | Accept | application/json | Expected response format. |
     *
     * ### Request Body
     * Send a JSON object with one or more of the following fields to update:
     *
     * | Field | Type | Required | Description |
     * |-------|------|----------|-------------|
     * | nickName | string | No | Updated friendly name for the vehicle. |
     * | vin | string | No | Updated Vehicle Identification Number. |
     * | make | string | No | Updated manufacturer name. |
     * | model | string | No | Updated model name. |
     * | year | string | No | Updated manufacturing year. |
     * | miles | number | No | Updated odometer reading in miles. |
     *
     * **Example Request Body:**
     * ```json
     * {
     * "nickName": "The Lisa Marie",
     * "vin": "4M2DV11W4RDJ53329",
     * "make": "Mercury",
     * "model": "Villager",
     * "year": "1994",
     * "miles": 159999
     * }
     * ```
     *
     * ### Responses
     * | Status Code | Description |
     * |-------------|-------------|
     * | 200 | Success — returns the updated vehicle object. |
     * | 400 | Bad request — the request body is malformed or contains invalid values. |
     * | 500 | Unexpected server error. |
     *
     * @param id String
     * @param createAVehicleRequest {@link CreateAVehicleRequest} Request Body
     * @return response of {@code VehicleServiceCollectionSdkResponse<Object>}
     */
    public VehicleServiceCollectionSdkResponse<Object> updateACollection(
      @NonNull String id,
      @NonNull CreateAVehicleRequest createAVehicleRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(updateACollectionConfig, requestConfig);
      Request request = buildUpdateACollectionRequest(id, createAVehicleRequest, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new VehicleServiceCollectionSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * ## Update a Vehicle
     *
     * Partially updates an existing vehicle record using its unique identifier. Only the fields provided in the request body will be updated.
     *
     * **Method:** `PATCH`
     * **Endpoint:** `{{baseUrl}}/vehicles/:id`
     *
     * ### Path Parameters
     * | Parameter | Type | Required | Description |
     * |-----------|------|----------|-------------|
     * | id | string | Yes | The unique identifier of the vehicle to update. |
     *
     * ### Request Headers
     * | Header | Value | Description |
     * |--------|-------|-------------|
     * | Content-Type | application/json | Required. Specifies the request body format. |
     * | Accept | application/json | Expected response format. |
     *
     * ### Request Body
     * Send a JSON object with one or more of the following fields to update:
     *
     * | Field | Type | Required | Description |
     * |-------|------|----------|-------------|
     * | nickName | string | No | Updated friendly name for the vehicle. |
     * | vin | string | No | Updated Vehicle Identification Number. |
     * | make | string | No | Updated manufacturer name. |
     * | model | string | No | Updated model name. |
     * | year | string | No | Updated manufacturing year. |
     * | miles | number | No | Updated odometer reading in miles. |
     *
     * **Example Request Body:**
     * ```json
     * {
     * "nickName": "The Lisa Marie",
     * "vin": "4M2DV11W4RDJ53329",
     * "make": "Mercury",
     * "model": "Villager",
     * "year": "1994",
     * "miles": 159999
     * }
     * ```
     *
     * ### Responses
     * | Status Code | Description |
     * |-------------|-------------|
     * | 200 | Success — returns the updated vehicle object. |
     * | 400 | Bad request — the request body is malformed or contains invalid values. |
     * | 500 | Unexpected server error. |
     *
     * @param id String
     * @param createAVehicleRequest {@link CreateAVehicleRequest} Request Body
     * @return response of {@code CompletableFuture<VehicleServiceCollectionSdkResponse<Object>>}
     */
    public CompletableFuture<VehicleServiceCollectionSdkResponse<Object>> updateACollectionAsync(
      @NonNull String id,
      @NonNull CreateAVehicleRequest createAVehicleRequest
    ) throws ApiError {
      return this.updateACollectionAsync(id, createAVehicleRequest, null);
    }

    /**
     * ## Update a Vehicle
     *
     * Partially updates an existing vehicle record using its unique identifier. Only the fields provided in the request body will be updated.
     *
     * **Method:** `PATCH`
     * **Endpoint:** `{{baseUrl}}/vehicles/:id`
     *
     * ### Path Parameters
     * | Parameter | Type | Required | Description |
     * |-----------|------|----------|-------------|
     * | id | string | Yes | The unique identifier of the vehicle to update. |
     *
     * ### Request Headers
     * | Header | Value | Description |
     * |--------|-------|-------------|
     * | Content-Type | application/json | Required. Specifies the request body format. |
     * | Accept | application/json | Expected response format. |
     *
     * ### Request Body
     * Send a JSON object with one or more of the following fields to update:
     *
     * | Field | Type | Required | Description |
     * |-------|------|----------|-------------|
     * | nickName | string | No | Updated friendly name for the vehicle. |
     * | vin | string | No | Updated Vehicle Identification Number. |
     * | make | string | No | Updated manufacturer name. |
     * | model | string | No | Updated model name. |
     * | year | string | No | Updated manufacturing year. |
     * | miles | number | No | Updated odometer reading in miles. |
     *
     * **Example Request Body:**
     * ```json
     * {
     * "nickName": "The Lisa Marie",
     * "vin": "4M2DV11W4RDJ53329",
     * "make": "Mercury",
     * "model": "Villager",
     * "year": "1994",
     * "miles": 159999
     * }
     * ```
     *
     * ### Responses
     * | Status Code | Description |
     * |-------------|-------------|
     * | 200 | Success — returns the updated vehicle object. |
     * | 400 | Bad request — the request body is malformed or contains invalid values. |
     * | 500 | Unexpected server error. |
     *
     * @param id String
     * @param createAVehicleRequest {@link CreateAVehicleRequest} Request Body
     * @return response of {@code CompletableFuture<VehicleServiceCollectionSdkResponse<Object>>}
     */
    public CompletableFuture<VehicleServiceCollectionSdkResponse<Object>> updateACollectionAsync(
      @NonNull String id,
      @NonNull CreateAVehicleRequest createAVehicleRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(updateACollectionConfig, requestConfig);
      Request request = buildUpdateACollectionRequest(id, createAVehicleRequest, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new VehicleServiceCollectionSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * ## Delete a Vehicle
     *
     * Permanently removes a vehicle record from the system using its unique identifier.
     *
     * **Method:** `DELETE`
     * **Endpoint:** `{{baseUrl}}/vehicles/:id`
     *
     * ### Path Parameters
     * | Parameter | Type | Required | Description |
     * |-----------|------|----------|-------------|
     * | id | string | Yes | The unique identifier of the vehicle to delete. |
     *
     * ### Request Headers
     * | Header | Value | Description |
     * |--------|-------|-------------|
     * | Accept | application/json | Expected response format. |
     *
     * ### Request Body
     * None required.
     *
     * ### Responses
     * | Status Code | Description |
     * |-------------|-------------|
     * | 204 | Success — vehicle deleted. No content returned. |
     * | 500 | Unexpected server error. |
     *
     * @param id String
     * @return response of {@code VehicleServiceCollectionSdkResponse<String>}
     */
    public VehicleServiceCollectionSdkResponse<String> deleteAVehicle(@NonNull String id)
      throws ApiError {
      return this.deleteAVehicle(id, null);
    }

    /**
     * ## Delete a Vehicle
     *
     * Permanently removes a vehicle record from the system using its unique identifier.
     *
     * **Method:** `DELETE`
     * **Endpoint:** `{{baseUrl}}/vehicles/:id`
     *
     * ### Path Parameters
     * | Parameter | Type | Required | Description |
     * |-----------|------|----------|-------------|
     * | id | string | Yes | The unique identifier of the vehicle to delete. |
     *
     * ### Request Headers
     * | Header | Value | Description |
     * |--------|-------|-------------|
     * | Accept | application/json | Expected response format. |
     *
     * ### Request Body
     * None required.
     *
     * ### Responses
     * | Status Code | Description |
     * |-------------|-------------|
     * | 204 | Success — vehicle deleted. No content returned. |
     * | 500 | Unexpected server error. |
     *
     * @param id String
     * @return response of {@code VehicleServiceCollectionSdkResponse<String>}
     */
    public VehicleServiceCollectionSdkResponse<String> deleteAVehicle(
      @NonNull String id,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(deleteAVehicleConfig, requestConfig);
      Request request = buildDeleteAVehicleRequest(id, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new VehicleServiceCollectionSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.toBodyString(bodyBytes)
      );
    }

    /**
     * ## Delete a Vehicle
     *
     * Permanently removes a vehicle record from the system using its unique identifier.
     *
     * **Method:** `DELETE`
     * **Endpoint:** `{{baseUrl}}/vehicles/:id`
     *
     * ### Path Parameters
     * | Parameter | Type | Required | Description |
     * |-----------|------|----------|-------------|
     * | id | string | Yes | The unique identifier of the vehicle to delete. |
     *
     * ### Request Headers
     * | Header | Value | Description |
     * |--------|-------|-------------|
     * | Accept | application/json | Expected response format. |
     *
     * ### Request Body
     * None required.
     *
     * ### Responses
     * | Status Code | Description |
     * |-------------|-------------|
     * | 204 | Success — vehicle deleted. No content returned. |
     * | 500 | Unexpected server error. |
     *
     * @param id String
     * @return response of {@code CompletableFuture<VehicleServiceCollectionSdkResponse<String>>}
     */
    public CompletableFuture<VehicleServiceCollectionSdkResponse<String>> deleteAVehicleAsync(
      @NonNull String id
    ) throws ApiError {
      return this.deleteAVehicleAsync(id, null);
    }

    /**
     * ## Delete a Vehicle
     *
     * Permanently removes a vehicle record from the system using its unique identifier.
     *
     * **Method:** `DELETE`
     * **Endpoint:** `{{baseUrl}}/vehicles/:id`
     *
     * ### Path Parameters
     * | Parameter | Type | Required | Description |
     * |-----------|------|----------|-------------|
     * | id | string | Yes | The unique identifier of the vehicle to delete. |
     *
     * ### Request Headers
     * | Header | Value | Description |
     * |--------|-------|-------------|
     * | Accept | application/json | Expected response format. |
     *
     * ### Request Body
     * None required.
     *
     * ### Responses
     * | Status Code | Description |
     * |-------------|-------------|
     * | 204 | Success — vehicle deleted. No content returned. |
     * | 500 | Unexpected server error. |
     *
     * @param id String
     * @return response of {@code CompletableFuture<VehicleServiceCollectionSdkResponse<String>>}
     */
    public CompletableFuture<VehicleServiceCollectionSdkResponse<String>> deleteAVehicleAsync(
      @NonNull String id,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(deleteAVehicleConfig, requestConfig);
      Request request = buildDeleteAVehicleRequest(id, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new VehicleServiceCollectionSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.toBodyString(bodyBytes)
        );
      });
    }

    /**
     * ## Get All Vehicles
     *
     * Retrieves a list of all vehicle records stored in the system.
     *
     * **Method:** `GET`
     * **Endpoint:** `{{baseUrl}}/vehicles`
     *
     * ### Request Headers
     * | Header | Value | Description |
     * |--------|-------|-------------|
     * | Accept | application/json | Expected response format. |
     *
     * ### Request Body
     * None required.
     *
     * ### Responses
     * | Status Code | Description |
     * |-------------|-------------|
     * | 200 | Success — returns an array of vehicle objects. |
     * | 500 | Unexpected server error. |
     *
     * ### Example Response (200 - Success)
     * Returns a JSON array of vehicle objects, each containing fields such as `id`, `nickName`, `vin`, `make`, `model`, `year`, and `miles`.
     *
     * @return response of {@code VehicleServiceCollectionSdkResponse<Object>}
     */
    public VehicleServiceCollectionSdkResponse<Object> getAllVehicles() throws ApiError {
      return this.getAllVehicles(null);
    }

    /**
     * ## Get All Vehicles
     *
     * Retrieves a list of all vehicle records stored in the system.
     *
     * **Method:** `GET`
     * **Endpoint:** `{{baseUrl}}/vehicles`
     *
     * ### Request Headers
     * | Header | Value | Description |
     * |--------|-------|-------------|
     * | Accept | application/json | Expected response format. |
     *
     * ### Request Body
     * None required.
     *
     * ### Responses
     * | Status Code | Description |
     * |-------------|-------------|
     * | 200 | Success — returns an array of vehicle objects. |
     * | 500 | Unexpected server error. |
     *
     * ### Example Response (200 - Success)
     * Returns a JSON array of vehicle objects, each containing fields such as `id`, `nickName`, `vin`, `make`, `model`, `year`, and `miles`.
     *
     * @return response of {@code VehicleServiceCollectionSdkResponse<Object>}
     */
    public VehicleServiceCollectionSdkResponse<Object> getAllVehicles(RequestConfig requestConfig)
      throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(getAllVehiclesConfig, requestConfig);
      Request request = buildGetAllVehiclesRequest(resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new VehicleServiceCollectionSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * ## Get All Vehicles
     *
     * Retrieves a list of all vehicle records stored in the system.
     *
     * **Method:** `GET`
     * **Endpoint:** `{{baseUrl}}/vehicles`
     *
     * ### Request Headers
     * | Header | Value | Description |
     * |--------|-------|-------------|
     * | Accept | application/json | Expected response format. |
     *
     * ### Request Body
     * None required.
     *
     * ### Responses
     * | Status Code | Description |
     * |-------------|-------------|
     * | 200 | Success — returns an array of vehicle objects. |
     * | 500 | Unexpected server error. |
     *
     * ### Example Response (200 - Success)
     * Returns a JSON array of vehicle objects, each containing fields such as `id`, `nickName`, `vin`, `make`, `model`, `year`, and `miles`.
     *
     * @return response of {@code CompletableFuture<VehicleServiceCollectionSdkResponse<Object>>}
     */
    public CompletableFuture<VehicleServiceCollectionSdkResponse<Object>> getAllVehiclesAsync()
      throws ApiError {
      return this.getAllVehiclesAsync(null);
    }

    /**
     * ## Get All Vehicles
     *
     * Retrieves a list of all vehicle records stored in the system.
     *
     * **Method:** `GET`
     * **Endpoint:** `{{baseUrl}}/vehicles`
     *
     * ### Request Headers
     * | Header | Value | Description |
     * |--------|-------|-------------|
     * | Accept | application/json | Expected response format. |
     *
     * ### Request Body
     * None required.
     *
     * ### Responses
     * | Status Code | Description |
     * |-------------|-------------|
     * | 200 | Success — returns an array of vehicle objects. |
     * | 500 | Unexpected server error. |
     *
     * ### Example Response (200 - Success)
     * Returns a JSON array of vehicle objects, each containing fields such as `id`, `nickName`, `vin`, `make`, `model`, `year`, and `miles`.
     *
     * @return response of {@code CompletableFuture<VehicleServiceCollectionSdkResponse<Object>>}
     */
    public CompletableFuture<VehicleServiceCollectionSdkResponse<Object>> getAllVehiclesAsync(
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(getAllVehiclesConfig, requestConfig);
      Request request = buildGetAllVehiclesRequest(resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new VehicleServiceCollectionSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }
  }
}
