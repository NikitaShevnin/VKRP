package ru.gb.vkr.config;

import com.netflix.eureka.RateLimitingFilter;
import com.netflix.zuul.ZuulFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.authentication.AuthenticationFilter;

@Configuration
public class ZuulConfig {
    @Bean
    public ZuulFilter authenticationFilter() {
        return new AuthenticationFilter();
    }

    @Bean
    public ZuulFilter authorizationFilter() {
        return new AuthorizationFilter();
    }

    @Bean
    public ZuulFilter rateLimitingFilter() {
        return new RateLimitingFilter();
    }
}

