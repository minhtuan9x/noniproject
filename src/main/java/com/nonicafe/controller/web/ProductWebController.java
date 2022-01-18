package com.nonicafe.controller.web;

import com.nonicafe.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product")
public class ProductWebController {
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView("web/product/list");
        modelAndView.addObject("products",productService.findAll());
        return modelAndView;
    }
    @GetMapping("/{id}/detail")
    public ModelAndView detail(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("web/product/detail");
        modelAndView.addObject("product",productService.findById(id));
        return modelAndView;
    }
}
