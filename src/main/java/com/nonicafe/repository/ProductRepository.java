package com.nonicafe.repository;


import com.nonicafe.entity.ProductEntity;
import com.nonicafe.repository.custom.ProductRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends ProductRepositoryCustom, JpaRepository<ProductEntity,Long> {
    void deleteByIdIn(List<Long> ids);
    List<ProductEntity> getAllByOrderByCreatedDateDesc();
}
