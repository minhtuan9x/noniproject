package com.laptrinhjavaweb.entity;

import javax.persistence.*;

@Entity
@Table(name = "contact")
public class ContactEntity extends BaseEntity {
    @Column
    private String name;
    @Column
    private String phone;
    @Column
    private String email;
    @Column
    private String need;
    @Column(columnDefinition = "integer default 0")
    private Integer status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productid",nullable = false)
    private ProductEntity productEntity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNeed() {
        return need;
    }

    public void setNeed(String need) {
        this.need = need;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
