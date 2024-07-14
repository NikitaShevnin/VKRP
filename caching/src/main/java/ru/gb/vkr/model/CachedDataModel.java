package ru.gb.vkr.model;

public class CachedDataModel {
    private Long id;
    private String data;

    public CachedDataModel(Long id, String data) {
        this.id = id;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
