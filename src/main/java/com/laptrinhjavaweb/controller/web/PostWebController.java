package com.laptrinhjavaweb.controller.web;

import com.laptrinhjavaweb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/post")
public class PostWebController {
    @Autowired
    private PostService postService;


    @GetMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView("web/post/list");
        modelAndView.addObject("posts",postService.findAll());
        return modelAndView;
    }
    @GetMapping("/{id}/detail")
    public ModelAndView detail(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("web/post/detail");
        modelAndView.addObject("post",postService.findOne(id));
        modelAndView.addObject("postByDates",postService.findTop4ByOrderByCreatedDateDesc());
        return modelAndView;
    }
}
