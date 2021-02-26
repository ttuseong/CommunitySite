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
import com.project_1.vo.BoardVo;
import com.project_1.vo.EventVo;
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@RequestMapping("/board")
	public String board(Model model, @RequestParam(value="boardPage", required=false, defaultValue="1") int boardPage) {
		model.addAttribute("boardContents", adminService.SelectBoardContent(boardPage));
		return "adminBoard";
	}
	
	@RequestMapping("/boardInsert")
	@ResponseBody
	public Map<String, Object> boardInsert(@RequestBody Map<String, Object> formData) {
		adminService.InsertBoard(formData);
		
		return formData;
	}
	
	@RequestMapping("/boardUpdate")
	@ResponseBody
	public Map<String, Object> BoardUpdate(@RequestBody Map<String, Object> formData) {
		adminService.UpdateBoard(formData);
		
		return formData;
	}
	
	@RequestMapping("/boardDelete")
	@ResponseBody
	public int boardDelete(@RequestBody Map<String, Object> formData) {
		return adminService.DeleteBoard(formData);
	}
	
	@RequestMapping("/event")
	public String event(Model model, @RequestParam(value="eventPage", required=false, defaultValue="1") int eventPage) {
		model.addAttribute("eventContents", adminService.SelectEventContent(eventPage));
		
		return "adminEvent";
	}
	
	@RequestMapping("/eventInsert")
	@ResponseBody
	public Map<String, Object> eventInsert(@RequestParam("eventName") String eventName, @RequestParam("eventLink") String eventLink, @RequestParam("eventImg") MultipartFile eventImg) {
		return adminService.InsertEvent(eventName, eventLink, eventImg);
	}
	
	@RequestMapping("/eventUpdate")
	@ResponseBody
	public Map<String, Object> eventUpdate(@RequestParam("eventNo") int eventNo, @RequestParam("eventName") String eventName, @RequestParam("eventLink") String eventLink, @RequestParam(value="eventImg", required=false) MultipartFile eventImg) {
		System.out.println(eventNo);
		
		return adminService.UpdateEvent(eventNo, eventName, eventLink, eventImg);
	}
	
	@RequestMapping("/eventDelete")
	@ResponseBody
	public int EventDelete(@RequestBody Map<String, Object> formData) {
		
		return adminService.EventDelete(formData);
	}
	
	@RequestMapping("/ad")
	public String ad(Model model, @RequestParam(value="adPage", required=false, defaultValue="1") int adPage) {
		model.addAttribute("adContents", adminService.SelectAdContent(adPage));
		
		return "adminAD";
	}
	
	@RequestMapping("/adInsert")
	@ResponseBody
	public Map<String, Object> adInsert(@RequestParam("adTitle") String adTitle, @RequestParam("adDesc") String adDesc, 
				@RequestParam("adEffect") int adEffect, @RequestParam("adImg") MultipartFile adImg){

		return adminService.adInsert(adTitle, adDesc, adEffect, adImg);
	}
	
	@RequestMapping("/adUpdate")
	@ResponseBody
	public Map<String, Object> adUpdate(@RequestParam("adNo") int adNo, @RequestParam("adTitle") String adTitle, @RequestParam("adDesc") String adDesc, 
			@RequestParam("adEffect") int adEffect, @RequestParam(value="adImg", required=false) MultipartFile adImg){
		
		return adminService.adUpdate(adNo, adTitle, adDesc, adEffect, adImg);
	}
	
	@RequestMapping("/adDelete")
	@ResponseBody
	public int adDelete(@RequestBody Map<String, Object> formData) {
		System.out.println(formData.get("adNo"));
		return adminService.adDelete(formData);
	}
}
