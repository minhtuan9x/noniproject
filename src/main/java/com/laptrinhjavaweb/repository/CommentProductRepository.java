package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.CommentProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentProductRepository extends JpaRepository<CommentProductEntity,Long> {
}
