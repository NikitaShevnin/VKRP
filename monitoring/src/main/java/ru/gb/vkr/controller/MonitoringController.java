package ru.gb.vkr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.gb.vkr.service.MonitoringService;

@RestController
@RequestMapping("/monitoring")
public class MonitoringController {

    private final MonitoringService monitoringService;

    @Autowired
    public MonitoringController(MonitoringService monitoringService) {
        this.monitoringService = monitoringService;
    }

    @GetMapping("/health")
    public ResponseEntity<String> getHealthStatus() {
        String healthStatus = monitoringService.getHealthStatus();
        return new ResponseEntity<>(healthStatus, HttpStatus.OK);
    }

    @GetMapping("/memory")
    public ResponseEntity<String> getMemoryUsage() {
        String memoryUsage = monitoringService.getMemoryUsage();
        return new ResponseEntity<>(memoryUsage, HttpStatus.OK);
    }

    @GetMapping("/config")
    public ResponseEntity<String> getConfigurationProperties() {
        String configProperties = monitoringService.getConfigurationProperties();
        return new ResponseEntity<>(configProperties, HttpStatus.OK);
    }

    @GetMapping("/metrics")
    public ResponseEntity<String> getMetrics() {
        String metrics = monitoringService.getMetrics();
        return new ResponseEntity<>(metrics, HttpStatus.OK);
    }
}

