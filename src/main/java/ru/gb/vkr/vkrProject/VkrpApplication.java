package ru.gb.vkr.vkrProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Класс, отвечающий за запуск приложения.
 */
@EnableZuulProxy
@SpringBootApplication
@ComponentScan(basePackages = "com.example.vkrp")
public class VkrpApplication {
	public static void main(String[] args) {
		SpringApplication.run(VkrpApplication.class, args);
	}
}