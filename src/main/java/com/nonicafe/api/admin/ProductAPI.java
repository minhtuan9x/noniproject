package com.nonicafe.api.admin;

import com.nonicafe.dto.ProductDTO;
import com.nonicafe.dto.response.ProductResponse;
import com.nonicafe.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/product")
public class ProductAPI {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Void> save(@ModelAttribute(name = "modelProduct") ProductDTO productDTO){
        productService.save(productDTO);
        return ResponseEntity.noContent().build();
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
