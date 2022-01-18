package com.nonicafe.repository;

import com.nonicafe.entity.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository<VideoEntity,Long> {
    void deleteAll();
    List<VideoEntity> findTop6ByOrderByCreatedDateDesc();
}
