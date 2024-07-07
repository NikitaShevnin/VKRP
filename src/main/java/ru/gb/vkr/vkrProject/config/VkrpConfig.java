package ru.gb.vkr.vkrProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.gb.vkr.vkrProject.service.UserServiceImpl;

@Configuration
public class VkrpConfig {
    @Bean
    public UserServiceImpl serviceImpl() {
        return new UserServiceImpl();
    }
}


