package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.PostDTO;
import com.laptrinhjavaweb.entity.PostEntity;

import java.util.List;

public interface PostService {
    List<PostDTO> findAll();
    List<PostDTO> findAll(PostDTO postDTO);
    PostDTO findOne(Long id);
    PostDTO save(PostDTO postDTO);
    List<Long> delete(List<Long> ids);
    List<PostDTO> findTop4ByOrderByCreatedDateDesc();
}
