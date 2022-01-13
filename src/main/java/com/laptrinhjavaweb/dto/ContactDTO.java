package com.laptrinhjavaweb.dto;

import com.laptrinhjavaweb.dto.request.ProductIdRequest;

import java.util.ArrayList;
import java.util.List;

public class ContactDTO extends AbstractDTO{
    private String name;
    private String phone;
    private String email;
    private String address;
    private Integer status;
    private String captchaResponse;
    private List<ProductIdRequest> productIdRequests = new ArrayList<>();

    public List<ProductIdRequest> getProductIdRequests() {
        return productIdRequests;
    }

    public void setProductIdRequests(List<ProductIdRequest> productIdRequests) {
        this.productIdRequests = productIdRequests;
    }

    public String getCaptchaResponse() {
        return captchaResponse;
    }

    public void setCaptchaResponse(String captchaResponse) {
        this.captchaResponse = captchaResponse;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
