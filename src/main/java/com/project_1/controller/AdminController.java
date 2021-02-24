package com.project_1.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.project_1.service.AdminService;
import com.project_1.vo.EventVo;
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
		return adminService.DeleteBoard(formData);
	}
	
	@RequestMapping("/event")
	public String event(Model model) {
		model.addAttribute("eventList", adminService.SelectEvent());
		
		return "adminEvent";
	}
	
	@RequestMapping("/eventInsert")
	@ResponseBody
	public Map<String, Object> eventInsert(@RequestParam("eventName") String eventName, @RequestParam("eventLink") String eventLink, @RequestParam("eventImg") MultipartFile eventImg) {
		return adminService.InsertEvent(eventName, eventLink, eventImg);
	}
	
	@RequestMapping("/eventDelete")
	@ResponseBody
	public int EventDelete(@RequestBody Map<String, Object> formData) {
		System.out.println(formData.get("eventNo"));
		
		return adminService.EventDelete(formData);
	}
	
	@RequestMapping("/ad")
	public String ad() {
		return "adminAD";
	}
}
