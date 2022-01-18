package com.nonicafe.repository;

import com.nonicafe.entity.CommentProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentProductRepository extends JpaRepository<CommentProductEntity,Long> {
}
