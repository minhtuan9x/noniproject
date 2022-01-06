package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository<VideoEntity,Long> {
    void deleteAll();
    List<VideoEntity> findTop6ByOrderByCreatedDateDesc();
}
