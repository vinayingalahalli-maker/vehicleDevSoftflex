from typing import Any, Optional, Union
from .utils.validator import Validator
from .utils.base_service import BaseService
from ..net.transport.serializer import Serializer
from ..net.sdk_config import SdkConfig
from ..net.environment.environment import Environment
from ..models.utils.sentinel import SENTINEL
from ..models.utils.cast_models import cast_models
from ..models import CreateAVehicleRequest


class VehicleServiceCollectionSdkService(BaseService):
    """
    Service class for VehicleServiceCollectionSdkService operations.
    Provides methods to interact with VehicleServiceCollectionSdkService-related API endpoints.
    Inherits common functionality from BaseService including authentication and request handling.
    """

    def __init__(self, *args, **kwargs):
        """Initialize the service and method-level configurations."""
        super().__init__(*args, **kwargs)
        self._create_a_vehicle_config: SdkConfig = {}
        self._retrieve_a_vehicle_config: SdkConfig = {}
        self._update_a_collection_config: SdkConfig = {}
        self._delete_a_vehicle_config: SdkConfig = {}
        self._get_all_vehicles_config: SdkConfig = {}

    def set_create_a_vehicle_config(self, config: SdkConfig):
        """
        Sets method-level configuration for create_a_vehicle.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._create_a_vehicle_config = config
        return self

    def set_retrieve_a_vehicle_config(self, config: SdkConfig):
        """
        Sets method-level configuration for retrieve_a_vehicle.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._retrieve_a_vehicle_config = config
        return self

    def set_update_a_collection_config(self, config: SdkConfig):
        """
        Sets method-level configuration for update_a_collection.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._update_a_collection_config = config
        return self

    def set_delete_a_vehicle_config(self, config: SdkConfig):
        """
        Sets method-level configuration for delete_a_vehicle.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._delete_a_vehicle_config = config
        return self

    def set_get_all_vehicles_config(self, config: SdkConfig):
        """
        Sets method-level configuration for get_all_vehicles.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._get_all_vehicles_config = config
        return self

    @cast_models
    def create_a_vehicle(
        self,
        request_body: CreateAVehicleRequest,
        x_mock_response_code: str = SENTINEL,
        *,
        request_config: Optional[SdkConfig] = None,
    ) -> Any:
        """## Create a Vehicle Creates a new vehicle record in the system. **Method:** `POST` **Endpoint:** `{{baseUrl}}/vehicles` ### Request Headers | Header | Value | Description | |--------|-------|-------------| | Content-Type | application/json | Required. Specifies the request body format. | | Accept | application/json | Expected response format. | ### Request Body Send a JSON object with the following fields: | Field | Type | Required | Description | |-------|------|----------|-------------| | nickName | string | Yes | A friendly name for the vehicle. | | vin | string | Yes | Vehicle Identification Number (17 characters). | | make | string | Yes | Manufacturer of the vehicle (e.g., Mercury). | | model | string | Yes | Model name of the vehicle (e.g., Villager). | | year | string | Yes | Manufacturing year of the vehicle (e.g., "1994"). | | miles | number | Yes | Current odometer reading in miles. | **Example Request Body:** ```json { "nickName": "The Lisa Marie", "vin": "4M2DV11W4RDJ53329", "make": "Mercury", "model": "Villager", "year": "1994", "miles": 159864 } ``` ### Responses | Status Code | Description | |-------------|-------------| | 201 | Vehicle successfully created. Returns the created vehicle object. | | 400 | Bad request — one or more required attributes are missing or invalid. | | 409 | Conflict — a vehicle with the same VIN already exists. | | 500 | Unexpected server error. |

        :param request_body: The request body.
        :type request_body: CreateAVehicleRequest
        :param x_mock_response_code: x_mock_response_code, defaults to None
        :type x_mock_response_code: str, optional
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        Validator(CreateAVehicleRequest).is_nullable().validate(
            request_body, "request_body"
        )
        Validator(str).is_optional().validate(
            x_mock_response_code, "x_mock_response_code"
        )

        resolved_config = self._get_resolved_config(
            self._create_a_vehicle_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.DEFAULT.url}/vehicles",
                [self.get_api_key(resolved_config)],
                resolved_config,
            )
            .add_header("x-mock-response-code", x_mock_response_code)
            .serialize()
            .set_method("POST")
            .set_body(request_body)
        )

        response, status, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def retrieve_a_vehicle(
        self, id_: str, *, request_config: Optional[SdkConfig] = None
    ) -> Any:
        """## Retrieve a Vehicle Fetches the details of a single vehicle by its unique identifier. **Method:** `GET` **Endpoint:** `{{baseUrl}}/vehicles/:id` ### Path Parameters | Parameter | Type | Required | Description | |-----------|------|----------|-------------| | id | string | Yes | The unique identifier of the vehicle to retrieve. | ### Request Headers | Header | Value | Description | |--------|-------|-------------| | Accept | application/json | Expected response format. | ### Request Body None required. ### Responses | Status Code | Description | |-------------|-------------| | 200 | Success — returns the vehicle object matching the given ID. | | 404 | Not found — no vehicle exists with the specified ID. | | 500 | Unexpected server error. |

        :param id_: id_
        :type id_: str
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        Validator(str).validate(id_, "id_")

        resolved_config = self._get_resolved_config(
            self._retrieve_a_vehicle_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.DEFAULT.url}/vehicles/{{id}}",
                [self.get_api_key(resolved_config)],
                resolved_config,
            )
            .add_path("id", id_)
            .serialize()
            .set_method("GET")
        )

        response, status, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def update_a_collection(
        self,
        request_body: CreateAVehicleRequest,
        id_: str,
        *,
        request_config: Optional[SdkConfig] = None,
    ) -> Any:
        """## Update a Vehicle Partially updates an existing vehicle record using its unique identifier. Only the fields provided in the request body will be updated. **Method:** `PATCH` **Endpoint:** `{{baseUrl}}/vehicles/:id` ### Path Parameters | Parameter | Type | Required | Description | |-----------|------|----------|-------------| | id | string | Yes | The unique identifier of the vehicle to update. | ### Request Headers | Header | Value | Description | |--------|-------|-------------| | Content-Type | application/json | Required. Specifies the request body format. | | Accept | application/json | Expected response format. | ### Request Body Send a JSON object with one or more of the following fields to update: | Field | Type | Required | Description | |-------|------|----------|-------------| | nickName | string | No | Updated friendly name for the vehicle. | | vin | string | No | Updated Vehicle Identification Number. | | make | string | No | Updated manufacturer name. | | model | string | No | Updated model name. | | year | string | No | Updated manufacturing year. | | miles | number | No | Updated odometer reading in miles. | **Example Request Body:** ```json { "nickName": "The Lisa Marie", "vin": "4M2DV11W4RDJ53329", "make": "Mercury", "model": "Villager", "year": "1994", "miles": 159999 } ``` ### Responses | Status Code | Description | |-------------|-------------| | 200 | Success — returns the updated vehicle object. | | 400 | Bad request — the request body is malformed or contains invalid values. | | 500 | Unexpected server error. |

        :param request_body: The request body.
        :type request_body: CreateAVehicleRequest
        :param id_: id_
        :type id_: str
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        Validator(CreateAVehicleRequest).is_nullable().validate(
            request_body, "request_body"
        )
        Validator(str).validate(id_, "id_")

        resolved_config = self._get_resolved_config(
            self._update_a_collection_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.DEFAULT.url}/vehicles/{{id}}",
                [self.get_api_key(resolved_config)],
                resolved_config,
            )
            .add_path("id", id_)
            .serialize()
            .set_method("PATCH")
            .set_body(request_body)
        )

        response, status, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def delete_a_vehicle(
        self, id_: str, *, request_config: Optional[SdkConfig] = None
    ) -> str:
        """## Delete a Vehicle Permanently removes a vehicle record from the system using its unique identifier. **Method:** `DELETE` **Endpoint:** `{{baseUrl}}/vehicles/:id` ### Path Parameters | Parameter | Type | Required | Description | |-----------|------|----------|-------------| | id | string | Yes | The unique identifier of the vehicle to delete. | ### Request Headers | Header | Value | Description | |--------|-------|-------------| | Accept | application/json | Expected response format. | ### Request Body None required. ### Responses | Status Code | Description | |-------------|-------------| | 204 | Success — vehicle deleted. No content returned. | | 500 | Unexpected server error. |

        :param id_: id_
        :type id_: str
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: str
        """

        Validator(str).validate(id_, "id_")

        resolved_config = self._get_resolved_config(
            self._delete_a_vehicle_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.DEFAULT.url}/vehicles/{{id}}",
                [self.get_api_key(resolved_config)],
                resolved_config,
            )
            .add_path("id", id_)
            .serialize()
            .set_method("DELETE")
        )

        response, status, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def get_all_vehicles(self, *, request_config: Optional[SdkConfig] = None) -> Any:
        """## Get All Vehicles Retrieves a list of all vehicle records stored in the system. **Method:** `GET` **Endpoint:** `{{baseUrl}}/vehicles` ### Request Headers | Header | Value | Description | |--------|-------|-------------| | Accept | application/json | Expected response format. | ### Request Body None required. ### Responses | Status Code | Description | |-------------|-------------| | 200 | Success — returns an array of vehicle objects. | | 500 | Unexpected server error. | ### Example Response (200 - Success) Returns a JSON array of vehicle objects, each containing fields such as `id`, `nickName`, `vin`, `make`, `model`, `year`, and `miles`.

        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        resolved_config = self._get_resolved_config(
            self._get_all_vehicles_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.DEFAULT.url}/vehicles",
                [self.get_api_key(resolved_config)],
                resolved_config,
            )
            .serialize()
            .set_method("GET")
        )

        response, status, _ = self.send_request(serialized_request)
        return response
