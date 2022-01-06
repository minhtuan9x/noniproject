package com.laptrinhjavaweb.entity;

import javax.persistence.*;

@Entity
@Table(name = "productcontact")
public class ProductContactEntity extends BaseEntity {
    @Column
    private Integer quantily;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productid",nullable = false)
    private ProductEntity productEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contactid",nullable = false)
    private ContactEntity contactEntity;

    public Integer getQuantily() {
        return quantily;
    }

    public void setQuantily(Integer quantily) {
        this.quantily = quantily;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public ContactEntity getContactEntity() {
        return contactEntity;
    }

    public void setContactEntity(ContactEntity contactEntity) {
        this.contactEntity = contactEntity;
    }
}
