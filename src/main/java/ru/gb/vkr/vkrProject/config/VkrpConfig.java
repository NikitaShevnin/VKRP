package ru.gb.vkr.vkrProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.gb.vkr.vkrProject.service.ServiceImpl;

@Configuration
public class VkrpConfig {
    @Bean
    public ServiceImpl serviceImpl() {
        return new ServiceImpl();
    }
}


