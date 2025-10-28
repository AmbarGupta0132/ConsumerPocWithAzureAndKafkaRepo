package com.partners.events.repo;

import com.partners.events.entity.ClientBackup;
import com.partners.events.model.ClientId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientBackupRepository extends JpaRepository<ClientBackup, ClientId> {

}
