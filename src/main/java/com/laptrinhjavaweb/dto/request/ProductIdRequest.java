package com.laptrinhjavaweb.dto.request;

import com.laptrinhjavaweb.dto.ContactDTO;

public class ProductIdRequest {
    private Long productId;
    private Integer quantity;


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
