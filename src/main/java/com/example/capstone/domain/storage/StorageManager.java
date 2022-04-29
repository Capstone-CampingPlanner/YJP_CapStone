package com.example.capstone.domain.storage;

import com.example.capstone.domain.Member.Member;

import javax.persistence.*;

@Entity
@Table(name="STORAGEMANAGER")
public class StorageManager {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long storageManagerCode;

    @ManyToOne
    @JoinColumn(name = "MCode")
    private Member MCode;

    @ManyToOne
    @JoinColumn(name = "storageCode")
    private Storage storageCode;

    public StorageManager() {
    }

    public StorageManager(Member MCode, Storage storageCode) {
        this.MCode = MCode;
        this.storageCode = storageCode;
    }

    public StorageManager(long storageManagerCode, Member MCode, Storage storageCode) {
        this.storageManagerCode = storageManagerCode;
        this.MCode = MCode;
        this.storageCode = storageCode;
    }

    public long getStorageManagerCode() {
        return storageManagerCode;
    }

    public void setStorageManagerCode(long storageManagerCode) {
        this.storageManagerCode = storageManagerCode;
    }

    public Member getMCode() {
        return MCode;
    }

    public void setMCode(Member MCode) {
        this.MCode = MCode;
    }

    public Storage getStorageCode() {
        return storageCode;
    }

    public void setStorageCode(Storage storageCode) {
        this.storageCode = storageCode;
    }
}