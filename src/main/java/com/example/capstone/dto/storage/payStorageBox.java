package com.example.capstone.dto.storage;

import java.time.LocalDateTime;

public class payStorageBox {

    private String userId;
    private long storageBoxCode;
    private LocalDateTime useStorageStartTime;
    private LocalDateTime useStorageEndTime;
    private int price;

    public payStorageBox() {
    }

    public payStorageBox(String userId, long storageBoxCode) {
        this.userId = userId;
        this.storageBoxCode = storageBoxCode;
    }

    public payStorageBox(String userId, long storageBoxCode, LocalDateTime useStorageStartTime, LocalDateTime useStorageEndTime, int price) {
        this.userId = userId;
        this.storageBoxCode = storageBoxCode;
        this.useStorageStartTime = useStorageStartTime;
        this.useStorageEndTime = useStorageEndTime;
        this.price = price;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getStorageBoxCode() {
        return storageBoxCode;
    }

    public void setStorageBoxCode(long storageBoxCode) {
        this.storageBoxCode = storageBoxCode;
    }

    public LocalDateTime getUseStorageStartTime() {
        return useStorageStartTime;
    }

    public void setUseStorageStartTime(LocalDateTime useStorageStartTime) {
        this.useStorageStartTime = useStorageStartTime;
    }

    public LocalDateTime getUseStorageEndTime() {
        return useStorageEndTime;
    }

    public void setUseStorageEndTime(LocalDateTime useStorageEndTime) {
        this.useStorageEndTime = useStorageEndTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
