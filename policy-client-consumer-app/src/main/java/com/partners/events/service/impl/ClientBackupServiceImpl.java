package com.partners.events.service.impl;

import com.partners.events.entity.ClientBackup;
import com.partners.events.model.ClientId;
import com.partners.events.repo.ClientBackupRepository;
import com.partners.events.service.ClientBackupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service implementation for managing {@link ClientBackup} entities.
 * Provides CRUD operations and interacts with the {@link ClientBackupRepository}.
 */
@Service
public class ClientBackupServiceImpl implements ClientBackupService {
    /**
     * Logger for this class.
     */
    private static final Logger log = LoggerFactory.getLogger(ClientBackupServiceImpl.class);

    /**
     * Repository for {@link ClientBackup} persistence operations.
     */
    private ClientBackupRepository clientBackupRepository;

    /**
     * Constructs a new ClientBackupServiceImpl with the given repository.
     *
     * @param clientBackupRepository the repository for client backup entities
     */
    public ClientBackupServiceImpl(ClientBackupRepository clientBackupRepository) {
        this.clientBackupRepository = clientBackupRepository;
    }

    /**
     * Saves a new {@link ClientBackup} entity to the database.
     *
     * @param clientBackup the client backup entity to save
     * @return the saved {@link ClientBackup} entity
     * @throws RuntimeException if the entity cannot be saved
     */
    @Override
    public ClientBackup saveClientBackup(ClientBackup clientBackup) {
        try {
            return clientBackupRepository.save(clientBackup);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("ClientBackup is not added in DB.");
        }
    }

    /**
     * Updates an existing {@link ClientBackup} entity.
     *
     * @param clientBackup the updated client backup entity
     * @param clientId     the ID of the client to update
     * @return the updated {@link ClientBackup} entity
     */
    @Override
    public ClientBackup updateClientBackup(ClientBackup clientBackup, Long clientId) {
        return clientBackupRepository.save(clientBackup);
    }

    /**
     * Deletes a {@link ClientBackup} entity by its client ID.
     *
     * @param clientId the ID of the client to delete
     */
    @Override
    public void deleteById(ClientId clientId) {
        clientBackupRepository.deleteById(clientId);
    }

    /**
     * Retrieves all {@link ClientBackup} entities with pagination.
     *
     * @param pageRequest the pagination information
     * @return a list of all {@link ClientBackup} entities
     */
    @Override
    public List<ClientBackup> findAll(PageRequest pageRequest) {
        return clientBackupRepository.findAll();
    }

    /**
     * Finds a {@link ClientBackup} entity by its client ID.
     *
     * @param clientId the ID of the client to find
     * @return an {@link Optional} containing the found {@link ClientBackup}, or empty if not found
     */
    @Override
    public Optional<ClientBackup> findById(ClientId clientId) {
        return clientBackupRepository.findById(clientId);
    }

}