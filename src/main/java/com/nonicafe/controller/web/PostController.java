package com.nonicafe.controller.web;

import com.nonicafe.constant.PageConstant;
import com.nonicafe.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "PostControllerOfWeb")
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;


    @GetMapping("/list")
    public ModelAndView list(@RequestParam(required = false) Integer page){
        ModelAndView modelAndView = new ModelAndView("web/post/list");
        modelAndView.addObject("postAbstract",postService.findAll(page, PageConstant.LIMIT_POST));
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
