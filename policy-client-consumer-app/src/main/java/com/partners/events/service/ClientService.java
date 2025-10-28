package com.partners.events.service;


import com.partners.events.entity.Client;
import com.partners.events.model.ClientId;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ClientService {

	public Client save(Client client);

	public List<Client> findAll();

	public List<Client> findAll(Pageable pageable);

	public Optional<Client> getById(ClientId id);

	Optional<Client> findLastClientByClientId(Long clientId);

	ResponseEntity<Resource> downloadConsumerExcel();

	Optional<Client> saveClientAndClientBackup(Client client);
}
