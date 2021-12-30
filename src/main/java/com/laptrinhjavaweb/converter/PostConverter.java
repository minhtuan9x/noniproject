package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.CommentPostDTO;
import com.laptrinhjavaweb.dto.PostDTO;
import com.laptrinhjavaweb.entity.PostEntity;
import com.laptrinhjavaweb.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostConverter {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CommentPostConverter postConverter;
    @Autowired
    private PostRepository postRepository;
    public PostEntity toPostEntity(PostDTO postDTO){
        PostEntity postEntity = modelMapper.map(postDTO,PostEntity.class);
        if(postEntity.getId()==null){
            postEntity.setTotalView(0);
        }else{
            postEntity.setTotalView(postRepository.findOne(postEntity.getId()).getTotalView());
        }
        return postEntity;
    }
    public PostDTO toPostDTO(PostEntity postEntity){
        PostDTO postDTO = modelMapper.map(postEntity,PostDTO.class);
        List<CommentPostDTO> commentPostDTOS = new ArrayList<>();
        postEntity.getCommentPostEntities().forEach(item->{
            commentPostDTOS.add(postConverter.toCommentPostDTO(item));
        });
        postDTO.setCommentPostDTOS(commentPostDTOS);
        return postDTO;
    }
}