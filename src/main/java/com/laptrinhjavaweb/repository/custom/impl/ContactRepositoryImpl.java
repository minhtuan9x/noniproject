package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.entity.ContactEntity;
import com.laptrinhjavaweb.repository.custom.ContactRepositoryCustom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class ContactRepositoryImpl implements ContactRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void setProcessed(Long contactId) {
        try {
            String sql = "Update ContactEntity set status = 1 where id = "+contactId;
            Query query = entityManager.createQuery(sql);
            query.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
