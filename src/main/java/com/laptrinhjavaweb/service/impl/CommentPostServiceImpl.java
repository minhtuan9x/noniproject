package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.CommentPostConverter;
import com.laptrinhjavaweb.dto.CommentPostDTO;
import com.laptrinhjavaweb.entity.CommentPostEntity;
import com.laptrinhjavaweb.repository.CommentPostRepository;
import com.laptrinhjavaweb.repository.PostRepository;
import com.laptrinhjavaweb.service.CommentPostService;
import com.laptrinhjavaweb.service.GoogleCaptchaService;
import com.laptrinhjavaweb.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentPostServiceImpl implements CommentPostService {
    @Autowired
    private CommentPostConverter commentPostConverter;
    @Autowired
    private CommentPostRepository commentPostRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private MailService mailService;
    @Autowired
    private GoogleCaptchaService googleCaptchaService;


    @Override
    @Transactional
    public boolean save(CommentPostDTO commentPostDTO,Long id) {
        if(commentPostDTO.getId()!=null){
            CommentPostEntity commentPostEntity = commentPostRepository.findOne(commentPostDTO.getId());
            commentPostEntity.setReply(commentPostDTO.getReply());
            commentPostEntity.setStatus(1);
            commentPostEntity.setPostEntity(postRepository.findOne(id));
            commentPostRepository.save(commentPostEntity);
        }else {
            if(!googleCaptchaService.verifyGoogleCaptcha(commentPostDTO.getCaptchaResponse()))
                return false;
            CommentPostEntity commentPostEntity ;
            commentPostEntity =commentPostConverter.toCommentPostEntity(commentPostDTO);
            commentPostEntity.setStatus(0);
            commentPostEntity.setPostEntity(postRepository.findOne(id));
            commentPostRepository.save(commentPostEntity);
            mailService.sentMailCommentPost(commentPostDTO,id);
        }
        return true;
    }

    @Override
    @Transactional
    public void delete(List<Long> ids) {
        commentPostRepository.deleteByIdIn(ids);
    }
}
