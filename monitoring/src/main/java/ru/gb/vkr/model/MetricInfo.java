package ru.gb.vkr.model;

public class MetricInfo {
    private final String name;
    private final double value;

    public MetricInfo(String name, double value) {
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


