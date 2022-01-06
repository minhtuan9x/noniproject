package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class VideoNoniController {
    @Autowired
    private VideoService videoService;
    @GetMapping("/video-list")
    public ModelAndView videoList(){
        ModelAndView modelAndView = new ModelAndView("admin/video/list");
        modelAndView.addObject("videos",videoService.findAll());
        return modelAndView;
    }
}
