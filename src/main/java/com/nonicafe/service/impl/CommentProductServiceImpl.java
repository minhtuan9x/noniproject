package com.nonicafe.service.impl;

import com.nonicafe.converter.CommentProductConverter;
import com.nonicafe.dto.CommentProductDTO;
import com.nonicafe.entity.CommentProductEntity;
import com.nonicafe.repository.CommentProductRepository;
import com.nonicafe.repository.ProductRepository;
import com.nonicafe.service.CommentProductService;
import com.nonicafe.service.GoogleCaptchaService;
import com.nonicafe.service.MailService;
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
