package com.project_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@RequestMapping("/board")
	public String board() {
		System.out.println("올~라잇~");
		return "adminBoard";
	}
}
