package com.laptrinhjavaweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private String address;
    @Column(columnDefinition = "integer default 0")
    private Integer status;

    @OneToMany(mappedBy = "contactEntity",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<ProductContactEntity> productContactEntities = new ArrayList<>();

    public List<ProductContactEntity> getProductContactEntities() {
        return productContactEntities;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setProductContactEntities(List<ProductContactEntity> productContactEntities) {
        this.productContactEntities = productContactEntities;
    }

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
