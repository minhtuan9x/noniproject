package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.dto.CommentPostDTO;
import com.laptrinhjavaweb.dto.PostDTO;
import com.laptrinhjavaweb.entity.PostEntity;
import com.laptrinhjavaweb.repository.PostRepository;
import com.laptrinhjavaweb.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private SimpleMailMessage simpleMailMessage;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private PostRepository postRepository;


    @Override
    public void sentMailCommentPost(CommentPostDTO commentPostDTO, Long postId) {
        PostEntity postEntity = postRepository.findOne(postId);
        simpleMailMessage.setSubject("Bình luận mới trong: " + postEntity.getTitle());
        StringBuilder text = new StringBuilder();
        text
                .append("Bài viết: ").append(postEntity.getTitle()).append("\n")
                .append("Tên: ").append("\n").append(commentPostDTO.getName()).append("\n")
                .append("Số điện thoại: ").append(commentPostDTO.getPhone()).append("\n")
                .append("Email: ").append(commentPostDTO.getEmail()).append("\n")
                .append("Nội dung bình luận: ").append(commentPostDTO.getMain());
        simpleMailMessage.setText(text.toString());
        simpleMailMessage.setSentDate(new Date());
        javaMailSender.send(simpleMailMessage);
    }
}
