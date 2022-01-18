package com.nonicafe.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product/shopcart")
public class ShopCartController {
    @GetMapping
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView("web/shopcart/list");

        return modelAndView;
    }
}
