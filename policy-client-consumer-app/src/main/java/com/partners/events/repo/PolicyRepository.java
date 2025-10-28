package com.partners.events.repo;

import com.partners.events.entity.Policy;
import com.partners.events.model.PolicyId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, PolicyId> {

	List<Policy> findAllByIdPolicyNumber(Long policyNumber);
}
