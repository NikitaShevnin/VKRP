package ru.gb.vkr.config;

import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties;
import org.springframework.boot.actuate.autoconfigure.security.reactive.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class MonitoringConfiguration {

    private final WebEndpointProperties webEndpointProperties;

    public MonitoringConfiguration(WebEndpointProperties webEndpointProperties) {
        this.webEndpointProperties = webEndpointProperties;
    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                .authorizeExchange(exchanges -> exchanges
                        .matchers(EndpointRequest.toAnyEndpoint())
                        .permitAll()
                        .anyExchange()
                        .authenticated())
                .csrf(Customizer.withDefaults())
                .build();
    }
}
