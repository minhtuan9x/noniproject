package com.nonicafe.dto.response;

import com.nonicafe.dto.AbstractDTO;

import java.util.ArrayList;
import java.util.List;

public class ContactDetailResponse extends AbstractDTO {
    private String name;
    private String phone;
    private String email;
    private String address;
    private String process;
    private String totalPrice;
    private List<ProductContactResponse> productContactResponses = new ArrayList<>();

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

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<ProductContactResponse> getProductContactResponses() {
        return productContactResponses;
    }

    public void setProductContactResponses(List<ProductContactResponse> productContactResponses) {
        this.productContactResponses = productContactResponses;
    }
}
