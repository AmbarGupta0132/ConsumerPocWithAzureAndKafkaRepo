package com.partners.events.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.partners.events.model.PolicyId;
import io.swagger.v3.oas.annotations.media.Schema;
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
 * Policy
 */
@Entity
@Table(name = "consumer_policy")
public class Policy {

	@EmbeddedId
	private PolicyId id;

	private @Nullable String status;

	private @Nullable String productName;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private @Nullable LocalDate riskCommence;

	private @Nullable String relationshipType;

	private @Nullable String adviserNumber;

	private @Nullable String paymentFrequency;

	private @Nullable Double annualPremium;

	private @Nullable Double instalmentPrem;

	private @Nullable Double expenseAnnualPremium;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private @Nullable OffsetDateTime nextAnniversaryDate;

	private @Nullable Double outstandingBalance;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private @Nullable OffsetDateTime nextPaymentDueDate;

	private @Nullable String comments;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private @Nullable OffsetDateTime createdDate;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private @Nullable OffsetDateTime modifiedDate;

	public Policy() {
		super();
	}

	/**
	 * Constructor with only required parameters
	 */
	public Policy(PolicyId id) {
		this.id = id;
	}

	public Policy id(PolicyId id) {
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
	public PolicyId getId() {
		return id;
	}

	public void setId(PolicyId id) {
		this.id = id;
	}

	public Policy status(@Nullable String status) {
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

	public Policy productName(@Nullable String productName) {
		this.productName = productName;
		return this;
	}

	/**
	 * Get productName
	 * 
	 * @return productName
	 */

	@Schema(name = "productName", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("productName")
	public @Nullable String getProductName() {
		return productName;
	}

	public void setProductName(@Nullable String productName) {
		this.productName = productName;
	}

	public Policy riskCommence(@Nullable LocalDate riskCommence) {
		this.riskCommence = riskCommence;
		return this;
	}

	/**
	 * Get riskCommence
	 * 
	 * @return riskCommence
	 */
	@Valid
	@Schema(name = "riskCommence", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("riskCommence")
	public @Nullable LocalDate getRiskCommence() {
		return riskCommence;
	}

	public void setRiskCommence(@Nullable LocalDate riskCommence) {
		this.riskCommence = riskCommence;
	}

	public Policy relationshipType(@Nullable String relationshipType) {
		this.relationshipType = relationshipType;
		return this;
	}

	/**
	 * Get relationshipType
	 * 
	 * @return relationshipType
	 */

	@Schema(name = "relationshipType", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("relationshipType")
	public @Nullable String getRelationshipType() {
		return relationshipType;
	}

	public void setRelationshipType(@Nullable String relationshipType) {
		this.relationshipType = relationshipType;
	}

	public Policy adviserNumber(@Nullable String adviserNumber) {
		this.adviserNumber = adviserNumber;
		return this;
	}

	/**
	 * Get adviserNumber
	 * 
	 * @return adviserNumber
	 */

	@Schema(name = "adviserNumber", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("adviserNumber")
	public @Nullable String getAdviserNumber() {
		return adviserNumber;
	}

	public void setAdviserNumber(@Nullable String adviserNumber) {
		this.adviserNumber = adviserNumber;
	}

	public Policy paymentFrequency(@Nullable String paymentFrequency) {
		this.paymentFrequency = paymentFrequency;
		return this;
	}

	/**
	 * Get paymentFrequency
	 * 
	 * @return paymentFrequency
	 */

	@Schema(name = "paymentFrequency", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("paymentFrequency")
	public @Nullable String getPaymentFrequency() {
		return paymentFrequency;
	}

	public void setPaymentFrequency(@Nullable String paymentFrequency) {
		this.paymentFrequency = paymentFrequency;
	}

	public Policy annualPremium(@Nullable Double annualPremium) {
		this.annualPremium = annualPremium;
		return this;
	}

	/**
	 * Get annualPremium
	 * 
	 * @return annualPremium
	 */

	@Schema(name = "annualPremium", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("annualPremium")
	public @Nullable Double getAnnualPremium() {
		return annualPremium;
	}

	public void setAnnualPremium(@Nullable Double annualPremium) {
		this.annualPremium = annualPremium;
	}

	public Policy instalmentPrem(@Nullable Double instalmentPrem) {
		this.instalmentPrem = instalmentPrem;
		return this;
	}

	/**
	 * Get instalmentPrem
	 * 
	 * @return instalmentPrem
	 */

	@Schema(name = "instalmentPrem", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("instalmentPrem")
	public @Nullable Double getInstalmentPrem() {
		return instalmentPrem;
	}

	public void setInstalmentPrem(@Nullable Double instalmentPrem) {
		this.instalmentPrem = instalmentPrem;
	}

	public Policy expenseAnnualPremium(@Nullable Double expenseAnnualPremium) {
		this.expenseAnnualPremium = expenseAnnualPremium;
		return this;
	}

	/**
	 * Get expenseAnnualPremium
	 * 
	 * @return expenseAnnualPremium
	 */

	@Schema(name = "expenseAnnualPremium", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("expenseAnnualPremium")
	public @Nullable Double getExpenseAnnualPremium() {
		return expenseAnnualPremium;
	}

	public void setExpenseAnnualPremium(@Nullable Double expenseAnnualPremium) {
		this.expenseAnnualPremium = expenseAnnualPremium;
	}

	public Policy nextAnniversaryDate(@Nullable OffsetDateTime nextAnniversaryDate) {
		this.nextAnniversaryDate = nextAnniversaryDate;
		return this;
	}

	/**
	 * Get nextAnniversaryDate
	 * 
	 * @return nextAnniversaryDate
	 */
	@Valid
	@Schema(name = "nextAnniversaryDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("nextAnniversaryDate")
	public @Nullable OffsetDateTime getNextAnniversaryDate() {
		return nextAnniversaryDate;
	}

	public void setNextAnniversaryDate(@Nullable OffsetDateTime nextAnniversaryDate) {
		this.nextAnniversaryDate = nextAnniversaryDate;
	}

	public Policy outstandingBalance(@Nullable Double outstandingBalance) {
		this.outstandingBalance = outstandingBalance;
		return this;
	}

	/**
	 * Get outstandingBalance
	 * 
	 * @return outstandingBalance
	 */

	@Schema(name = "outstandingBalance", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("outstandingBalance")
	public @Nullable Double getOutstandingBalance() {
		return outstandingBalance;
	}

	public void setOutstandingBalance(@Nullable Double outstandingBalance) {
		this.outstandingBalance = outstandingBalance;
	}

	public Policy nextPaymentDueDate(@Nullable OffsetDateTime nextPaymentDueDate) {
		this.nextPaymentDueDate = nextPaymentDueDate;
		return this;
	}

	/**
	 * Get nextPaymentDueDate
	 * 
	 * @return nextPaymentDueDate
	 */
	@Valid
	@Schema(name = "nextPaymentDueDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("nextPaymentDueDate")
	public @Nullable OffsetDateTime getNextPaymentDueDate() {
		return nextPaymentDueDate;
	}

	public void setNextPaymentDueDate(@Nullable OffsetDateTime nextPaymentDueDate) {
		this.nextPaymentDueDate = nextPaymentDueDate;
	}

	public Policy comments(@Nullable String comments) {
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

	public Policy createdDate(@Nullable OffsetDateTime createdDate) {
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

	public Policy modifiedDate(@Nullable OffsetDateTime modifiedDate) {
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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Policy policy = (Policy) o;
		return Objects.equals(this.id, policy.id) && Objects.equals(this.status, policy.status)
				&& Objects.equals(this.productName, policy.productName)
				&& Objects.equals(this.riskCommence, policy.riskCommence)
				&& Objects.equals(this.relationshipType, policy.relationshipType)
				&& Objects.equals(this.adviserNumber, policy.adviserNumber)
				&& Objects.equals(this.paymentFrequency, policy.paymentFrequency)
				&& Objects.equals(this.annualPremium, policy.annualPremium)
				&& Objects.equals(this.instalmentPrem, policy.instalmentPrem)
				&& Objects.equals(this.expenseAnnualPremium, policy.expenseAnnualPremium)
				&& Objects.equals(this.nextAnniversaryDate, policy.nextAnniversaryDate)
				&& Objects.equals(this.outstandingBalance, policy.outstandingBalance)
				&& Objects.equals(this.nextPaymentDueDate, policy.nextPaymentDueDate)
				&& Objects.equals(this.comments, policy.comments)
				&& Objects.equals(this.createdDate, policy.createdDate)
				&& Objects.equals(this.modifiedDate, policy.modifiedDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, status, productName, riskCommence, relationshipType, adviserNumber, paymentFrequency,
				annualPremium, instalmentPrem, expenseAnnualPremium, nextAnniversaryDate, outstandingBalance,
				nextPaymentDueDate, comments, createdDate, modifiedDate, changedFields);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Policy {\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("    productName: ").append(toIndentedString(productName)).append("\n");
		sb.append("    riskCommence: ").append(toIndentedString(riskCommence)).append("\n");
		sb.append("    relationshipType: ").append(toIndentedString(relationshipType)).append("\n");
		sb.append("    adviserNumber: ").append(toIndentedString(adviserNumber)).append("\n");
		sb.append("    paymentFrequency: ").append(toIndentedString(paymentFrequency)).append("\n");
		sb.append("    annualPremium: ").append(toIndentedString(annualPremium)).append("\n");
		sb.append("    instalmentPrem: ").append(toIndentedString(instalmentPrem)).append("\n");
		sb.append("    expenseAnnualPremium: ").append(toIndentedString(expenseAnnualPremium)).append("\n");
		sb.append("    nextAnniversaryDate: ").append(toIndentedString(nextAnniversaryDate)).append("\n");
		sb.append("    outstandingBalance: ").append(toIndentedString(outstandingBalance)).append("\n");
		sb.append("    nextPaymentDueDate: ").append(toIndentedString(nextPaymentDueDate)).append("\n");
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
