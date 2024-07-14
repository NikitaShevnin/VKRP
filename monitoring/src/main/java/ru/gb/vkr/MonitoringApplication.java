package ru.gb.vkr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Import;

import ru.gb.vkr.config.MonitoringConfiguration;

@SpringBootApplication
@Import(MonitoringConfiguration.class)
@ConditionalOnProperty(prefix = "management.endpoints", name = "web.exposure.include", havingValue = "*")
public class MonitoringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitoringApplication.class, args);
    }
}
