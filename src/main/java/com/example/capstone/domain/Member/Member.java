package com.example.capstone.domain.Member;


import javax.persistence.*;

@Entity
@Table(name = "Member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long MCode;

    @Column
    private String MID;
    @Column
    private String MPass;
    @Column
    private String MNick;

    @Column
    private String MPH;
    @Column
    private String MMail;

    @Column
    private String MZadd;
    @Column
    private String MRadd;
    @Column
    private String MAdd;

    @Column
    private String MSC;
    @Column
    private String MSD;
    @Column
    private String MLD;
    @Column
    private String mname;

    public Member() {

    }

    public Member(long MCode, String MID, String MPass, String MNick, String MPH, String MMail, String MZadd, String MRadd, String MAdd, String MSC, String MSD, String MLD, String mname) {
        this.MCode = MCode;
        this.MID = MID;
        this.MPass = MPass;
        this.MNick = MNick;
        this.MPH = MPH;
        this.MMail = MMail;
        this.MZadd = MZadd;
        this.MRadd = MRadd;
        this.MAdd = MAdd;
        this.MSC = MSC;
        this.MSD = MSD;
        this.MLD = MLD;
        this.mname = mname;
    }

    public long getMCode() {
        return MCode;
    }

    public void setMCode(long MCode) {
        this.MCode = MCode;
    }

    public String getMID() {
        return MID;
    }

    public void setMID(String MID) {
        this.MID = MID;
    }

    public String getMPass() {
        return MPass;
    }

    public void setMPass(String MPass) {
        this.MPass = MPass;
    }

    public String getMNick() {
        return MNick;
    }

    public void setMNick(String MNick) {
        this.MNick = MNick;
    }

    public String getMPH() {
        return MPH;
    }

    public void setMPH(String MPH) {
        this.MPH = MPH;
    }

    public String getMMail() {
        return MMail;
    }

    public void setMMail(String MMail) {
        this.MMail = MMail;
    }

    public String getMZadd() {
        return MZadd;
    }

    public void setMZadd(String MZadd) {
        this.MZadd = MZadd;
    }

    public String getMRadd() {
        return MRadd;
    }

    public void setMRadd(String MRadd) {
        this.MRadd = MRadd;
    }

    public String getMAdd() {
        return MAdd;
    }

    public void setMAdd(String MAdd) {
        this.MAdd = MAdd;
    }

    public String getMSC() {
        return MSC;
    }

    public void setMSC(String MSC) {
        this.MSC = MSC;
    }

    public String getMSD() {
        return MSD;
    }

    public void setMSD(String MSD) {
        this.MSD = MSD;
    }

    public String getMLD() {
        return MLD;
    }

    public void setMLD(String MLD) {
        this.MLD = MLD;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }
}
