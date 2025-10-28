package com.partners.events.controller;

import com.partners.events.entity.Policy;
import com.partners.events.entity.PolicyBackup;
import com.partners.events.service.PolicyBackupService;
import com.partners.events.service.PolicyService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Controller for handling web requests related to policies.
 * Provides endpoints for viewing policy updates and listing policies.
 */
@Controller
@RequestMapping("/policies")
public class PolicyController {

    /**
     * Service for policy operations.
     */
    private final PolicyService policyService;
    private final PolicyBackupService policyBackupService;

    /**
     * Constructs a PolicyController with the given policy service.
     *
     * @param policyService the service for policy operations
     */
     public PolicyController(PolicyService policyService, PolicyBackupService policyBackupService) {
        this.policyService = policyService;
        this.policyBackupService = policyBackupService;
    }

    /**
     * Displays the policy updates page.
     *
     * @return the name of the policy updates view
     */
    @GetMapping("/updates")
    public String showPolicyUpdated() {
        return "policy-updates";
    }

    /**
     * Retrieves a list of policies and adds it to the model for display.
     *
     * @param model the model to add attributes to
     * @return the name of the policy view page
     */
    @GetMapping("/show")
    public String showPolicyUpdates(Model model) {
        List<Policy> policyList = policyService.findAll(PageRequest.of(0, 50));
        model.addAttribute("policyList", policyList);
        return "policy-view";
    }


    @GetMapping("/backup")
    public String showPolicyBackup(Model model) {
        List<PolicyBackup> policyBackupList = policyBackupService.findAll();
        model.addAttribute("policyBackupList", policyBackupList);
        return "policy-backup-view";
    }
}