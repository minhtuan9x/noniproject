package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.CommentPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentPostRepository extends JpaRepository<CommentPostEntity,Long> {
    void deleteByIdIn(List<Long> ids);
}
