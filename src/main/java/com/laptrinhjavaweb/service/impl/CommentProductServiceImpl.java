package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.CommentProductConverter;
import com.laptrinhjavaweb.dto.CommentProductDTO;
import com.laptrinhjavaweb.entity.CommentPostEntity;
import com.laptrinhjavaweb.entity.CommentProductEntity;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.repository.CommentProductRepository;
import com.laptrinhjavaweb.repository.ProductRepository;
import com.laptrinhjavaweb.service.CommentProductService;
import com.laptrinhjavaweb.service.GoogleCaptchaService;
import com.laptrinhjavaweb.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentProductServiceImpl implements CommentProductService {
    @Autowired
    private CommentProductRepository commentProductRepository;
    @Autowired
    private CommentProductConverter commentProductConverter;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private MailService mailService;
    @Autowired
    private GoogleCaptchaService googleCaptchaService;

    @Override
    @Transactional
    public boolean save(CommentProductDTO commentProductDTO,Long id) {
        try {
            if(commentProductDTO.getId()!=null){
                CommentProductEntity commentProductEntity = commentProductRepository.findOne(commentProductDTO.getId());
                commentProductEntity.setReply(commentProductDTO.getReply());
                commentProductEntity.setStatus(1);
                commentProductEntity.setProductEntity(productRepository.findOne(id));
                commentProductRepository.save(commentProductEntity);
            }else {
                if(!googleCaptchaService.verifyGoogleCaptcha(commentProductDTO.getCaptchaResponse()))
                    return false;
                CommentProductEntity commentProductEntity ;
                commentProductEntity =commentProductConverter.toCommentProductEntity(commentProductDTO);
                commentProductEntity.setStatus(0);
                commentProductEntity.setProductEntity(productRepository.findOne(id));
                commentProductRepository.save(commentProductEntity);
                mailService.sentMailCommentProduct(commentProductDTO,id);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void delete(Long id) {
        try {
            commentProductRepository.delete(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
