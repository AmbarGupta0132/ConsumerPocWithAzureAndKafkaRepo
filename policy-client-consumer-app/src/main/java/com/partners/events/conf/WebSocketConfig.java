package com.partners.events.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
/**
 * Configuration class for WebSocket messaging using STOMP protocol.
 * Enables WebSocket message broker and defines endpoints and broker settings.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * Configures the message broker for handling messaging routes.
     * Enables a simple in-memory broker for broadcasting messages to "/topic".
     * Sets "/app" as the prefix for client-to-server messages.
     *
     * @param config the MessageBrokerRegistry to configure
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic"); // for broadcasting
        config.setApplicationDestinationPrefixes("/app"); // for client-to-server messages
    }

    /**
     * Registers STOMP endpoints for WebSocket connections.
     * Adds "/ws" endpoint and enables SockJS fallback for clients that do not support WebSocket.
     *
     * @param registry the StompEndpointRegistry to register endpoints
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS(); // WebSocket endpoint
    }
}