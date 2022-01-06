package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.constant.VideoConstant;
import com.laptrinhjavaweb.dto.VideoDTO;
import com.laptrinhjavaweb.entity.VideoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VideoConverter {
    @Autowired
    private ModelMapper modelMapper;
    public VideoDTO toVideoDTO(VideoEntity videoEntity){
        videoEntity.setLink(VideoConstant.URL_FIRST+videoEntity.getLink());
        return modelMapper.map(videoEntity,VideoDTO.class);
    }
    public VideoEntity toVideoEntity(VideoDTO videoDTO){
        return modelMapper.map(videoDTO,VideoEntity.class);
    }
}
