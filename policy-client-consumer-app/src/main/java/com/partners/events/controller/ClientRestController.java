package com.partners.events.controller;

import com.partners.api.ClientControllerApi;
import com.partners.events.service.ClientService;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for client-related API endpoints.
 * Implements {@link com.partners.api.ClientControllerApi}.
 */
@RestController
public class ClientRestController implements ClientControllerApi {

	/** Service for client operations. */
	private final ClientService clientService;

	/**
	 * Constructs a new ClientRestController with the given ClientService.
	 *
	 * @param clientService the service to handle client operations
	 */
	public ClientRestController(ClientService clientService) {
		this.clientService = clientService;
	}

	/**
	 * Downloads the consumer data as an Excel file.
	 * Delegates the request to {@link ClientService#downloadConsumerExcel()}.
	 *
	 * @return a {@link ResponseEntity} containing the Excel file as a {@link Resource}
	 */
	@Override
	public ResponseEntity<Resource> downloadConsumerExcel() {
		return clientService.downloadConsumerExcel();
	}

}
