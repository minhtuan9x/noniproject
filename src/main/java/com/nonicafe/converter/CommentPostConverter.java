package com.nonicafe.converter;

import com.nonicafe.dto.CommentPostDTO;
import com.nonicafe.entity.CommentPostEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentPostConverter {
    @Autowired
    private ModelMapper modelMapper;
    public CommentPostDTO toCommentPostDTO(CommentPostEntity commentPostEntity){
        return modelMapper.map(commentPostEntity,CommentPostDTO.class);
    }
    public CommentPostEntity toCommentPostEntity(CommentPostDTO commentPostDTO){
        return modelMapper.map(commentPostDTO,CommentPostEntity.class);
    }
}
