package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("/admin")
public class ContactAdminController {
    @Autowired
    private ContactService contactService;
    @GetMapping("/contact-list")
    public ModelAndView list(@RequestParam(required = false) Integer status,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) String date){
        ModelAndView modelAndView = new ModelAndView("admin/contact/list");
        modelAndView.addObject("contacts",contactService.findAll(status,name,date));
        modelAndView.addObject("status",status);
        modelAndView.addObject("name",name);
        modelAndView.addObject("date",date);
        return modelAndView;
    }
    @GetMapping("/contact-detail")
    public ModelAndView detail(@RequestParam(required = false,name = "id") Long contactid){
        ModelAndView modelAndView = new ModelAndView("admin/contact/detail");
        modelAndView.addObject("contact",contactService.findOne(contactid));
        return modelAndView;
    }
}
