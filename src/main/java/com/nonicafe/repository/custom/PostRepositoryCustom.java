package com.nonicafe.repository.custom;

import com.nonicafe.dto.PostDTO;
import com.nonicafe.entity.PostEntity;

import java.util.List;

public interface PostRepositoryCustom {
    List<PostEntity> findAll(PostDTO postDTO);
}
