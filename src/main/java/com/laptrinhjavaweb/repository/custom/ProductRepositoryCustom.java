package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.dto.request.ProductRequest;
import com.laptrinhjavaweb.entity.ProductEntity;

import java.util.List;

public interface ProductRepositoryCustom {
    List<ProductEntity> findAll(ProductRequest productRequest);
}
