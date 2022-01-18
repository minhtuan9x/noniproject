package com.nonicafe.controller.admin;

import com.nonicafe.service.IntroduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "introduceControllerOfAd")
@RequestMapping("/admin")
public class IntroduceController {
    @Autowired
    private IntroduceService introduceService;

    @GetMapping("/introduce-detail")
    public ModelAndView detail(@RequestParam Long id){
        ModelAndView modelAndView = new ModelAndView("admin/introduce/detail");
        modelAndView.addObject("introduce",introduceService.findOne(id));
        return modelAndView;
    }
}
