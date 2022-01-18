package com.nonicafe.controller.admin;

import com.nonicafe.dto.PostDTO;
import com.nonicafe.service.PostService;
import com.nonicafe.utils.ValidateInputUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller(value = "PostControllerOfAdmin")
@RequestMapping("/admin")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/post-list")
    public ModelAndView postList(@ModelAttribute(name = "modelSearch") PostDTO postDTO, @RequestParam(required = false) Integer page) throws IllegalAccessException {
        ModelAndView modelAndView = new ModelAndView("admin/post/list");
        if (Objects.isNull(page)) page = 1;
        if (ValidateInputUtil.isEmptyObject(postDTO))
            modelAndView.addObject("modelPost", postService.findAll(page, 20));
        else
            modelAndView.addObject("modelPost", postService.findAll(postDTO));
        return modelAndView;
    }

    @GetMapping("/post-edit")
    public ModelAndView postEdit(@RequestParam(name = "id", required = false) Long id) {
        ModelAndView modelAndView = new ModelAndView("admin/post/edit");
        modelAndView.addObject("modelPost", postService.findOne(id));
        return modelAndView;
    }
}
