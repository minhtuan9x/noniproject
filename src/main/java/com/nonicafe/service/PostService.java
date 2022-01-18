package com.nonicafe.service;

import com.nonicafe.dto.AbstractDTO;
import com.nonicafe.dto.PostDTO;

import java.io.IOException;
import java.util.List;

public interface PostService {
    AbstractDTO<PostDTO> findAll(Integer page,Integer limit);
    AbstractDTO<PostDTO> findAll(PostDTO postDTO);
    PostDTO findOne(Long id);
    PostDTO save(PostDTO postDTO) throws IOException;
    List<Long> delete(List<Long> ids);
    List<PostDTO> findTop4ByOrderByCreatedDateDesc();
}
