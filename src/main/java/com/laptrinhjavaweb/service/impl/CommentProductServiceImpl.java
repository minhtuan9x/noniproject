package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.CommentProductConverter;
import com.laptrinhjavaweb.dto.CommentProductDTO;
import com.laptrinhjavaweb.entity.CommentProductEntity;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.repository.CommentProductRepository;
import com.laptrinhjavaweb.repository.ProductRepository;
import com.laptrinhjavaweb.service.CommentProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentProductServiceImpl implements CommentProductService {
    @Autowired
    private CommentProductRepository commentProductRepository;
    @Autowired
    private CommentProductConverter commentProductConverter;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void save(CommentProductDTO commentProductDTO,Long id) {
        try {
            ProductEntity productEntity = productRepository.findOne(id);
            CommentProductEntity commentProductEntity = commentProductConverter.toCommentProductEntity(commentProductDTO);
            if(commentProductDTO.getId()!=null){
                CommentProductEntity commentProductEntity1 = commentProductRepository.findOne(commentProductDTO.getId());
                commentProductEntity.setName(commentProductEntity1.getName());
                commentProductEntity.setEmail(commentProductEntity1.getEmail());
                commentProductEntity.setPhone(commentProductEntity1.getPhone());
                commentProductEntity.setMain(commentProductEntity1.getMain());
            }
            commentProductEntity.setProductEntity(productEntity);
            commentProductRepository.save(commentProductEntity);
        }catch (Exception e){
            e.printStackTrace();
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
