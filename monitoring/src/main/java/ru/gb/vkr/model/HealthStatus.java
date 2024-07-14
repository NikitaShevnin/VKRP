package ru.gb.vkr.model;

public class HealthStatus {
    private final String architecture;
    private final String osVersion;
    private final int availableProcessors;
    private final long uptime;

    public HealthStatus(String architecture, String osVersion, int availableProcessors, long uptime) {


        this.architecture = architecture;
        this.osVersion = osVersion;
        this.availableProcessors = availableProcessors;
        this.uptime = uptime;
    }

    public String getArchitecture() {
        return architecture;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public int getAvailableProcessors() {
        return availableProcessors;
    }

    public long getUptime() {
        return uptime;
    }
}
