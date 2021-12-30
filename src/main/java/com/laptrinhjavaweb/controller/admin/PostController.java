package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.dto.PostDTO;
import com.laptrinhjavaweb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/post-list")
    public ModelAndView postList(@ModelAttribute(name = "modelSearch")PostDTO postDTO){
        ModelAndView modelAndView = new ModelAndView("admin/post/list");
        modelAndView.addObject("modelPost",postService.findAll(postDTO));
        return modelAndView;
    }
    @GetMapping("/post-edit")
    public ModelAndView postEdit(@RequestParam(name = "id",required = false) Long id){
        ModelAndView modelAndView = new ModelAndView("admin/post/edit");
        modelAndView.addObject("modelPost",postService.findOne(id));
        return modelAndView;
    }
}
