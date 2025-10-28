package com.partners.events.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * ClientRequest
 */

public class ClientRequest {

	private @Nullable ClientId clientId;

	@Valid
	private Map<String, Object> map = new HashMap<>();

	public ClientRequest clientId(@Nullable ClientId clientId) {
		this.clientId = clientId;
		return this;
	}

	/**
	 * Get clientId
	 * 
	 * @return clientId
	 */
	@Valid
	@Schema(name = "clientId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("clientId")
	public @Nullable ClientId getClientId() {
		return clientId;
	}

	public void setClientId(@Nullable ClientId clientId) {
		this.clientId = clientId;
	}

	public ClientRequest map(Map<String, Object> map) {
		this.map = map;
		return this;
	}

	public ClientRequest putMapItem(String key, Object mapItem) {
		if (this.map == null) {
			this.map = new HashMap<>();
		}
		this.map.put(key, mapItem);
		return this;
	}

	/**
	 * Get map
	 * 
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
		ClientRequest clientRequest = (ClientRequest) o;
		return Objects.equals(this.clientId, clientRequest.clientId) && Objects.equals(this.map, clientRequest.map);
	}

	@Override
	public int hashCode() {
		return Objects.hash(clientId, map);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ClientRequest {\n");
		sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
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
