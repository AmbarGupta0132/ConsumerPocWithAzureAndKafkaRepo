package com.partners.events.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * PolicyRequest
 */

public class PolicyRequest {

  private @Nullable PolicyId policyid;

  @Valid
  private Map<String, Object> map = new HashMap<>();

  public PolicyRequest policyid(@Nullable PolicyId policyid) {
    this.policyid = policyid;
    return this;
  }

  /**
   * Get policyid
   * @return policyid
   */
  @Valid 
  @Schema(name = "policyid", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("policyid")
  public @Nullable PolicyId getPolicyid() {
    return policyid;
  }

  public void setPolicyid(@Nullable PolicyId policyid) {
    this.policyid = policyid;
  }

  public PolicyRequest map(Map<String, Object> map) {
    this.map = map;
    return this;
  }

  public PolicyRequest putMapItem(String key, Object mapItem) {
    if (this.map == null) {
      this.map = new HashMap<>();
    }
    this.map.put(key, mapItem);
    return this;
  }

  /**
   * Get map
   * @return map
   */
  
  @Schema(name = "map", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("map")
  public Map<String, Object> getMap() {
    return map;
  }

  public void setMap(Map<String, Object> map) {
    this.map = map;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PolicyRequest policyRequest = (PolicyRequest) o;
    return Objects.equals(this.policyid, policyRequest.policyid) &&
        Objects.equals(this.map, policyRequest.map);
  }

  @Override
  public int hashCode() {
    return Objects.hash(policyid, map);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolicyRequest {\n");
    sb.append("    policyid: ").append(toIndentedString(policyid)).append("\n");
    sb.append("    map: ").append(toIndentedString(map)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

