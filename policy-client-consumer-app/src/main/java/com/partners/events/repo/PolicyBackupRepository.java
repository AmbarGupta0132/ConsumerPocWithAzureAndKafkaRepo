package com.partners.events.repo;

import com.partners.events.entity.PolicyBackup;
import com.partners.events.model.PolicyId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PolicyBackupRepository extends JpaRepository<PolicyBackup, PolicyId> {

}
