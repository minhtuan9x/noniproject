package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.dto.response.ProductResponse;
import com.laptrinhjavaweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/product")
public class ProductAPI {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductDTO save(@RequestBody ProductDTO productDTO){
        productService.save(productDTO);
        return productDTO;
    }
    @GetMapping
    public List<ProductResponse> findAll(@RequestParam Map<String,String> params){
        return productService.findAll(params);
    }
    @GetMapping("/{id}")
    public ProductDTO getOne(@PathVariable("id") Long id){
        return productService.findById(id);
    }

    @DeleteMapping
    public List<Long> delete(@RequestBody List<Long> ids){
        return productService.delete(ids);
    }
}
