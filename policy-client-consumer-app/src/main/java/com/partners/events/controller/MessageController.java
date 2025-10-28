package com.partners.events.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Controller for handling WebSocket and HTTP requests related to messages.
 * Provides endpoints for broadcasting messages to policy and client update topics,
 * and for displaying the index page.
 */
@Controller
public class MessageController {

    /**
     * Handles incoming WebSocket messages sent to "/app/sendMessage" and broadcasts
     * them to subscribers of "/topic/policy-updates".
     *
     * @param message the message received from the client
     * @return a response string indicating the message was received
     */
    @MessageMapping("/policyMessage") // client sends to /app/policyMessage
    @SendTo("/topic/policy-updates") // broadcast to subscribers
    public String broadcastMessage(String message) {
        return "Received: " + message;
    }

    /**
     * Handles incoming WebSocket messages sent to "/app/sendMessagess" and broadcasts
     * them to subscribers of "/topic/clients-updates".
     *
     * @param message the message received from the client
     * @return a response string indicating the message was received
     */
    @MessageMapping("/clientMessage") // client sends to /app/clientMessage
    @SendTo("/topic/clients-updates") // broadcast to subscribers
    public String broadcastClient(String message) {
        return "Received: " + message;
    }


}