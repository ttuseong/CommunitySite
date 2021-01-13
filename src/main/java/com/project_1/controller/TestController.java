package com.project_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project_1.service.TestService;

@Controller
@RequestMapping("/")
public class TestController {
	@Autowired
	TestService testService;
	
	@RequestMapping("/test")
	public String test() {
		testService.test();
		return "test";
	}
}
