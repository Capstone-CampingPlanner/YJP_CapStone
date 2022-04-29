package com.example.capstone.domain.storage;

import com.example.capstone.domain.Member.Member;

import javax.persistence.*;

@Entity
@Table(name = "ORDERLIST")
public class OrderList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //int.autoincrement
    private long orderCode; // 주문코드

    @ManyToOne
    @JoinColumn(name = "MCode")
    private Member MCode;

    @Column
    private int orderPrice;

    @Column
    private String orderType;

//    @OneToOne(mappedBy = "orderCode")
//    @JoinColumn(unique = true)
//    private Delivery deliveryCode;

    public OrderList() {
    }

    public OrderList(Member MCode) {
        this.MCode = MCode;
    }

    public OrderList(Member MCode, int orderPrice) {
        this.MCode = MCode;
        this.orderPrice = orderPrice;
    }

    public OrderList(Member MCode, int orderPrice, String orderType) {
        this.MCode = MCode;
        this.orderPrice = orderPrice;
        this.orderType = orderType;
    }

    public long getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(long orderCode) {
        this.orderCode = orderCode;
    }

    public Member getMCode() {
        return MCode;
    }

    public void setMCode(Member MCode) {
        this.MCode = MCode;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
}
