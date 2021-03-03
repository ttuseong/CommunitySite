package com.project_1.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String board(Model model, @RequestParam(value="boardPage", required=false, defaultValue="1") int boardPage) {
		model.addAttribute("boardContents", adminService.SelectBoardContent(boardPage));
		return "adminBoard";
	}
	
	@RequestMapping(value = "/board", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> boardInsert(@RequestBody Map<String, Object> formData) {
		adminService.InsertBoard(formData);
		
		return formData;
	}
	
	@RequestMapping(value = "/board", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String, Object> BoardUpdate(@RequestBody Map<String, Object> formData) {
		adminService.UpdateBoard(formData);
		
		return formData;
	}
	
	@RequestMapping(value = "/board", method = RequestMethod.DELETE)
	@ResponseBody
	public int boardDelete(@RequestBody Map<String, Object> formData) {
		return adminService.DeleteBoard(formData);
	}
	
	@RequestMapping(value = "/event", method = RequestMethod.GET)
	public String event(Model model, @RequestParam(value="eventPage", required=false, defaultValue="1") int eventPage) {
		model.addAttribute("eventContents", adminService.SelectEventContent(eventPage));
		
		return "adminEvent";
	}
	
	@RequestMapping(value = "/event/{no}", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> eventInsert(@PathVariable("no") int no, @RequestParam(value = "eventNo", required = false, defaultValue = "-1") int eventNo, @RequestParam("eventName") String eventName, @RequestParam("eventLink") String eventLink, @RequestParam("eventImg") MultipartFile eventImg) {
		if(no == 1) {
			return adminService.InsertEvent(eventName, eventLink, eventImg);
		} else {
			return adminService.UpdateEvent(eventNo, eventName, eventLink, eventImg);
		}
		
	}

	@RequestMapping(value = "/event", method = RequestMethod.DELETE)
	@ResponseBody
	public int EventDelete(@RequestBody Map<String, Object> formData) {
		
		return adminService.EventDelete(formData);
	}
	
	@RequestMapping(value = "/ad", method = RequestMethod.GET)
	public String ad(Model model, @RequestParam(value="adPage", required=false, defaultValue="1") int adPage) {
		model.addAttribute("adContents", adminService.SelectAdContent(adPage));
		
		return "adminAD";
	}
	
	@RequestMapping(value = "/ad/{no}", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> adInsert(@PathVariable("no") int no, @RequestParam(value="adNo", required = false, defaultValue = "-1") int adNo, @RequestParam("adTitle") String adTitle, @RequestParam("adDesc") String adDesc, 
				@RequestParam("adEffect") int adEffect, @RequestParam("adImg") MultipartFile adImg){

		if(no == 1) {
			return adminService.adInsert(adTitle, adDesc, adEffect, adImg);
		} else {
			return adminService.adUpdate(adNo, adTitle, adDesc, adEffect, adImg);
		}
	}
	
	@RequestMapping(value = "/ad", method = RequestMethod.DELETE)
	@ResponseBody
	public int adDelete(@RequestBody Map<String, Object> formData) {
		return adminService.adDelete(formData);
	}
}
