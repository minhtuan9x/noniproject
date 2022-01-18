package com.nonicafe.service.impl;

import com.nonicafe.converter.ProductConverter;
import com.nonicafe.dto.ProductDTO;
import com.nonicafe.dto.request.ProductRequest;
import com.nonicafe.dto.response.ProductResponse;
import com.nonicafe.entity.ProductEntity;
import com.nonicafe.repository.ProductRepository;
import com.nonicafe.service.ProductService;
import com.nonicafe.utils.ParseValidateUtil;
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
    public List<ProductResponse> findAll(Map<String,String> params) {
        List<ProductResponse> productResponses = new ArrayList<>();
        ProductRequest productRequest = getParams(params);
        productRepository.findAll(productRequest).forEach(item->{
            productResponses.add(productConverter.toProductRespone(item));
        });
        return productResponses;
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

    @Override
    public List<ProductResponse> findAll() {
        List<ProductResponse> productResponses = new ArrayList<>();
        productRepository.getAllByOrderByCreatedDateDesc().forEach(item->{
            productResponses.add(productConverter.toProductRespone(item));
        });
        return productResponses;
    }

    public ProductRequest getParams(Map<String,String> params){
        ProductRequest productRequest = new ProductRequest();
        productRequest.setName(params.get("name"));
        productRequest.setPriceFrom(ParseValidateUtil.parseInt(params.get("priceFrom")));
        productRequest.setPriceTo(ParseValidateUtil.parseInt(params.get("priceTo")));
        return productRequest;
    }

}
