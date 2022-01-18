package com.nonicafe.controller.web;

import com.nonicafe.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/video")
public class VideoController {
    @Autowired
    private VideoService videoService;
    @GetMapping
    public ModelAndView getList(@RequestParam(required = false) Integer page){
        ModelAndView modelAndView = new ModelAndView("web/video/list");
        page = page!=null?page:1;
        modelAndView.addObject("videos",videoService.findAll(page));
        return modelAndView;
    }
}
