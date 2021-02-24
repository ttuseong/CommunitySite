package com.project_1.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project_1.service.AdminService;
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@RequestMapping("/board")
	public String board(Model model) {
		model.addAttribute("boardList", adminService.SelectBoard());
		return "adminBoard";
	}
	
	@RequestMapping("/boardInsert")
	@ResponseBody
	public Map<String, Object> boardInsert(@RequestBody Map<String, Object> formData) {
		adminService.InsertBoard(formData);
		
		return formData;
	}
	
	@RequestMapping("/boardDelete")
	@ResponseBody
	public int boardDelete(@RequestBody Map<String, Object> formData) {
		System.out.println(formData.get("boardNo"));
		
		return adminService.DeleteBoard(formData);
	}
	
	@RequestMapping("/event")
	public String event() {
		return "adminEvent";
	}
	
	@RequestMapping("ad")
	public String ad() {
		return "adminAD";
	}
}
