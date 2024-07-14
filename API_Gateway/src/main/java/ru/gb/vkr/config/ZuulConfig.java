package ru.gb.vkr.config;

import com.netflix.zuul.ZuulFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.gb.vkr.filters.AuthenticationFilter;
import ru.gb.vkr.filters.AuthorizationFilter;
import ru.gb.vkr.filters.RateLimitingFilter;

@Configuration
public class ZuulConfig {

    @Autowired
    private AuthenticationFilter authenticationFilter;

    @Autowired
    private AuthorizationFilter authorizationFilter;

    @Autowired
    private RateLimitingFilter rateLimitingFilter;

    @Bean
    public ZuulFilter authenticationZuulFilter() {
        return authenticationFilter;
    }

    @Bean
    public ZuulFilter authorizationZuulFilter() {
        return authorizationFilter;
    }

    @Bean
    public ZuulFilter rateLimitingZuulFilter() {
        return rateLimitingFilter;
    }
}
