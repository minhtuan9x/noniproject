package com.nonicafe.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class ProductEntity extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Integer price;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(name = "imglink")
    private String imgLink;
    @Column(name = "imgtitle")
    private String imgTitle;
    @Column
    private String mass;
    @Column(columnDefinition = "integer default 0")
    private Integer totalView;

    @OneToMany(mappedBy = "productEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CommentProductEntity> commentProductEntities = new ArrayList<>();

    @OneToMany(mappedBy = "productEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductContactEntity> productContactEntities = new ArrayList<>();

    public List<ProductContactEntity> getProductContactEntities() {
        return productContactEntities;
    }

    public void setProductContactEntities(List<ProductContactEntity> productContactEntities) {
        this.productContactEntities = productContactEntities;
    }

    public Integer getTotalView() {
        return totalView;
    }

    public void setTotalView(Integer totalView) {
        this.totalView = totalView;
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

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
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


    public List<CommentProductEntity> getCommentProductEntities() {
        return commentProductEntities;
    }

    public void setCommentProductEntities(List<CommentProductEntity> commentProductEntities) {
        this.commentProductEntities = commentProductEntities;
    }
}
