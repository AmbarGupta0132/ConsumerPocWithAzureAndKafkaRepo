package com.partners.events.service.impl;

import com.partners.events.entity.Policy;
import com.partners.events.entity.PolicyBackup;
import com.partners.events.mapper.PolicyModelMapper;
import com.partners.events.model.PolicyId;
import com.partners.events.repo.PolicyBackupRepository;
import com.partners.events.repo.PolicyRepository;
import com.partners.events.service.PolicyService;
import jakarta.transaction.Transactional;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

/**
 * Service implementation for managing {@link Policy} entities.
 * Provides CRUD operations, Excel export, and backup functionality.
 */
@Service
public class PolicyServiceImpl implements PolicyService {
	/** Logger for this class. */
	private static final Logger log = LoggerFactory.getLogger(PolicyServiceImpl.class);

	/** Repository for {@link Policy} persistence operations. */
	private PolicyRepository policyRepository;
	/** Repository for {@link PolicyBackup} persistence operations. */
	private PolicyBackupRepository policyBackupRepository;
	/** Mapper for converting between {@link Policy} and {@link PolicyBackup}. */
	private PolicyModelMapper policyModelMapper;

	/**
	 * Default constructor.
	 */
	public PolicyServiceImpl() {
		super();
	}

	/**
	 * Constructs a PolicyServiceImpl with the provided repositories and mapper.
	 *
	 * @param policyRepository repository for policy entities
	 * @param policyBackupRepository repository for policy backup entities
	 * @param policyModelMapper mapper for policy and backup conversion
	 */
	@Autowired
	public PolicyServiceImpl(PolicyRepository policyRepository, PolicyBackupRepository policyBackupRepository,
			PolicyModelMapper policyModelMapper) {
		this.policyRepository = policyRepository;
		this.policyBackupRepository = policyBackupRepository;
		this.policyModelMapper = policyModelMapper;
	}

	/**
	 * Saves a {@link Policy} entity to the database.
	 *
	 * @param policy the policy entity to save
	 * @return the saved {@link Policy} entity
	 */
	@Override
	public Policy save(Policy policy) {
		return policyRepository.save(policy);
	}

	/**
	 * Retrieves all {@link Policy} entities.
	 *
	 * @return a list of all policies
	 */
	@Override
	public List<Policy> findAll() {
		return policyRepository.findAll();
	}

	/**
	 * Finds a {@link Policy} by its ID.
	 *
	 * @param id the policy ID
	 * @return an {@link Optional} containing the policy if found
	 */
	@Override
	public Optional<Policy> getById(PolicyId id) {
		return policyRepository.findById(id);
	}

	/**
	 * Finds the most recent {@link Policy} by policy number.
	 *
	 * @param policyNumber the policy number
	 * @return an {@link Optional} containing the last policy if found
	 */
	@Override
	public Optional<Policy> findLastPolicyByPolicyNumber(Long policyNumber) {
		List<Policy> allByIdPolicyNumber = policyRepository.findAllByIdPolicyNumber(policyNumber);
		return allByIdPolicyNumber.size() > 0 ? Optional.of(allByIdPolicyNumber.getLast()) : Optional.empty();
	}

	/**
	 * Retrieves all {@link Policy} entities with pagination.
	 *
	 * @param pageable pagination information
	 * @return a list of policies for the given page
	 */
	@Override
	public List<Policy> findAll(Pageable pageable) {
		return policyRepository.findAll(pageable).getContent();
	}

	/**
	 * Downloads all policy data as an Excel file.
	 *
	 * @return a {@link ResponseEntity} containing the Excel file as a {@link Resource}
	 */
	@Override
	public ResponseEntity<Resource> downloadPoliciesExcel() {
		List<Policy> policies = findAll();

		try (Workbook workbook = new XSSFWorkbook()) {
			Sheet sheet = workbook.createSheet("Policies");
			Row header = sheet.createRow(0);

			String[] columns = { "Policy ID", "Status", "Product Name", "Risk Commence", "Relationship Type",
					"Adviser Number", "Payment Frequency", "Annual Premium", "Instalment Premium",
					"Expense Annual Premium", "Next Anniversary Date", "Outstanding Balance", "Next Payment Due Date",
					"Comments", "Created Date", "Modified Date", "Version" };

			for (int i = 0; i < columns.length; i++) {
				header.createCell(i).setCellValue(columns[i]);
			}

			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

			int rowIdx = 1;
			for (Policy policy : policies) {
				Row row = sheet.createRow(rowIdx++);

				row.createCell(0)
						.setCellValue(policy.getId() != null ? policy.getId().getPolicyNumber().toString() : "");
				row.createCell(1).setCellValue(policy.getStatus() != null ? policy.getStatus() : "");
				row.createCell(2).setCellValue(policy.getProductName() != null ? policy.getProductName() : "");
				row.createCell(3).setCellValue(
						policy.getRiskCommence() != null ? policy.getRiskCommence().format(dateFormatter) : "");
				row.createCell(4)
						.setCellValue(policy.getRelationshipType() != null ? policy.getRelationshipType() : "");
				row.createCell(5).setCellValue(policy.getAdviserNumber() != null ? policy.getAdviserNumber() : "");
				row.createCell(6)
						.setCellValue(policy.getPaymentFrequency() != null ? policy.getPaymentFrequency() : "");
				row.createCell(7).setCellValue(policy.getAnnualPremium() != null ? policy.getAnnualPremium() : 0);
				row.createCell(8).setCellValue(policy.getInstalmentPrem() != null ? policy.getInstalmentPrem() : 0);
				row.createCell(9)
						.setCellValue(policy.getExpenseAnnualPremium() != null ? policy.getExpenseAnnualPremium() : 0);
				row.createCell(10)
						.setCellValue(policy.getNextAnniversaryDate() != null
								? policy.getNextAnniversaryDate().format(dateTimeFormatter)
								: "");
				row.createCell(11)
						.setCellValue(policy.getOutstandingBalance() != null ? policy.getOutstandingBalance() : 0);
				row.createCell(12)
						.setCellValue(policy.getNextPaymentDueDate() != null
								? policy.getNextPaymentDueDate().format(dateTimeFormatter)
								: "");
				row.createCell(13).setCellValue(policy.getComments() != null ? policy.getComments() : "");
				row.createCell(14).setCellValue(
						policy.getCreatedDate() != null ? policy.getCreatedDate().format(dateTimeFormatter) : "");
				row.createCell(15).setCellValue(
						policy.getModifiedDate() != null ? policy.getModifiedDate().format(dateTimeFormatter) : "");
				row.createCell(16).setCellValue(
						policy.getId().getVersion() != null ? policy.getId().getVersion() : "");

			}

			ByteArrayOutputStream out = new ByteArrayOutputStream();
			workbook.write(out);
			ByteArrayResource resource = new ByteArrayResource(out.toByteArray());

			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=policies.xlsx");

			return ResponseEntity.ok().headers(headers).contentLength(resource.contentLength())
					.contentType(MediaType
							.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
					.body(resource);

		} catch (IOException e) {
			log.error(e.getMessage());
			throw new RuntimeException("Failed to generate Excel file", e);
		}
	}

	/**
	 * Saves a policy and backs up the previous version if it exists.
	 * The previous policy is backed up and deleted before saving the new policy.
	 *
	 * @param policy the policy entity to save
	 * @return an {@link Optional} containing the saved policy
	 * @throws RuntimeException if backup or save fails
	 */
	@Transactional
	@Override
	public Optional<Policy> savePolicyAndPolicyBackup(Policy policy) {
		try {
			String version = "v" + (Integer.valueOf(policy.getId().getVersion().substring(1)) - 1);
			PolicyId policyId = new PolicyId(policy.getId().getPolicyNumber(), version);
			Optional<Policy> optionalPolicy = getById(policyId);
			if (optionalPolicy.isPresent()) {
				Policy previousPolicy = optionalPolicy.get();
				// Backup the existing client
				PolicyBackup savedClientBackup = policyBackupRepository
						.save(policyModelMapper.toPolicyBackup(previousPolicy));
                // Delete the old client and save the new one
                policyRepository.deleteById(previousPolicy.getId());
            }
			return Optional.of(policyRepository.save(policy));
		} catch (Exception e) {
			log.error("Error saving client and backup: {}", e.getMessage(), e);
			throw new RuntimeException("Client is not updated with given value: " + policy, e);
		}
	}

}