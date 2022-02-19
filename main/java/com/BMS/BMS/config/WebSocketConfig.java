package com.blackwater.blackwaterbillingmanagementsystem.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
  private static final Logger logger = LoggerFactory.getLogger(WebSocketMessageBrokerConfigurer.class);
  @Value("${websocket.topic.update.destination}")
  private String websocketUpdateDestination;
  @Value("${websocket.client.destination}")
  private String clientDestination;
  @Value("${websocket.job.destination}")
  private String jobDestination;

  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    logger.debug("connecting");
    registry
        .addEndpoint("/connect")
        .setAllowedOrigins("*")
        .withSockJS();
  }

  @Override
  public void configureMessageBroker(MessageBrokerRegistry registry) {
    registry.enableSimpleBroker(
        websocketUpdateDestination + clientDestination,
        websocketUpdateDestination + jobDestination);
    registry.setApplicationDestinationPrefixes("/ws");
  }
}