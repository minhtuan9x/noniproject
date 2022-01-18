package com.nonicafe.repository.custom.impl;

import com.nonicafe.entity.ContactEntity;
import com.nonicafe.repository.custom.ContactRepositoryCustom;
import com.nonicafe.utils.ValidateInputUtil;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ContactRepositoryImpl implements ContactRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public List<ContactEntity> findAll(Integer status, String name,String date) {
        StringBuilder sql = new StringBuilder("FROM ContactEntity WHERE 1=1");
        if(status!=null){
            sql.append(" and status = ").append(status);
        }
        if(ValidateInputUtil.isValid(name)){
            sql.append(" and name like '%").append(name).append("%'");
        }
        if(ValidateInputUtil.isValid(date)){
            sql.append(" and createddate like '%").append(date).append("%'");
        }
        Query query = entityManager.createQuery(sql.toString(),ContactEntity.class);
        return query.getResultList();
    }
}
