package com.project_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project_1.service.MainService;

@Controller
public class MainController {
	@Autowired
	MainService mainService;
	
	@RequestMapping("/main")
	public String main(Model model) {
		
		model.addAttribute("map", mainService.getContent());
		
		return "index";
	}
}
