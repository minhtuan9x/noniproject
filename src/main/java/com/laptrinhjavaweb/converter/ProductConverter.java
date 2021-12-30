package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.CommentProductDTO;
import com.laptrinhjavaweb.dto.ContactDTO;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.dto.response.ProductRespone;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductConverter {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CommentProductConverter commentProductConverter;
    @Autowired
    private ContactConverver contactConverver;
    @Autowired
    private ProductRepository productRepository;
    public ProductEntity toProductEntity(ProductDTO productDTO){
        ProductEntity productEntity = modelMapper.map(productDTO,ProductEntity.class);
        if(productEntity.getId()==null)
            productEntity.setTotalView(0);
        else {
            productEntity.setTotalView(productRepository.findOne(productEntity.getId()).getTotalView());
        }
        return productEntity;
    }
    public ProductRespone toProductRespone(ProductEntity productEntity){
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        ProductRespone productRespone = modelMapper.map(productEntity,ProductRespone.class);
        if(productEntity.getPrice()!=null){
            productRespone.setPriceStr(decimalFormat.format(productEntity.getPrice()));
        }
        return productRespone;
    }
    public ProductDTO toProductDTO(ProductEntity productEntity){
        ProductDTO productDTO = modelMapper.map(productEntity,ProductDTO.class);
        List<CommentProductDTO> commentProductDTOList = new ArrayList<>();
        List<ContactDTO> contactDTOS = new ArrayList<>();
        productEntity.getCommentProductEntities().forEach(item->{
            CommentProductDTO commentProductDTO = commentProductConverter.toCommentProductDTO(item);
            commentProductDTOList.add(commentProductDTO);
        });
        productEntity.getContactEntities().forEach(item->{
            ContactDTO contactDTO = contactConverver.toContactDTO(item);
            contactDTOS.add(contactDTO);
        });
        productDTO.setCommentProductDTOS(commentProductDTOList);
        productDTO.setContactDTOS(contactDTOS);
        return productDTO;
    }
}
