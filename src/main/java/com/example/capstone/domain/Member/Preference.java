package com.example.capstone.domain.Member;

import javax.persistence.*;

@Entity
@Table(name = "preference")
public class Preference {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long PRC;

    @Column
    private long PRCC;

    @Column(length = 10)
    private String PRN;

    @Column(length = 80)
    private String PRD;

    public Preference(){

    }

    public Preference(long PRC, long PRCC, String PRN, String PRD) {
        this.PRC = PRC;
        this.PRCC = PRCC;
        this.PRN = PRN;
        this.PRD = PRD;
    }

    public long getPRC() {
        return PRC;
    }

    public void setPRC(long PRC) {
        this.PRC = PRC;
    }

    public long getPRCC() {
        return PRCC;
    }

    public void setPRCC(long PRCC) {
        this.PRCC = PRCC;
    }

    public String getPRN() {
        return PRN;
    }

    public void setPRN(String PRN) {
        this.PRN = PRN;
    }

    public String getPRD() {
        return PRD;
    }

    public void setPRD(String PRD) {
        this.PRD = PRD;
    }
}
