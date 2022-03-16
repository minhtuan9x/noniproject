package com.nonicafe.controller.admin;

import com.nonicafe.repository.ContactRepository;
import com.nonicafe.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {
	@Autowired
	private ContactService contactService;


	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("admin/home");
		mav.addObject("status",contactService.getStatus());
		return mav;
	}

	@GetMapping("/admin/home-edit")
	public ModelAndView edit(@RequestParam(required = false) Long id){
		ModelAndView modelAndView = new ModelAndView("admin/homepage/detail");

		return modelAndView;
	}

}
