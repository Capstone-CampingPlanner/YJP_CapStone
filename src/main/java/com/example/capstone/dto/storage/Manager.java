package com.example.capstone.dto.storage;

public class Manager {

    private String member;
    private long storage;

    public Manager() {
    }

    public Manager(String member, long storage) {
        this.member = member;
        this.storage = storage;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public long getStorage() {
        return storage;
    }

    public void setStorage(long storage) {
        this.storage = storage;
    }
}
