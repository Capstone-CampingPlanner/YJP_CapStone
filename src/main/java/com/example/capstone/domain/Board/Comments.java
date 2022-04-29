package com.example.capstone.domain.Board;


import com.example.capstone.domain.Member.Member;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int comment_code;

    @Column()
    private String commenttext;
    @CreatedDate
    private LocalDateTime commentdate;

    @ManyToOne()
    @JoinColumn(name = "MID")
    private Member MID;

    public Comments(int comment_code, String commenttext, LocalDateTime commentdate, Member MID){
        this.comment_code = comment_code;
        this.commenttext = commenttext;
        this.commentdate = commentdate;
        this.MID = MID;
    }

    public Comments() {

    }

    public int getComment_code() {
        return comment_code;
    }

    public void setComment_code(int comments_code) {
        this.comment_code = comments_code;
    }

    public String getCommenttext() {
        return commenttext;
    }

    public void setCommenttext(String commenttext) {
        this.commenttext = commenttext;
    }

    public LocalDateTime getCommentdate() {
        return commentdate;
    }

    public void setCommentdate(LocalDateTime commentdate) {
        this.commentdate = commentdate;
    }

    public Member getMID() {
        return MID;
    }

    public void setMID(Member MID) {
        this.MID = MID;
    }
}
