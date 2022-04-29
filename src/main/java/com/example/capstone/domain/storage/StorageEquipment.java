package com.example.capstone.domain.storage;

import javax.persistence.*;

@Entity
@Table(name = "STORAGEQUIPMENT")
public class StorageEquipment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long storageEquipment;

    @ManyToOne
    @JoinColumn(name = "memEquipmentCode")
    private MemberEquipment memEquipmentCode;

    @ManyToOne
    @JoinColumn(name = "orderCode")
    private OrderList orderCode;

    public StorageEquipment() {
    }

    public StorageEquipment(long storageEquipment, MemberEquipment memEquipmentCode, OrderList orderCode) {
        this.storageEquipment = storageEquipment;
        this.memEquipmentCode = memEquipmentCode;
        this.orderCode = orderCode;
    }

    public long getStorageEquipment() {
        return storageEquipment;
    }

    public void setStorageEquipment(long storageEquipment) {
        this.storageEquipment = storageEquipment;
    }

    public MemberEquipment getMemEquipmentCode() {
        return memEquipmentCode;
    }

    public void setMemEquipmentCode(MemberEquipment memEquipmentCode) {
        this.memEquipmentCode = memEquipmentCode;
    }

    public OrderList getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(OrderList orderCode) {
        this.orderCode = orderCode;
    }
}
