package com.duskclouds.habit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	

	@RequestMapping(method = RequestMethod.GET)
	public String indexMethod(ModelMap model) {
		return "/dashboard";
	}
}
