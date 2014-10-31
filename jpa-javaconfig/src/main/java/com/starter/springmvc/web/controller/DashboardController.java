package com.starter.springmvc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.starter.springmvc.service.UserAdministrationService;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {	

	@Autowired
	UserAdministrationService userAdministrationService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String indexMethod(ModelMap model) {
		model.addAttribute("users", userAdministrationService.findAllUsers());
		return "/dashboard";
	}
}
