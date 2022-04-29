package com.example.capstone.dto.storage;

import com.example.capstone.domain.storage.Storage;

public class StorageData {
    private Box box;
    private Storage storage;

    public StorageData() {
    }

    public StorageData(Box box, Storage storage) {
        this.box = box;
        this.storage = storage;
    }

    public Box getBox() {
        return box;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
