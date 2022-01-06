package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.PostConverter;
import com.laptrinhjavaweb.dto.PostDTO;
import com.laptrinhjavaweb.entity.PostEntity;
import com.laptrinhjavaweb.repository.PostRepository;
import com.laptrinhjavaweb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostConverter postConverter;
    @Autowired
    private PostRepository postRepository;

    @Override
    public List<PostDTO> findAll() {
        List<PostDTO> postDTOS = new ArrayList<>();
        postRepository.findAll().forEach(item->{
            postDTOS.add(postConverter.toPostDTO(item));
        });
        return postDTOS;
    }

    @Override
    public List<PostDTO> findAll(PostDTO postDTO) {
        List<PostDTO> postDTOS = new ArrayList<>();
        postRepository.findAll(postDTO).forEach(item->{
            postDTOS.add(postConverter.toPostDTO(item));
        });
        return postDTOS;
    }

    @Override
    public PostDTO findOne(Long id) {
        if (id==null)
            return new PostDTO();
        PostEntity postEntity = postRepository.findOne(id);
        postEntity.setTotalView(postEntity.getTotalView()+1);
        postRepository.save(postEntity);
        return id!=null?postConverter.toPostDTO(Optional.ofNullable(postRepository.findOne(id)).orElse(new PostEntity())):new PostDTO();
    }

    @Override
    @Transactional
    public PostDTO save(PostDTO postDTO) {
        PostEntity postEntity = postConverter.toPostEntity(postDTO);
        if(postDTO.getId()!=null){
            PostEntity postEntityFound = Optional.ofNullable(postRepository.findOne(postDTO.getId())).orElse(new PostEntity());
            postEntity.setCreatedBy(postEntityFound.getCreatedBy());
            postEntity.setCreatedDate(postEntityFound.getCreatedDate());
        }
        return postConverter.toPostDTO(postRepository.save(postEntity));
    }

    @Override
    @Transactional
    public List<Long> delete(List<Long> ids) {
        postRepository.deleteByIdIn(ids);
        return ids;
    }

    @Override
    public List<PostDTO> findTop4ByOrderByCreatedDateDesc() {
        List<PostDTO> postDTOS = new ArrayList<>();
        postRepository.findTop4ByOrderByCreatedDateDesc().forEach(item->{
            postDTOS.add(postConverter.toPostDTO(item));
        });
        return postDTOS;
    }
}
