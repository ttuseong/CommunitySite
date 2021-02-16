package com.project_1.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project_1.service.MainService;

@Controller
public class MainController {
	@Autowired
	MainService mainService;
	
	@RequestMapping("/")
	public String main(Model model, HttpServletResponse response) {

		Cookie cookie = new Cookie("count", "test");
	    cookie.setMaxAge(60*60);
	    cookie.setPath("/");    // 경로 이하에 모두 쿠키 적용
	    response.addCookie(cookie);
	    
		model.addAttribute("map", mainService.getContent());
		
		return "index";
	}
	
	@RequestMapping("/read")
	public String read(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		
		System.out.println(cookies);
		
		return "read";
	}
	
	@RequestMapping("list")
	public String list(@RequestParam("boardNo") int boardNo) {
		System.out.println(boardNo);
			
		return "list";
	}
	
	@RequestMapping("write")
	public String write() {
		System.out.println("글 쓰기");
		
		return "write";
	}
}
