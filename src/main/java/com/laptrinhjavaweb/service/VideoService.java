package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.VideoDTO;

import java.util.List;

public interface VideoService {
    List<VideoDTO> findAll();
    List<VideoDTO> findTop6();
    List<VideoDTO> update(List<VideoDTO> videoDTOS);
}
