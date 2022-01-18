package com.nonicafe.entity;

import javax.persistence.*;

@Entity
@Table(name = "productcontact")
public class ProductContactEntity extends BaseEntity {
    @Column
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productid",nullable = false)
    private ProductEntity productEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contactid",nullable = false)
    private ContactEntity contactEntity;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantily) {
        this.quantity = quantily;
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
