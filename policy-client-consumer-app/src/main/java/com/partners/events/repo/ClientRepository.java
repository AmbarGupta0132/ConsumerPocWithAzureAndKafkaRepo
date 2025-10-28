package com.partners.events.repo;

import com.partners.events.entity.Client;
import com.partners.events.model.ClientId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, ClientId> {

	List<Client> findAllByIdClientId(Long clientId); 
}
