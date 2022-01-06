package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.VideoConverter;
import com.laptrinhjavaweb.dto.VideoDTO;
import com.laptrinhjavaweb.entity.VideoEntity;
import com.laptrinhjavaweb.repository.VideoRepository;
import com.laptrinhjavaweb.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private VideoConverter videoConverter;
    @Override
    public List<VideoDTO> findAll() {
        List<VideoDTO> videoDTOS = new ArrayList<>();
        videoRepository.findAll().forEach(item->{
            VideoDTO videoDTO = videoConverter.toVideoDTO(item);
            videoDTOS.add(videoDTO);
        });
        return videoDTOS;
    }

    @Override
    public List<VideoDTO> findTop6() {
        List<VideoDTO> videoDTOS = new ArrayList<>();
        videoRepository.findTop6ByOrderByCreatedDateDesc().forEach(item->{
            VideoDTO videoDTO = videoConverter.toVideoDTO(item);
            videoDTOS.add(videoDTO);
        });
        return videoDTOS;
    }

    @Override
    @Transactional
    public List<VideoDTO> update(List<VideoDTO> videoDTOS) {
        videoRepository.deleteAll();
        List<VideoEntity> videoEntities = new ArrayList<>();
        videoDTOS.forEach(item->{
            VideoEntity videoEntity = videoConverter.toVideoEntity(item);
            videoEntities.add(videoEntity);
        });
        videoRepository.save(videoEntities);
        return videoDTOS;
    }
}
