package com.nonicafe.service;

import com.nonicafe.dto.CommentPostDTO;

import java.util.List;

public interface CommentPostService {
    boolean save(CommentPostDTO commentPostDTO,Long id);
    void delete(List<Long> ids);
}
