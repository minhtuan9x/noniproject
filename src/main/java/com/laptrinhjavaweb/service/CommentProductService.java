package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.CommentProductDTO;

public interface CommentProductService {
    void save(CommentProductDTO commentProductDTO,Long id);
    void delete(Long id);
}
