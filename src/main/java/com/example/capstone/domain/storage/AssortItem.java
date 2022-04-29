package com.example.capstone.domain.storage;

import javax.persistence.*;

@Entity
@Table(name = "ASSORTITEM")
public class AssortItem {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long assortItemCode;

    @Column
    private String assortItemName;



    public AssortItem() {
    }

    public AssortItem(long assortItemCode, String assortItemName) {
        this.assortItemCode = assortItemCode;
        this.assortItemName = assortItemName;
    }

    public long getAssortItemCode() {
        return assortItemCode;
    }

    public void setAssortItemCode(long assortItemCode) {
        this.assortItemCode = assortItemCode;
    }

    public String getAssortItemName() {
        return assortItemName;
    }

    public void setAssortItemName(String assortItemName) {
        this.assortItemName = assortItemName;
    }

}
