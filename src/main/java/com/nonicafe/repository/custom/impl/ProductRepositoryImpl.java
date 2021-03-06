package com.nonicafe.repository.custom.impl;

import com.nonicafe.dto.request.ProductRequest;
import com.nonicafe.entity.ProductEntity;
import com.nonicafe.repository.custom.ProductRepositoryCustom;
import com.nonicafe.utils.ValidateInputUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<ProductEntity> findAll(ProductRequest productRequest) {
        String sql = buildSql(productRequest);
        Query query = entityManager.createQuery(sql,ProductEntity.class);
        return query.getResultList();
    }
    public String buildSql(ProductRequest productRequest){
        StringBuilder sql = new StringBuilder();
        sql.append("From ProductEntity where 1 = 1");
        if(ValidateInputUtil.isValid(productRequest.getName())){
            sql.append(" and name like '%").append(productRequest.getName()).append("%'");
        }
        if(ValidateInputUtil.isValid(productRequest.getPriceFrom())){
            sql.append(" and price >= ").append(productRequest.getPriceFrom());
        }
        if(ValidateInputUtil.isValid(productRequest.getPriceTo())){
            sql.append(" and price <= ").append(productRequest.getPriceTo());
        }
        return sql.toString();
    }
}
