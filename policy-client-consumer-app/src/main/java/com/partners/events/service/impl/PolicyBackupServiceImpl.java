package com.partners.events.service.impl;

import com.partners.events.entity.PolicyBackup;
import com.partners.events.model.PolicyId;
import com.partners.events.repo.PolicyBackupRepository;
import com.partners.events.service.PolicyBackupService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service implementation for managing {@link PolicyBackup} entities.
 * Provides CRUD operations and interacts with the {@link PolicyBackupRepository}.
 */
@Service
public class PolicyBackupServiceImpl implements PolicyBackupService {

    /** Repository for {@link PolicyBackup} persistence operations. */
    private PolicyBackupRepository backupRepository;

    /**
     * Constructs a new PolicyBackupServiceImpl with the given repository.
     *
     * @param backupRepository the repository for policy backup entities
     */
    public PolicyBackupServiceImpl(PolicyBackupRepository backupRepository) {
        this.backupRepository = backupRepository;
    }

    /**
     * Saves a new {@link PolicyBackup} entity to the database.
     *
     * @param policyBackup the policy backup entity to save
     * @return the saved {@link PolicyBackup} entity
     */
    @Override
    public PolicyBackup save(PolicyBackup policyBackup) {
        return backupRepository.save(policyBackup);
    }

    /**
     * Retrieves all {@link PolicyBackup} entities.
     *
     * @return a list of all policy backup entities
     */
    @Override
    public List<PolicyBackup> findAll() {
        return backupRepository.findAll();
    }

    /**
     * Finds a {@link PolicyBackup} entity by its policy ID.
     *
     * @param policyid the ID of the policy to find
     * @return an {@link Optional} containing the found {@link PolicyBackup}, or empty if not found
     */
    @Override
    public Optional<PolicyBackup> getById(PolicyId policyid) {
        return backupRepository.findById(policyid);
    }

}
