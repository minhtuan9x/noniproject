package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.dto.PostDTO;
import com.laptrinhjavaweb.entity.PostEntity;
import com.laptrinhjavaweb.repository.custom.PostRepositoryCustom;
import com.laptrinhjavaweb.utils.ValidateInputUtil;

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
        Query query = entityManager.createQuery(sql, PostEntity.class);
        return query.getResultList();
    }

    private String buildQuery(PostDTO postDTO) {
        StringBuilder sql = new StringBuilder("from PostEntity where 1=1");
        if (ValidateInputUtil.isValid(postDTO.getTitle())) {
            sql.append(" and title like '%").append(postDTO.getTitle()).append("%'");
        }
        return sql.toString();
    }
}
