package ru.gb.vkr.service;

import com.netflix.servo.Metric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

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

    public String getMetrics() {
        Collection<String> metricNames = metricsEndpoint.names();
        StringBuilder metricsData = new StringBuilder();
        for (String metricName : metricNames) {
            Metric metric = metricsEndpoint.metric(metricName, List.of());
            double metricValue = metric.getValue();
            metricsData.append(metricName)
                    .append(": ")
                    .append(metricValue)
                    .append("\n");
        }
        return metricsData.toString();
    }






}
