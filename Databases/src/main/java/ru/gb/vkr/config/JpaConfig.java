package ru.gb.vkr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.your_project.repositories")
public class JpaConfig {
    // Можно добавить дополнительные конфигурации при необходимости
}

