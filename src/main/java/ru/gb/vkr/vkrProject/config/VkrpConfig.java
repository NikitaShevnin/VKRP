package ru.gb.vkr.vkrProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.gb.vkr.vkrProject.repository.UserRepository;
import ru.gb.vkr.vkrProject.service.UserService;
import ru.gb.vkr.vkrProject.service.UserServiceImpl;

@Configuration
public class VkrpConfig {
    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserServiceImpl(userRepository);
    }
}


