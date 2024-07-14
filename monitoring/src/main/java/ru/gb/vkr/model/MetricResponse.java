package ru.gb.vkr.model;

public class MetricResponse {
    private final String name;
    private final Double value;

    public MetricResponse(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Double getValue() {
        return value;
    }
}
