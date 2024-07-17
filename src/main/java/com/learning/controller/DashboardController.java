package com.learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DashboardController {
	
	private static final String DASHBOARD = "dashboard/main";

	@GetMapping({"/","dashboard"})
	public String dashbaord() {
		return DASHBOARD;
	}
	
}
