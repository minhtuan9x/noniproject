package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.ProductConverter;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.dto.request.ProductRequest;
import com.laptrinhjavaweb.dto.response.ProductRespone;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.repository.ProductRepository;
import com.laptrinhjavaweb.service.ProductService;
import com.laptrinhjavaweb.utils.ParseValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductConverter productConverter;

    @Override
    public void save(ProductDTO productDTO) {
        try {
            productRepository.save(productConverter.toProductEntity(productDTO));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<ProductRespone> findAll(Map<String,String> params) {
        List<ProductRespone> productRespones = new ArrayList<>();
        ProductRequest productRequest = getParams(params);
        productRepository.findAll(productRequest).forEach(item->{
            productRespones.add(productConverter.toProductRespone(item));
        });
        return productRespones;
    }

    @Override
    @Transactional
    public List<Long> delete(List<Long> productIDs) {
        productRepository.deleteByIdIn(productIDs);
        return productIDs;
    }

    @Override
    @Transactional
    public ProductDTO findById(Long id) {
        ProductEntity productEntity = Optional.ofNullable(productRepository.findOne(id)).orElseThrow(()->new NotFoundException("Not found Product"));
        ProductDTO productDTO = productConverter.toProductDTO(productEntity);
        int totalViewCurrent = productEntity.getTotalView();
        productEntity.setTotalView(totalViewCurrent+1);
        productRepository.save(productEntity);
        return productDTO;
    }

    public ProductRequest getParams(Map<String,String> params){
        ProductRequest productRequest = new ProductRequest();
        productRequest.setName(params.get("name"));
        productRequest.setPriceFrom(ParseValidateUtil.parseInt(params.get("priceFrom")));
        productRequest.setPriceTo(ParseValidateUtil.parseInt(params.get("priceTo")));
        return productRequest;
    }

}
