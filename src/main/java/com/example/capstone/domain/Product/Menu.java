package com.example.capstone.domain.Product;

import com.example.capstone.domain.Member.Member;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int menuid;

    @Column()
    private String menuname;
    private int price;
    private String ex;
    @CreatedDate
    private LocalDateTime savedTime;
    @LastModifiedDate
    private LocalDateTime modifiedDate;
    private int stock;
    private String origFilename;
    private String filename;
    private String filePath;

    // fetch = FetchType.LAZY 쓰면 외래키 조회 불가 !


//    @JsonBackReference
    // cascade = CascadeType.ALL ( 삭제되면 같이삭제 )
    @ManyToOne()
    @JoinColumn(name = "kindid")
    private Kind kindid;

//    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "MID")
    private Member MID;

    public Menu(String menuname, int price, String ex, LocalDateTime savedTime, int stock, String origFilename, String filename, String filePath, Kind kindid, Member MID){
        this.menuname = menuname;
        this.price = price;
        this.ex = ex;
        this.savedTime = savedTime;
        this.stock = stock;
        this.origFilename = origFilename;
        this.filename = filename;
        this.filePath = filePath;
        this.kindid = kindid;
        this.MID = MID;
    }

    public Menu() { }


    public int getMenuid() {
        return menuid;
    }

    public void setMenuid(int menuid) {
        this.menuid = menuid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public LocalDateTime getSavedTime() {
        return savedTime;
    }

    public void setSavedTime(LocalDateTime savedTime) {
        this.savedTime = savedTime;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Kind getKindid() {
        return kindid;
    }

    public void setKindid(Kind kindid) {
        this.kindid = kindid;
    }

    public Member getMID() {
        return MID;
    }

    public void setMID(Member MID) {
        this.MID = MID;
    }

    // 파일
    public String getOrigFilename() {
        return origFilename;
    }

    public void setOrigFilename(String origFilename) {
        this.origFilename = origFilename;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

}
