package com.example.capstone.domain.storage;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "STORAGEBOX")
public class StorageBox {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long storageBoxCode;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "storageCode")
    private Storage storageCode;

    @Column
    private String storageBoxName;

    @Column
    private String storageBoxType;

    @Column
    private int storageBoxPrice;
    // 소=33000 중=45000 대=60000

    @Column
    private String storageBoxState = "0";

    public StorageBox() {
    }

    public StorageBox(Storage storageCode, String storageBoxName, String storageBoxType, int storageBoxPrice, String storageBoxState) {
        this.storageCode = storageCode;
        this.storageBoxName = storageBoxName;
        this.storageBoxType = storageBoxType;
        this.storageBoxPrice = storageBoxPrice;
        this.storageBoxState = storageBoxState;
    }

    public StorageBox(Storage storageCode, String storageBoxName, String storageBoxType, String storageBoxState) {
        this.storageCode = storageCode;
        this.storageBoxName = storageBoxName;
        this.storageBoxType = storageBoxType;
        this.storageBoxState = storageBoxState;
    }

    public StorageBox(long storageBoxCode, Storage storageCode, String storageBoxName, String storageBoxType, String storageBoxState) {
        this.storageBoxCode = storageBoxCode;
        this.storageCode = storageCode;
        this.storageBoxName = storageBoxName;
        this.storageBoxType = storageBoxType;
        this.storageBoxState = storageBoxState;
    }

    public long getStorageBoxCode() {
        return storageBoxCode;
    }

    public void setStorageBoxCode(long storageBoxCode) {
        this.storageBoxCode = storageBoxCode;
    }

    public Storage getStorageCode() {
        return storageCode;
    }

    public void setStorageCode(Storage storageCode) {
        this.storageCode = storageCode;
    }

    public String getStorageBoxName() {
        return storageBoxName;
    }

    public void setStorageBoxName(String storageBoxName) {
        this.storageBoxName = storageBoxName;
    }

    public String getStorageBoxType() {
        return storageBoxType;
    }

    public void setStorageBoxType(String storageBoxType) {
        this.storageBoxType = storageBoxType;
    }

    public int getStorageBoxPrice() {
        return storageBoxPrice;
    }

    public void setStorageBoxPrice(int storageBoxPrice) {
        this.storageBoxPrice = storageBoxPrice;
    }

    public String getStorageBoxState() {
        return storageBoxState;
    }

    public void setStorageBoxState(String storageBoxState) {
        this.storageBoxState = storageBoxState;
    }
}


