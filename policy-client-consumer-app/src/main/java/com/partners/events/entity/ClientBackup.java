package com.partners.events.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.partners.events.model.ClientId;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

/**
 * ClientBackup
 */
@Entity
@Table(name = "client_backup")
public class ClientBackup {

	@EmbeddedId
	private ClientId id;

	private @Nullable String status;

	private @Nullable String title;

	private @Nullable String forename;

	private @Nullable String surname;

	private @Nullable String gender;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private @Nullable LocalDate dateOfBirth;

	private @Nullable String occupation;

	private @Nullable String preferredRiskCode;

	private @Nullable String addressTypeCode;

	private @Nullable String line1;

	private @Nullable String line2;

	private @Nullable String line3;

	private @Nullable String line4;

	private @Nullable String suburb;

	private @Nullable String city;

	private @Nullable String country;

	private @Nullable String postCode;

	@Column(name = "isprimary")
	private @Nullable Boolean primary;

	private @Nullable String email;

	private @Nullable String mobilePhone;

	private @Nullable String homePhone;

	private @Nullable String businessPhone;

	private @Nullable String comments;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private @Nullable OffsetDateTime createdDate;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private @Nullable OffsetDateTime modifiedDate;

	public ClientBackup() {
		super();
	}

	/**
	 * Constructor with only required parameters
	 */
	public ClientBackup(ClientId id) {
		this.id = id;
	}

	public ClientBackup id(ClientId id) {
		this.id = id;
		return this;
	}


	private List<String> changedFields;

	public List<String> getChangedFields() {
		return changedFields;
	}

	public void setChangedFields(List<String> changedFields) {
		this.changedFields = changedFields;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 */
	@NotNull
	@Valid
	@Schema(name = "id", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("id")
	public ClientId getId() {
		return id;
	}

	public void setId(ClientId id) {
		this.id = id;
	}

	public ClientBackup status(@Nullable String status) {
		this.status = status;
		return this;
	}

	/**
	 * Get status
	 * 
	 * @return status
	 */

	@Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("status")
	public @Nullable String getStatus() {
		return status;
	}

	public void setStatus(@Nullable String status) {
		this.status = status;
	}

	public ClientBackup title(@Nullable String title) {
		this.title = title;
		return this;
	}

	/**
	 * Get title
	 * 
	 * @return title
	 */

	@Schema(name = "title", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("title")
	public @Nullable String getTitle() {
		return title;
	}

	public void setTitle(@Nullable String title) {
		this.title = title;
	}

	public ClientBackup forename(@Nullable String forename) {
		this.forename = forename;
		return this;
	}

	/**
	 * Get forename
	 * 
	 * @return forename
	 */

	@Schema(name = "forename", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("forename")
	public @Nullable String getForename() {
		return forename;
	}

	public void setForename(@Nullable String forename) {
		this.forename = forename;
	}

	public ClientBackup surname(@Nullable String surname) {
		this.surname = surname;
		return this;
	}

	/**
	 * Get surname
	 * 
	 * @return surname
	 */

	@Schema(name = "surname", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("surname")
	public @Nullable String getSurname() {
		return surname;
	}

	public void setSurname(@Nullable String surname) {
		this.surname = surname;
	}

	public ClientBackup gender(@Nullable String gender) {
		this.gender = gender;
		return this;
	}

	/**
	 * Get gender
	 * 
	 * @return gender
	 */

	@Schema(name = "gender", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("gender")
	public @Nullable String getGender() {
		return gender;
	}

	public void setGender(@Nullable String gender) {
		this.gender = gender;
	}

	public ClientBackup dateOfBirth(@Nullable LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
		return this;
	}

	/**
	 * Get dateOfBirth
	 * 
	 * @return dateOfBirth
	 */
	@Valid
	@Schema(name = "dateOfBirth", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("dateOfBirth")
	public @Nullable LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(@Nullable LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public ClientBackup occupation(@Nullable String occupation) {
		this.occupation = occupation;
		return this;
	}

	/**
	 * Get occupation
	 * 
	 * @return occupation
	 */

	@Schema(name = "occupation", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("occupation")
	public @Nullable String getOccupation() {
		return occupation;
	}

	public void setOccupation(@Nullable String occupation) {
		this.occupation = occupation;
	}

	public ClientBackup preferredRiskCode(@Nullable String preferredRiskCode) {
		this.preferredRiskCode = preferredRiskCode;
		return this;
	}

	/**
	 * Get preferredRiskCode
	 * 
	 * @return preferredRiskCode
	 */

	@Schema(name = "preferredRiskCode", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("preferredRiskCode")
	public @Nullable String getPreferredRiskCode() {
		return preferredRiskCode;
	}

	public void setPreferredRiskCode(@Nullable String preferredRiskCode) {
		this.preferredRiskCode = preferredRiskCode;
	}

	public ClientBackup addressTypeCode(@Nullable String addressTypeCode) {
		this.addressTypeCode = addressTypeCode;
		return this;
	}

	/**
	 * Get addressTypeCode
	 * 
	 * @return addressTypeCode
	 */

	@Schema(name = "addressTypeCode", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("addressTypeCode")
	public @Nullable String getAddressTypeCode() {
		return addressTypeCode;
	}

	public void setAddressTypeCode(@Nullable String addressTypeCode) {
		this.addressTypeCode = addressTypeCode;
	}

	public ClientBackup line1(@Nullable String line1) {
		this.line1 = line1;
		return this;
	}

	/**
	 * Get line1
	 * 
	 * @return line1
	 */

	@Schema(name = "line1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("line1")
	public @Nullable String getLine1() {
		return line1;
	}

	public void setLine1(@Nullable String line1) {
		this.line1 = line1;
	}

	public ClientBackup line2(@Nullable String line2) {
		this.line2 = line2;
		return this;
	}

	/**
	 * Get line2
	 * 
	 * @return line2
	 */

	@Schema(name = "line2", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("line2")
	public @Nullable String getLine2() {
		return line2;
	}

	public void setLine2(@Nullable String line2) {
		this.line2 = line2;
	}

	public ClientBackup line3(@Nullable String line3) {
		this.line3 = line3;
		return this;
	}

	/**
	 * Get line3
	 * 
	 * @return line3
	 */

	@Schema(name = "line3", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("line3")
	public @Nullable String getLine3() {
		return line3;
	}

	public void setLine3(@Nullable String line3) {
		this.line3 = line3;
	}

	public ClientBackup line4(@Nullable String line4) {
		this.line4 = line4;
		return this;
	}

	/**
	 * Get line4
	 * 
	 * @return line4
	 */

	@Schema(name = "line4", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("line4")
	public @Nullable String getLine4() {
		return line4;
	}

	public void setLine4(@Nullable String line4) {
		this.line4 = line4;
	}

	public ClientBackup suburb(@Nullable String suburb) {
		this.suburb = suburb;
		return this;
	}

	/**
	 * Get suburb
	 * 
	 * @return suburb
	 */

	@Schema(name = "suburb", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("suburb")
	public @Nullable String getSuburb() {
		return suburb;
	}

	public void setSuburb(@Nullable String suburb) {
		this.suburb = suburb;
	}

	public ClientBackup city(@Nullable String city) {
		this.city = city;
		return this;
	}

	/**
	 * Get city
	 * 
	 * @return city
	 */

	@Schema(name = "city", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("city")
	public @Nullable String getCity() {
		return city;
	}

	public void setCity(@Nullable String city) {
		this.city = city;
	}

	public ClientBackup country(@Nullable String country) {
		this.country = country;
		return this;
	}

	/**
	 * Get country
	 * 
	 * @return country
	 */

	@Schema(name = "country", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("country")
	public @Nullable String getCountry() {
		return country;
	}

	public void setCountry(@Nullable String country) {
		this.country = country;
	}

	public ClientBackup postCode(@Nullable String postCode) {
		this.postCode = postCode;
		return this;
	}

	/**
	 * Get postCode
	 * 
	 * @return postCode
	 */

	@Schema(name = "postCode", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("postCode")
	public @Nullable String getPostCode() {
		return postCode;
	}

	public void setPostCode(@Nullable String postCode) {
		this.postCode = postCode;
	}

	public ClientBackup primary(@Nullable Boolean primary) {
		this.primary = primary;
		return this;
	}

	/**
	 * Get primary
	 * 
	 * @return primary
	 */

	@Schema(name = "primary", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("primary")
	public @Nullable Boolean getPrimary() {
		return primary;
	}

	public void setPrimary(@Nullable Boolean primary) {
		this.primary = primary;
	}

	public ClientBackup email(@Nullable String email) {
		this.email = email;
		return this;
	}

	/**
	 * Get email
	 * 
	 * @return email
	 */
	@jakarta.validation.constraints.Email
	@Schema(name = "email", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("email")
	public @Nullable String getEmail() {
		return email;
	}

	public void setEmail(@Nullable String email) {
		this.email = email;
	}

	public ClientBackup mobilePhone(@Nullable String mobilePhone) {
		this.mobilePhone = mobilePhone;
		return this;
	}

	/**
	 * Get mobilePhone
	 * 
	 * @return mobilePhone
	 */

	@Schema(name = "mobilePhone", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("mobilePhone")
	public @Nullable String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(@Nullable String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public ClientBackup homePhone(@Nullable String homePhone) {
		this.homePhone = homePhone;
		return this;
	}

	/**
	 * Get homePhone
	 * 
	 * @return homePhone
	 */

	@Schema(name = "homePhone", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("homePhone")
	public @Nullable String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(@Nullable String homePhone) {
		this.homePhone = homePhone;
	}

	public ClientBackup businessPhone(@Nullable String businessPhone) {
		this.businessPhone = businessPhone;
		return this;
	}

	/**
	 * Get businessPhone
	 * 
	 * @return businessPhone
	 */

	@Schema(name = "businessPhone", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("businessPhone")
	public @Nullable String getBusinessPhone() {
		return businessPhone;
	}

	public void setBusinessPhone(@Nullable String businessPhone) {
		this.businessPhone = businessPhone;
	}

	public ClientBackup comments(@Nullable String comments) {
		this.comments = comments;
		return this;
	}

	/**
	 * Get comments
	 * 
	 * @return comments
	 */

	@Schema(name = "comments", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("comments")
	public @Nullable String getComments() {
		return comments;
	}

	public void setComments(@Nullable String comments) {
		this.comments = comments;
	}

	public ClientBackup createdDate(@Nullable OffsetDateTime createdDate) {
		this.createdDate = createdDate;
		return this;
	}

	/**
	 * Get createdDate
	 * 
	 * @return createdDate
	 */
	@Valid
	@Schema(name = "createdDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("createdDate")
	public @Nullable OffsetDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(@Nullable OffsetDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public ClientBackup modifiedDate(@Nullable OffsetDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
		return this;
	}

	/**
	 * Get modifiedDate
	 * 
	 * @return modifiedDate
	 */
	@Valid
	@Schema(name = "modifiedDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("modifiedDate")
	public @Nullable OffsetDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(@Nullable OffsetDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * Get version
	 * 
	 * @return version
	 */

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ClientBackup client = (ClientBackup) o;
		return Objects.equals(this.id, client.id) && Objects.equals(this.status, client.status)
				&& Objects.equals(this.title, client.title) && Objects.equals(this.forename, client.forename)
				&& Objects.equals(this.surname, client.surname) && Objects.equals(this.gender, client.gender)
				&& Objects.equals(this.dateOfBirth, client.dateOfBirth)
				&& Objects.equals(this.occupation, client.occupation)
				&& Objects.equals(this.preferredRiskCode, client.preferredRiskCode)
				&& Objects.equals(this.addressTypeCode, client.addressTypeCode)
				&& Objects.equals(this.line1, client.line1) && Objects.equals(this.line2, client.line2)
				&& Objects.equals(this.line3, client.line3) && Objects.equals(this.line4, client.line4)
				&& Objects.equals(this.suburb, client.suburb) && Objects.equals(this.city, client.city)
				&& Objects.equals(this.country, client.country) && Objects.equals(this.postCode, client.postCode)
				&& Objects.equals(this.primary, client.primary) && Objects.equals(this.email, client.email)
				&& Objects.equals(this.mobilePhone, client.mobilePhone)
				&& Objects.equals(this.homePhone, client.homePhone)
				&& Objects.equals(this.businessPhone, client.businessPhone)
				&& Objects.equals(this.comments, client.comments)
				&& Objects.equals(this.createdDate, client.createdDate)
				&& Objects.equals(this.modifiedDate, client.modifiedDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, status, title, forename, surname, gender, dateOfBirth, occupation, preferredRiskCode,
				addressTypeCode, line1, line2, line3, line4, suburb, city, country, postCode, primary, email,
				mobilePhone, homePhone, businessPhone, comments, createdDate, modifiedDate,changedFields);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Client {\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("    title: ").append(toIndentedString(title)).append("\n");
		sb.append("    forename: ").append(toIndentedString(forename)).append("\n");
		sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
		sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
		sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
		sb.append("    occupation: ").append(toIndentedString(occupation)).append("\n");
		sb.append("    preferredRiskCode: ").append(toIndentedString(preferredRiskCode)).append("\n");
		sb.append("    addressTypeCode: ").append(toIndentedString(addressTypeCode)).append("\n");
		sb.append("    line1: ").append(toIndentedString(line1)).append("\n");
		sb.append("    line2: ").append(toIndentedString(line2)).append("\n");
		sb.append("    line3: ").append(toIndentedString(line3)).append("\n");
		sb.append("    line4: ").append(toIndentedString(line4)).append("\n");
		sb.append("    suburb: ").append(toIndentedString(suburb)).append("\n");
		sb.append("    city: ").append(toIndentedString(city)).append("\n");
		sb.append("    country: ").append(toIndentedString(country)).append("\n");
		sb.append("    postCode: ").append(toIndentedString(postCode)).append("\n");
		sb.append("    primary: ").append(toIndentedString(primary)).append("\n");
		sb.append("    email: ").append(toIndentedString(email)).append("\n");
		sb.append("    mobilePhone: ").append(toIndentedString(mobilePhone)).append("\n");
		sb.append("    homePhone: ").append(toIndentedString(homePhone)).append("\n");
		sb.append("    businessPhone: ").append(toIndentedString(businessPhone)).append("\n");
		sb.append("    comments: ").append(toIndentedString(comments)).append("\n");
		sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
		sb.append("    modifiedDate: ").append(toIndentedString(modifiedDate)).append("\n");
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
