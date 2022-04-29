package com.example.capstone.domain.storage;

import com.example.capstone.domain.Member.Member;

import javax.persistence.*;

@Entity
@Table(name = "MEMEQUIPMENT")
public class MemberEquipment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //int.autoincrement
    private long memEquipmentCode;

    @ManyToOne
    @JoinColumn(name = "MCode")
    private Member MCode;
    ;

    @ManyToOne
    @JoinColumn(name = "assortItemCode")
    private AssortItem assortItemCode;

    @Column
    private String memEquipmentName;

    @Column
    private String memEquipmentState;

    @Column
    private int memEquipmentCount;

    public MemberEquipment() {
    }

    public MemberEquipment(long memEquipmentCode, Member MCode, AssortItem assortItemCode, String memEquipmentName, String memEquipmentState, int memEquipmentCount) {
        this.memEquipmentCode = memEquipmentCode;
        this.MCode = MCode;
        this.assortItemCode = assortItemCode;
        this.memEquipmentName = memEquipmentName;
        this.memEquipmentState = memEquipmentState;
        this.memEquipmentCount = memEquipmentCount;
    }

    public long getMemEquipmentCode() {
        return memEquipmentCode;
    }

    public void setMemEquipmentCode(long memEquipmentCode) {
        this.memEquipmentCode = memEquipmentCode;
    }

    public Member getMCode() {
        return MCode;
    }

    public void setMCode(Member MCode) {
        this.MCode = MCode;
    }

    public AssortItem getAssortItemCode() {
        return assortItemCode;
    }

    public void setAssortItemCode(AssortItem assortItemCode) {
        this.assortItemCode = assortItemCode;
    }

    public String getMemEquipmentName() {
        return memEquipmentName;
    }

    public void setMemEquipmentName(String memEquipmentName) {
        this.memEquipmentName = memEquipmentName;
    }

    public String getMemEquipmentState() {
        return memEquipmentState;
    }

    public void setMemEquipmentState(String memEquipmentState) {
        this.memEquipmentState = memEquipmentState;
    }

    public int getMemEquipmentCount() {
        return memEquipmentCount;
    }

    public void setMemEquipmentCount(int memEquipmentCount) {
        this.memEquipmentCount = memEquipmentCount;
    }
}


