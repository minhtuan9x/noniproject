package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.CommentPostDTO;

import java.util.List;

public interface CommentPostService {
    boolean save(CommentPostDTO commentPostDTO,Long id);
    void delete(List<Long> ids);
}
