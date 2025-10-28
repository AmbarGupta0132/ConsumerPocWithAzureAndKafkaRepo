package com.partners.events.controller;

import com.partners.events.entity.Client;
import com.partners.events.entity.ClientBackup;
import com.partners.events.service.ClientBackupService;
import com.partners.events.service.ClientService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Controller for handling client-related web requests.
 * Provides endpoints for viewing client updates and listing clients.
 */
@Controller
@RequestMapping("/clients")
public class ClientController {

	/** Service for client operations. */
	private final ClientService clientService;
	private final ClientBackupService clientBackupService;

	/**
	 * Constructs a ClientController with the given client service.
	 *
	 * @param clientService the service for client operations
	 */
	public ClientController(ClientService clientService,ClientBackupService clientBackupService) {
		this.clientService = clientService;
		this.clientBackupService = clientBackupService;
	}

	/**
	 * Displays the client updates page.
	 *
	 * @return the name of the client updates view
	 */
	@GetMapping("/updates")
	public String showClientUpdates() {
		return "client-updates";
	}

	/**
	 * Retrieves a list of clients and adds it to the model for display.
	 *
	 * @param model the model to add attributes to
	 * @return the name of the client view page
	 */
	@GetMapping("/show")
	public String getAllClients(Model model) {
		List<Client> clientList = clientService.findAll(PageRequest.of(0, 50));
		model.addAttribute("clientList", clientList);
		return "client-view";
	}


	@GetMapping("/backup")
	public String getAllClientsBackup(Model model) {
		List<ClientBackup> clientBackupList = clientBackupService.findAll(PageRequest.of(0, 50));
		model.addAttribute("clientBackupList", clientBackupList);
		return "client-backup-view";
	}
}