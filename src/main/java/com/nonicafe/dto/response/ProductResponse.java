package com.nonicafe.dto.response;

import com.nonicafe.dto.AbstractDTO;

public class ProductResponse extends AbstractDTO {
    private String name;
    private String priceStr;
    private String description;
    private String imgLink;
    private String imgTitle;
    private String mass;
    private Integer totalNewComment;

    public Integer getTotalNewComment() {
        return totalNewComment;
    }

    public void setTotalNewComment(Integer totalNewComment) {
        this.totalNewComment = totalNewComment;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriceStr() {
        return priceStr;
    }

    public void setPriceStr(String priceStr) {
        this.priceStr = priceStr;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public String getImgTitle() {
        return imgTitle;
    }

    public void setImgTitle(String imgTitle) {
        this.imgTitle = imgTitle;
    }
}
