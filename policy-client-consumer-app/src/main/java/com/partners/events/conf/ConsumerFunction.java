package com.partners.events.conf;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.partners.events.entity.Client;
import com.partners.events.entity.Policy;
import com.partners.events.service.ClientService;
import com.partners.events.service.PolicyService;
import com.partners.events.websocket.WebSocketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * Configuration class that defines consumer beans for handling client and policy updates.
 * Consumes {@link Client} and {@link Policy} objects, processes updates, and sends notifications via WebSocket.
 */
@Configuration
public class ConsumerFunction {

    /**
     * Logger for logging consumer events.
     */
    private static final Logger log = LoggerFactory.getLogger(ConsumerFunction.class);

    /**
     * Service for WebSocket communication.
     */
    private final WebSocketService webSocketService;
    /**
     * Service for client operations.
     */
    private final ClientService clientService;
    /**
     * Service for policy operations.
     */
    private final PolicyService policyService;

    /**
     * Constructs a ConsumerFunction with required services.
     *
     * @param webSocketService the service for WebSocket notifications
     * @param clientService    the service for client operations
     * @param policyService    the service for policy operations
     */
    public ConsumerFunction(WebSocketService webSocketService, ClientService clientService, PolicyService policyService) {
        this.webSocketService = webSocketService;
        this.clientService = clientService;
        this.policyService = policyService;
    }

    /**
     * Bean that consumes {@link Client} updates, saves them, and notifies via WebSocket.
     *
     * @return a Consumer for Client updates
     */
    @Bean
    public Consumer<Client> getClient() {
        return clientUpdates -> {
            log.info("clientUpdates Consumed By Consumer ===> " + clientUpdates);
            Optional<Client> client = clientService.saveClientAndClientBackup(clientUpdates);
            if (client.isPresent()) {
                webSocketService.sendToClientTopic(clientUpdates);
                log.info("Client Updation Successfully");
            } else {
                log.error("Client Updation Failed");
            }
        };

    }

    /**
     * Bean that consumes {@link Policy} updates, saves them, and notifies via WebSocket.
     *
     * @return a Consumer for Policy updates
     */

    @Bean
    public Consumer<Policy> getPolicy() {
        return policyUpdates -> {
            log.info("Policy Consumed By Consumer ===> " + policyUpdates);
            Optional<Policy> policy = policyService.savePolicyAndPolicyBackup(policyUpdates);
            if (policy.isPresent()) {
                webSocketService.sendToPolicyTopic(policyUpdates);
                log.info("Policy Updation Successfully");
            } else {
                log.error("Policy Updation Failed");
            }

       };
    }

}
