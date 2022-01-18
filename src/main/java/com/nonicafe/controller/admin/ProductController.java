package com.nonicafe.controller.admin;

import com.nonicafe.dto.ProductDTO;
import com.nonicafe.dto.request.ProductRequest;
import com.nonicafe.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/admin")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product-list")
    public ModelAndView productList(@ModelAttribute("modelSearch")ProductRequest productRequest,
                                    @RequestParam Map<String,String> params){
        ModelAndView modelAndView = new ModelAndView("admin/product/list");
        modelAndView.addObject("modelProduct",productService.findAll(params));
        return modelAndView;
    }
    @GetMapping("/product-edit")
    public ModelAndView productEdit(@RequestParam(value = "id",required = false) Long id){
        ModelAndView modelAndView = new ModelAndView("admin/product/edit");
        if(id!=null){
            modelAndView.addObject("modelProduct",productService.findById(id));
        }else {
            modelAndView.addObject("modelProduct",new ProductDTO());
        }

        return modelAndView;
    }
}
