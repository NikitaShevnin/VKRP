package ru.gb.vkr.vkrProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.gb.vkr.vkrProject.repository.UserRepository;
import ru.gb.vkr.vkrProject.service.UserService;
import ru.gb.vkr.vkrProject.service.UserServiceImpl;

/**
 * Конфигурационный класс для нашего Spring Boot-приложения.
 */
@Configuration
public class VkrpConfig {
    /**
     * @param userRepository Метод принимает UserRepository в качестве параметра
     * @return возвращает экземпляр UserServiceImpl
     */
    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserServiceImpl(userRepository);
    }
}


