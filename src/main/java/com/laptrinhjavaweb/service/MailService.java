package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.CommentPostDTO;

public interface MailService {
    void sentMailCommentPost(CommentPostDTO commentPostDTO,Long postId);
}
