package ru.gb.vkr.model;

public class MetricResponse {
    private final String name;
    private final double value;

    public MetricResponse(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }
}

