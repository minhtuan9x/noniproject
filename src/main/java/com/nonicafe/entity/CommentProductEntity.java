package com.nonicafe.entity;

import javax.persistence.*;

@Entity
@Table(name = "commentproduct")
public class CommentProductEntity extends BaseEntity {
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private String main;
    @Column
    private String reply;
    @Column(columnDefinition = "integer default 0")
    private Integer status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productid",nullable = false)
    private ProductEntity productEntity;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }
}
