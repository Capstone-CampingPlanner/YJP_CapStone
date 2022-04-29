package com.example.capstone.domain.Member;

import javax.persistence.*;

@Entity
@Table(name = "MemberPreference")
public class MemberPreference {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long MPRC;

    @ManyToOne
    @JoinColumn(name = "MPRM")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "MPRP")
    private Preference preference;

    public MemberPreference(){

    }

    public MemberPreference(long MPRC, Member member, Preference preference) {
        this.MPRC = MPRC;
        this.member = member;
        this.preference = preference;
    }

    public long getMPRC() {
        return MPRC;
    }

    public void setMPRC(long MPRC) {
        this.MPRC = MPRC;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Preference getPreference() {
        return preference;
    }

    public void setPreference(Preference preference) {
        this.preference = preference;
    }
}
