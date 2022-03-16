package com.nonicafe.converter;

import com.nonicafe.dto.CommentProductDTO;
import com.nonicafe.entity.CommentProductEntity;
import com.nonicafe.utils.DateUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentProductConverter {
    @Autowired
    private ModelMapper modelMapper;

    public CommentProductDTO toCommentProductDTO(CommentProductEntity commentProductEntity){
        CommentProductDTO commentProductDTO = modelMapper.map(commentProductEntity,CommentProductDTO.class);
        commentProductDTO.setCreateDateStr(DateUtils.toDateStr(commentProductEntity.getCreatedDate()));
        return commentProductDTO;
    }
    public CommentProductEntity toCommentProductEntity(CommentProductDTO commentProductDTO){
        return modelMapper.map(commentProductDTO,CommentProductEntity.class);
    }
}
