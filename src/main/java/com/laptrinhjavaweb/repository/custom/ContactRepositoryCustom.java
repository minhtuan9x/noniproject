package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.entity.ContactEntity;

import java.util.List;

public interface ContactRepositoryCustom {
    List<ContactEntity> findAll(Integer status,String name,String date);
}
