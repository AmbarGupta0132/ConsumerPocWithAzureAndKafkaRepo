package com.partners.events.service;

import com.partners.events.entity.PolicyBackup;
import com.partners.events.model.PolicyId;

import java.util.List;
import java.util.Optional;

public interface PolicyBackupService {

	PolicyBackup save(PolicyBackup policyBackup);

	List<PolicyBackup> findAll();

	Optional<PolicyBackup> getById(PolicyId policyid);

	
}
