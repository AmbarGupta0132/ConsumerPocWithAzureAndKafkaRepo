package com.partners.events.controller;

import com.partners.api.PolicyControllerApi;
import com.partners.events.service.PolicyService;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
/**
 * REST controller for handling policy-related API requests.
 * Implements {@link PolicyControllerApi} to provide endpoints for policy operations.
 */
@RestController
public class PolicyRestController implements PolicyControllerApi {

	/** Service for policy operations. */
	private PolicyService policyService;

	/**
	 * Constructs a PolicyRestController with the given policy service.
	 *
	 * @param policyService the service for policy operations
	 */
	public PolicyRestController(PolicyService policyService) {
		this.policyService = policyService;
	}

	/**
	 * Endpoint to download all policies as an Excel file.
	 *
	 * @return a {@link ResponseEntity} containing the Excel file as a {@link Resource}
	 */
	@Override
	public ResponseEntity<Resource> downloadPoliciesExcel() {
		return policyService.downloadPoliciesExcel();
	}
}