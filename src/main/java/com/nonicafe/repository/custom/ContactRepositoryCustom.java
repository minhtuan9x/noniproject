package com.nonicafe.repository.custom;

import com.nonicafe.entity.ContactEntity;

import java.util.List;

public interface ContactRepositoryCustom {
    List<ContactEntity> findAll(Integer status,String name,String date);
}
