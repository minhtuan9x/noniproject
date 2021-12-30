package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.PostEntity;
import com.laptrinhjavaweb.repository.custom.PostRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends PostRepositoryCustom, JpaRepository<PostEntity,Long> {
    void deleteByIdIn(List<Long> ids);
}
