package com.nonicafe.service;

import com.nonicafe.dto.ProductDTO;
import com.nonicafe.dto.response.ProductResponse;

import java.util.List;
import java.util.Map;

public interface ProductService {
    void save(ProductDTO productDTO);
    List<ProductResponse> findAll(Map<String,String> params);
    List<Long> delete(List<Long> productIDs);
    ProductDTO findById(Long id);
    List<ProductResponse> findAll();
}
