package com.nonicafe.service;

import com.nonicafe.dto.AbstractDTO;
import com.nonicafe.dto.VideoDTO;

import java.util.List;

public interface VideoService {
    AbstractDTO<VideoDTO> findAll(Integer page);
    List<VideoDTO> findAll();
    List<VideoDTO> findTop6();
    List<VideoDTO> update();
}
