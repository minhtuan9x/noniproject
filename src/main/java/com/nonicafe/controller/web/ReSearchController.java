package com.nonicafe.controller.web;

import com.nonicafe.service.PostService;
import com.nonicafe.service.ReSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "reSearchControllerOfWeb")
@RequestMapping("/research")
public class ReSearchController {
    @Autowired
    private ReSearchService reSearchService;
    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public ModelAndView detail(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("web/research/detail");
        modelAndView.addObject("research",reSearchService.findOne(id));
        modelAndView.addObject("postByDates",postService.findTop4ByOrderByCreatedDateDesc());
        return modelAndView;
    }
}
