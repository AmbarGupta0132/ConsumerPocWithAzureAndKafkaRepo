package com.partners.events.websocket;

import com.partners.events.entity.Client;
import com.partners.events.entity.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
/*
 * Service for sending real-time updates via WebSocket topics.
 * Uses {@link SimpMessagingTemplate} to broadcast client and policy updates.
 */
public class WebSocketService {
    /** Template for sending messages over WebSocket. */
    private SimpMessagingTemplate messagingTemplate;

    /** WebSocket topic for client updates. */
    public static final String CLIENT_WEB_Socket_TOPIC = "/topic/clients-updates";

    /** WebSocket topic for policy updates. */
    public static final String POLICY_WEB_Socket_TOPIC = "/topic/policy-updates";

    /**
     * Default constructor.
     */
    public WebSocketService() {
        super();
    }

    /**
     * Constructs a WebSocketService with the provided messaging template.
     *
     * @param messagingTemplate the template used to send WebSocket messages
     */
    @Autowired
    public WebSocketService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    /**
     * Sends client update data to the client WebSocket topic.
     *
     * @param clientUpdates the client update payload to broadcast
     */
    public void sendToClientTopic(Client clientUpdates) {
        messagingTemplate.convertAndSend(CLIENT_WEB_Socket_TOPIC, clientUpdates);
    }

    /**
     * Sends policy update data to the policy WebSocket topic.
     *
     * @param policyUpdates the policy update payload to broadcast
     */
    public void sendToPolicyTopic(Policy policyUpdates) {
        messagingTemplate.convertAndSend(POLICY_WEB_Socket_TOPIC, policyUpdates);
    }
}