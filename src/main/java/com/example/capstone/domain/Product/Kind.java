package com.example.capstone.domain.Product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="kind")
public class Kind {

    @Id
    private int kindid;

    @Column()
    private String kindname;

//    @JsonManagedReference
//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "kind")
//    @JsonIgnore
//    private List<Menu> menus;


    public Kind() {}
    public Kind(int kindid, String kindname) {
        this.kindid = kindid;
        this.kindname = kindname;
    }


    public int getKindid() {
        return kindid;
    }

    public void setKindid(int kindid) {
        this.kindid = kindid;
    }

    public String getKindname() {
        return kindname;
    }

    public void setKindname(String kindname) {
        this.kindname = kindname;
    }

//    public List<Menu> getMenus() {
//        return menus;
//    }
//
//    public void setMenus(List<Menu> menus) {
//        this.menus = menus;
//    }
}
