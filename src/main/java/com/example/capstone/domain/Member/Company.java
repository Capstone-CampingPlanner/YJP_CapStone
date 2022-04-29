package com.example.capstone.domain.Member;

import javax.persistence.*;

@Entity
@Table(name="Company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long CC;

    @OneToOne
    @JoinColumn(name = "MCode")
    private Member member;

    @Column
    private String CCode;

    @Column
    private String CName;

    @Column
    private String CEO;

    @Column
    private String Chp;

    @Column
    private String CZadd;
    @Column
    private String CRadd;
    @Column
    private String CAdd;

    @Column
    private String Cph;

    @Column
    private String CEmail;

    @Column
    private String Cst;
    @Column
    private String Csc;

    public Company(){

    }

    public Company(long CC, Member member, String CCode, String CName, String CEO, String chp, String CZadd, String CRadd, String CAdd, String cph, String CEmail, String cst, String csc) {
        this.CC = CC;
        this.member = member;
        this.CCode = CCode;
        this.CName = CName;
        this.CEO = CEO;
        Chp = chp;
        this.CZadd = CZadd;
        this.CRadd = CRadd;
        this.CAdd = CAdd;
        Cph = cph;
        this.CEmail = CEmail;
        Cst = cst;
        Csc = csc;
    }

    public long getCC() {
        return CC;
    }

    public void setCC(long CC) {
        this.CC = CC;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getCCode() {
        return CCode;
    }

    public void setCCode(String CCode) {
        this.CCode = CCode;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public String getCEO() {
        return CEO;
    }

    public void setCEO(String CEO) {
        this.CEO = CEO;
    }

    public String getChp() {
        return Chp;
    }

    public void setChp(String chp) {
        Chp = chp;
    }

    public String getCZadd() {
        return CZadd;
    }

    public void setCZadd(String CZadd) {
        this.CZadd = CZadd;
    }

    public String getCRadd() {
        return CRadd;
    }

    public void setCRadd(String CRadd) {
        this.CRadd = CRadd;
    }

    public String getCAdd() {
        return CAdd;
    }

    public void setCAdd(String CAdd) {
        this.CAdd = CAdd;
    }

    public String getCph() {
        return Cph;
    }

    public void setCph(String cph) {
        Cph = cph;
    }

    public String getCEmail() {
        return CEmail;
    }

    public void setCEmail(String CEmail) {
        this.CEmail = CEmail;
    }

    public String getCst() {
        return Cst;
    }

    public void setCst(String cst) {
        Cst = cst;
    }

    public String getCsc() {
        return Csc;
    }

    public void setCsc(String csc) {
        Csc = csc;
    }
}

