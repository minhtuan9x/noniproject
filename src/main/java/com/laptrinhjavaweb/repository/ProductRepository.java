package com.laptrinhjavaweb.repository;


import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.repository.custom.ProductRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends ProductRepositoryCustom, JpaRepository<ProductEntity,Long> {
    void deleteByIdIn(List<Long> ids);
}
