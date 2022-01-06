package com.laptrinhjavaweb.controller.web;

import com.laptrinhjavaweb.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/video")
public class VideoController {
    @Autowired
    private VideoService videoService;
    @GetMapping
    public ModelAndView getList(){
        ModelAndView modelAndView = new ModelAndView("web/video/list");
        modelAndView.addObject("videos",videoService.findAll());

        return modelAndView;
    }
}
