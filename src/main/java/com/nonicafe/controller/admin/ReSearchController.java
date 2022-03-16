package com.nonicafe.controller.admin;

import com.nonicafe.dto.ReSearchDTO;
import com.nonicafe.service.ReSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "reSearchControllerOfAd")
@RequestMapping("/admin")
public class ReSearchController {
    @Autowired
    private ReSearchService reSearchService;


    @GetMapping("/research-list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView("admin/research/list");
        modelAndView.addObject("researches",reSearchService.findAll());
        return modelAndView;
    }
    @GetMapping("/research-edit")
    public ModelAndView edit(@RequestParam(required = false) Long id){
        ModelAndView modelAndView = new ModelAndView("admin/research/edit");
        modelAndView.addObject("research",id!=null?reSearchService.findOne(id):new ReSearchDTO());
        return modelAndView;
    }
}
