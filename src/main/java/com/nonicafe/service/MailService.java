package com.nonicafe.service;

import com.nonicafe.dto.CommentPostDTO;
import com.nonicafe.dto.CommentProductDTO;
import com.nonicafe.entity.ContactEntity;

public interface MailService {
    void sentMailCommentPost(CommentPostDTO commentPostDTO,Long postId);
    void sentMailCommentProduct(CommentProductDTO commentProductDTO, Long productId);
    void sentMailContact(ContactEntity contactEntity);
}
