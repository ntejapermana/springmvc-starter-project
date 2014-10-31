package com.duskclouds.habit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {

	@RequestMapping(method = RequestMethod.GET)
	public String indexMethod(ModelMap model) {
		model.addAttribute("message", "Spring MVC Hello World");
		return "/index";
	}
}
