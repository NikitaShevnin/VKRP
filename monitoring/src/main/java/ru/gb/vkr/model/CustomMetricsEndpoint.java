package ru.gb.vkr.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomMetricsEndpoint {
    private final Map<String, MetricResponse> availableMetrics = new HashMap<>();

    public Collection<String> getNames() {
        return availableMetrics.keySet();
    }

    public MetricResponse find(String metricName) {
        return availableMetrics.get(metricName);
    }

    public void addMetric(String metricName, double metricValue) {
        availableMetrics.put(metricName, new MetricResponse(metricName, metricValue));
    }
}




