package com.nonicafe.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/order")
public class OrderController {
    @GetMapping
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("web/order/index");


        return modelAndView;
    }
}
