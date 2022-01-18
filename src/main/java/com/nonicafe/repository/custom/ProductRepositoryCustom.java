package com.nonicafe.repository.custom;

import com.nonicafe.dto.request.ProductRequest;
import com.nonicafe.entity.ProductEntity;

import java.util.List;

public interface ProductRepositoryCustom {
    List<ProductEntity> findAll(ProductRequest productRequest);
}
