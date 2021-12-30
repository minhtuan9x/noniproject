package com.laptrinhjavaweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post")
public class PostEntity extends BaseEntity {
    @Column
    private String title;
    @Column(name = "imgtitle")
    private String imgTitle;
    @Column
    private String content;
    @Column(columnDefinition = "integer default 0")
    private Integer totalView;

    @OneToMany(mappedBy = "postEntity",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<CommentPostEntity> commentPostEntities = new ArrayList<>();

    public Integer getTotalView() {
        return totalView;
    }

    public void setTotalView(Integer totalView) {
        this.totalView = totalView;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgTitle() {
        return imgTitle;
    }

    public void setImgTitle(String imgTitle) {
        this.imgTitle = imgTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<CommentPostEntity> getCommentPostEntities() {
        return commentPostEntities;
    }

    public void setCommentPostEntities(List<CommentPostEntity> commentPostEntities) {
        this.commentPostEntities = commentPostEntities;
    }
}
