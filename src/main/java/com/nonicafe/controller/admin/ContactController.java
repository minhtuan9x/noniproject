package com.nonicafe.controller.admin;

import com.nonicafe.service.ContactService;
import com.nonicafe.utils.ValidateInputUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller(value = "contactControllerOfAd")
@RequestMapping("/admin")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/contact-list")
    public ModelAndView list(@RequestParam(required = false) Integer status,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) String date,
                             @RequestParam(required = false) Integer page) {
        ModelAndView modelAndView = new ModelAndView("admin/contact/list");
        if (Objects.isNull(status) || status != 0 && status != 1 && status != 2 && !ValidateInputUtil.isValid(name) && !ValidateInputUtil.isValid(date)) {
            if (page == null)
                page = 1;
            modelAndView.addObject("contacts", contactService.findAllWithPage(page));
        } else {
            modelAndView.addObject("contacts", contactService.findAll(status, name, date));
        }
        modelAndView.addObject("status", status);
        modelAndView.addObject("name", name);
        modelAndView.addObject("date", date);
        return modelAndView;
    }

    @GetMapping("/contact-detail")
    public ModelAndView detail(@RequestParam(required = false, name = "id") Long contactid) {
        ModelAndView modelAndView = new ModelAndView("admin/contact/detail");
        modelAndView.addObject("contact", contactService.findOne(contactid));
        return modelAndView;
    }
}
