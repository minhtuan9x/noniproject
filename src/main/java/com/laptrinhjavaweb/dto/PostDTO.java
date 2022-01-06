package com.laptrinhjavaweb.dto;

import java.util.ArrayList;
import java.util.List;

public class PostDTO extends AbstractDTO{
    private String title;
    private String imgTitle;
    private String content;
    private String sortContent;
    private Integer totalView;
    private List<CommentPostDTO> commentPostDTOS = new ArrayList<>();

    public List<CommentPostDTO> getCommentPostDTOS() {
        return commentPostDTOS;
    }

    public void setCommentPostDTOS(List<CommentPostDTO> commentPostDTOS) {
        this.commentPostDTOS = commentPostDTOS;
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

    public Integer getTotalView() {
        return totalView;
    }

    public void setTotalView(Integer totalView) {
        this.totalView = totalView;
    }

    public String getSortContent() {
        return sortContent;
    }

    public void setSortContent(String sortContent) {
        this.sortContent = sortContent;
    }
}
