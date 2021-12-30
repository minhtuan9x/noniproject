package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.dto.response.ProductRespone;

import java.util.List;
import java.util.Map;

public interface ProductService {
    void save(ProductDTO productDTO);
    List<ProductRespone> findAll(Map<String,String> params);
    List<Long> delete(List<Long> productIDs);
    ProductDTO findById(Long id);
}
