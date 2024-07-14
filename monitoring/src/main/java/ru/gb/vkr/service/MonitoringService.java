package ru.gb.vkr.service;

import java.lang.management.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Service;
import ru.gb.vkr.model.CustomMetricsEndpoint;
import ru.gb.vkr.model.MetricResponse;

@Service
public class MonitoringService {
    private final CustomMetricsEndpoint customMetricsEndpoint;
    private final ConfigurableEnvironment environment;

    @Autowired
    public MonitoringService(CustomMetricsEndpoint customMetricsEndpoint, ConfigurableEnvironment environment) {
        this.customMetricsEndpoint = customMetricsEndpoint;
        this.environment = environment;
    }

    public List<MetricResponse> getMetrics() {
        Collection<String> metricNames = customMetricsEndpoint.getNames();
        List<MetricResponse> metrics = new ArrayList<>();
        for (String metricName : metricNames) {
            MetricResponse metric = customMetricsEndpoint.find(metricName);
            metrics.add(metric);
        }
        return metrics;
    }

    public HealthStatus getHealthStatus() {
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();

        return new HealthStatus(
                osBean.getArch(),
                osBean.getVersion(),
                osBean.getAvailableProcessors(),
                runtimeBean.getUptime()
        );
    }

    public MemoryUsage getMemoryUsage() {
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();

        return new MemoryUsage(
                memoryBean.getHeapMemoryUsage().getUsed(),
                memoryBean.getHeapMemoryUsage().getMax(),
                memoryBean.getNonHeapMemoryUsage().getUsed(),
                memoryBean.getNonHeapMemoryUsage().getMax()
        );
    }

    public Map<String, Object> getConfigurationProperties() {
        return environment.getSystemEnvironment();
    }
}
