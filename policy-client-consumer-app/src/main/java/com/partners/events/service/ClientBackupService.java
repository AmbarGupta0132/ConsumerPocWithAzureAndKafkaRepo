package com.partners.events.service;

import com.partners.events.entity.ClientBackup;
import com.partners.events.model.ClientId;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface ClientBackupService {

	ClientBackup saveClientBackup(ClientBackup clientBackup);

	ClientBackup updateClientBackup(ClientBackup clientBackup, Long clientId);

	void deleteById(ClientId clientId);

	List<ClientBackup> findAll(PageRequest pageRequest);

	Optional<ClientBackup> findById(ClientId clientId);
}
