package com.partners.events.service;

import com.partners.events.entity.Policy;
import com.partners.events.model.PolicyId;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PolicyService {

	Policy save(Policy policy);

	List<Policy> findAll();

	List<Policy> findAll(Pageable pageable);

	Optional<Policy> getById(PolicyId id);

	Optional<Policy> findLastPolicyByPolicyNumber(Long policyNumber);

	ResponseEntity<Resource> downloadPoliciesExcel();
	
	Optional<Policy> savePolicyAndPolicyBackup(Policy policy);
}
