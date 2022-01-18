package com.nonicafe.repository;

import com.nonicafe.entity.PostEntity;
import com.nonicafe.repository.custom.PostRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends PostRepositoryCustom, JpaRepository<PostEntity,Long> {
    void deleteByIdIn(List<Long> ids);
    List<PostEntity> findTop4ByOrderByCreatedDateDesc();
}
