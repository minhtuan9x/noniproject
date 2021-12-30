package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.PostDTO;

import java.util.List;

public interface PostService {
    List<PostDTO> findAll(PostDTO postDTO);
    PostDTO findOne(Long id);
    PostDTO save(PostDTO postDTO);
    List<Long> delete(List<Long> ids);
}
