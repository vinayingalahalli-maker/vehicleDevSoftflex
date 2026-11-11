package com.vehicleservicecollectionsdk.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class CreateAVehicleParameters {

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private CreateAVehicleRequest requestBody;

  @JsonProperty("x-mock-response-code")
  private JsonNullable<String> xMockResponseCode;

  // FSM-59: capture unknown JSON fields so they round-trip on re-serialize.
  // @Builder.Default keeps the empty-map default in the Lombok-generated builder; without it the
  // builder would leave the map null and the any-setter would NPE on the first unknown field.
  // Deserialization is wired via the builder's @JsonAnySetter (see the Builder below), NOT here:
  // Lombok @Jacksonized deserializes through the builder and does not copy a field-level
  // @JsonAnySetter across, so unknown fields would be silently dropped if it lived on this field.
  @Builder.Default
  private Map<String, Object> additionalProperties = new HashMap<>();

  // @JsonAnyGetter must sit on the getter (not the field) so Jackson inlines the unknown entries on
  // serialize. On the field it double-registers with the Lombok getter and leaks a literal
  // "additionalProperties" property into every request body and object parameter.
  // Declaring the getter here also stops Lombok @Data from generating its own.
  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  @JsonIgnore
  public String getXMockResponseCode() {
    return xMockResponseCode.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class CreateAVehicleParametersBuilder {

    /**
     * Flag to track if the requestBody property has been set.
     */
    private boolean requestBody$set = false;

    public CreateAVehicleParametersBuilder requestBody(CreateAVehicleRequest requestBody) {
      this.requestBody$set = true;
      this.requestBody = requestBody;
      return this;
    }

    private JsonNullable<String> xMockResponseCode = JsonNullable.undefined();

    @JsonProperty("x-mock-response-code")
    public CreateAVehicleParametersBuilder xMockResponseCode(String value) {
      if (value == null) {
        throw new IllegalStateException("xMockResponseCode cannot be null");
      }
      this.xMockResponseCode = JsonNullable.of(value);
      return this;
    }

    @JsonAnySetter
    public CreateAVehicleParametersBuilder additionalProperties(String key, Object value) {
      if (this.additionalProperties$value == null) {
        this.additionalProperties$value = new HashMap<>();
      }
      this.additionalProperties$value.put(key, value);
      this.additionalProperties$set = true;
      return this;
    }

    public CreateAVehicleParameters build() {
      if (!requestBody$set) {
        throw new IllegalStateException("requestBody is required");
      }
      Map<String, Object> additionalProperties$value = this.additionalProperties$value;
      if (!additionalProperties$set) {
        additionalProperties$value = new HashMap<>();
      }
      return new CreateAVehicleParameters(
        requestBody,
        xMockResponseCode,
        additionalProperties$value
      );
    }
  }
}
