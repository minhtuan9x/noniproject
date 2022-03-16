package com.nonicafe.controller.web;

import com.nonicafe.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "searchWeb")
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ModelAndView search(@RequestParam(required = false,name = "name") String productName){
        ModelAndView modelAndView = new ModelAndView("web/search/list");
        modelAndView.addObject("product",productService.findByName(productName));
        return modelAndView;
    }

}
