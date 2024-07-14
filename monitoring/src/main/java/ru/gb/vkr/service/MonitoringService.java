package ru.gb.vkr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class MonitoringService {

    private final HealthEndpoint healthEndpoint;
    private final InfoEndpoint infoEndpoint;
    private final MetricsEndpoint metricsEndpoint;

    @Autowired
    public MonitoringService(HealthEndpoint healthEndpoint, InfoEndpoint infoEndpoint, MetricsEndpoint metricsEndpoint) {
        this.healthEndpoint = healthEndpoint;
        this.infoEndpoint = infoEndpoint;
        this.metricsEndpoint = metricsEndpoint;
    }

    public String getHealthStatus() {
        return healthEndpoint.health().getStatus().getCode();
    }

    public String getMemoryUsage() {
        return infoEndpoint.info().get("memory").toString();
    }

    public String getConfigurationProperties() {
        return infoEndpoint.info().toString();
    }

    public List<MetricResponse> getMetrics() {
        Collection<String> metricNames = metricsEndpoint.getNames();
        List<MetricResponse> metrics = new ArrayList<>();
        for (String metricName : metricNames) {
            MetricResponse metric = metricsEndpoint.find(metricName);
            metrics.add(metric);
        }
        return metrics;
    }

}
