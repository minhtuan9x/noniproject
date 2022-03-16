package com.nonicafe.repository;

import com.nonicafe.entity.ContactEntity;
import com.nonicafe.repository.custom.ContactRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends ContactRepositoryCustom, JpaRepository<ContactEntity,Long> {
//    List<ContactEntity> findByProductEntityId(Long productID);
    List<Long> deleteByIdIn(List<Long> ids);
    Integer countByStatus(Integer status);
    Page<ContactEntity> OrderByCreatedDateDesc(Pageable pageable);

}
