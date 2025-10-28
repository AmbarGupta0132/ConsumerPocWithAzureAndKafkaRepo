package com.partners.events.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * PolicyId
 */

@Embeddable
public class PolicyId {

  private Long policyNumber;

  private String version;

  public PolicyId() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PolicyId(Long policyNumber, String version) {
    this.policyNumber = policyNumber;
    this.version = version;
  }

  public PolicyId policyNumber(Long policyNumber) {
    this.policyNumber = policyNumber;
    return this;
  }

  /**
   * Get policyNumber
   * @return policyNumber
   */
  @NotNull 
  @Schema(name = "policyNumber", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("policyNumber")
  public Long getPolicyNumber() {
    return policyNumber;
  }

  public void setPolicyNumber(Long policyNumber) {
    this.policyNumber = policyNumber;
  }

  public PolicyId version(String version) {
    this.version = version;
    return this;
  }

  /**
   * Get version
   * @return version
   */
  @NotNull 
  @Schema(name = "version", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("version")
  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PolicyId policyId = (PolicyId) o;
    return Objects.equals(this.policyNumber, policyId.policyNumber) &&
        Objects.equals(this.version, policyId.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(policyNumber, version);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolicyId {\n");
    sb.append("    policyNumber: ").append(toIndentedString(policyNumber)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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

