package com.nonicafe.service;

import com.nonicafe.dto.CommentProductDTO;

public interface CommentProductService {
    boolean save(CommentProductDTO commentProductDTO,Long id);
    void delete(Long id);
}
