package com.laptrinhjavaweb.dto;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO extends AbstractDTO {
    private String name;
    private Integer price;
    private String priceStr;
    private String description;
    private String imgLink;
    private String imgTitle;
    private String mass;
    private Integer totalView;
    private List<CommentProductDTO> commentProductDTOS = new ArrayList<>();
    private List<ContactDTO> contactDTOS = new ArrayList<>();

    public String getPriceStr() {
        return priceStr;
    }

    public void setPriceStr(String priceStr) {
        this.priceStr = priceStr;
    }

    public Integer getTotalView() {
        return totalView;
    }

    public void setTotalView(Integer totalView) {
        this.totalView = totalView;
    }

    public List<ContactDTO> getContactDTOS() {
        return contactDTOS;
    }

    public void setContactDTOS(List<ContactDTO> contactDTOS) {
        this.contactDTOS = contactDTOS;
    }

    public List<CommentProductDTO> getCommentProductDTOS() {
        return commentProductDTOS;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public void setCommentProductDTOS(List<CommentProductDTO> commentProductDTOS) {
        this.commentProductDTOS = commentProductDTOS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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
