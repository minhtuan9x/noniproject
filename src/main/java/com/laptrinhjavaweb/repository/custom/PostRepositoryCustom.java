package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.dto.PostDTO;
import com.laptrinhjavaweb.entity.PostEntity;

import java.util.List;

public interface PostRepositoryCustom {
    List<PostEntity> findAll(PostDTO postDTO);
}
