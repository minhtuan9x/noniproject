package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.CommentPostDTO;
import com.laptrinhjavaweb.dto.CommentProductDTO;
import com.laptrinhjavaweb.entity.ContactEntity;

public interface MailService {
    void sentMailCommentPost(CommentPostDTO commentPostDTO,Long postId);
    void sentMailCommentProduct(CommentProductDTO commentProductDTO, Long productId);
    void sentMailContact(ContactEntity contactEntity);
}
