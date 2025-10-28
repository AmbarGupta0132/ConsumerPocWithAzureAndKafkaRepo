package com.partners.events.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * ClientId
 */
@Embeddable
public class ClientId {

	private Long clientId;

	private String version;

	public ClientId() {
		super();
	}

	/**
	 * Constructor with only required parameters
	 */
	public ClientId(Long clientId, String version) {
		this.clientId = clientId;
		this.version = version;
	}

	public ClientId clientId(Long clientId) {
		this.clientId = clientId;
		return this;
	}

	/**
	 * Get clientId
	 * @return clientId
	 */
	@NotNull
	@Schema(name = "clientId", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("clientId")
	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public ClientId version(String version) {
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
		ClientId clientId = (ClientId) o;
		return Objects.equals(this.clientId, clientId.clientId) &&
				Objects.equals(this.version, clientId.version);
	}

	@Override
	public int hashCode() {
		return Objects.hash(clientId, version);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ClientId {\n");
		sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
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

