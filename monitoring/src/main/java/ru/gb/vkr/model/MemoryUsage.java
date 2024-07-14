package ru.gb.vkr.model;

public class MemoryUsage {
    private final long heapUsed;
    private final long heapMax;
    private final long nonHeapUsed;
    private final long nonHeapMax;

    public MemoryUsage(long heapUsed, long heapMax, long nonHeapUsed, long nonHeapMax) {
        this.heapUsed = heapUsed;
        this.heapMax = heapMax;
        this.nonHeapUsed = nonHeapUsed;
        this.nonHeapMax = nonHeapMax;
    }

    public long getHeapUsed() {
        return heapUsed;
    }

    public long getHeapMax() {
        return heapMax;
    }

    public long getNonHeapUsed() {
        return nonHeapUsed;
    }

    public long getNonHeapMax() {
        return nonHeapMax;
    }
}

