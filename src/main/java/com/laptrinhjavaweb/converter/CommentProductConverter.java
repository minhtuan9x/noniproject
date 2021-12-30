package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.CommentProductDTO;
import com.laptrinhjavaweb.entity.CommentProductEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentProductConverter {
    @Autowired
    private ModelMapper modelMapper;

    public CommentProductDTO toCommentProductDTO(CommentProductEntity commentProductEntity){
        return modelMapper.map(commentProductEntity,CommentProductDTO.class);
    }
    public CommentProductEntity toCommentProductEntity(CommentProductDTO commentProductDTO){
        return modelMapper.map(commentProductDTO,CommentProductEntity.class);
    }
}
