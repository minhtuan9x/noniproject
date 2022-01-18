package com.nonicafe.repository.custom.impl;

import com.nonicafe.dto.PostDTO;
import com.nonicafe.entity.PostEntity;
import com.nonicafe.repository.custom.PostRepositoryCustom;
import com.nonicafe.utils.ValidateInputUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class PostRepositoryImpl implements PostRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<PostEntity> findAll(PostDTO postDTO) {
        String sql = buildQuery(postDTO);
        Query query = entityManager.createNativeQuery(sql, PostEntity.class);
        return query.getResultList();
    }

    private String buildQuery(PostDTO postDTO) {
        StringBuilder sql = new StringBuilder("Select * from post where 1=1");
        if (ValidateInputUtil.isValid(postDTO.getTitle())) {
            sql.append(" and title like '%").append(postDTO.getTitle()).append("%'");
        }
        return sql.toString();
    }
}
