package com.nonicafe.controller.admin;

import com.nonicafe.service.GoogleDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("/admin")
public class ImageController {
    @Autowired
    private GoogleDriverService googleDriverService;

    @GetMapping("/image-list")
    public ModelAndView list() throws IOException {
        ModelAndView modelAndView = new ModelAndView("admin/image/list");
        modelAndView.addObject("images",googleDriverService.getAll());
        return modelAndView;
    }
}
