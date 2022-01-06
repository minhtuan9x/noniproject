package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.ContactEntity;
import com.laptrinhjavaweb.repository.custom.ContactRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends ContactRepositoryCustom, JpaRepository<ContactEntity,Long> {
//    List<ContactEntity> findByProductEntityId(Long productID);
}
