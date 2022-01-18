package com.nonicafe.converter;

import com.google.api.services.drive.model.File;
import com.nonicafe.constant.UploadConstant;
import com.nonicafe.dto.ImageDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImageConverter {
    @Autowired
    private ModelMapper modelMapper;
    public ImageDTO toImageDTO(File file){
        ImageDTO imageDTO = modelMapper.map(file,ImageDTO.class);
        imageDTO.setViewLink(UploadConstant.URL_SHOW+file.getId());
        return imageDTO;
    }
}
