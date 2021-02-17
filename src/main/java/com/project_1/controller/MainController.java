package com.project_1.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

	//홈으로 이동
	@RequestMapping("/")
	public String main(Model model, HttpSession session) {
		checkMenuCookie(session);

		return "index";
	}

	//게시글 목록
	@RequestMapping("list")
	public String list(@RequestParam("boardNo") int boardNo, HttpSession session) {
		System.out.println(boardNo);
		checkMenuCookie(session);


		return "list";
	}

	//게시글 읽기
	@RequestMapping("/read")
	public String read(HttpSession session) {
		checkMenuCookie(session);

		return "read";
	}
	
	//게시글 쓰기
	@RequestMapping("write")
	public String write(HttpSession session) {
		System.out.println("글 쓰기");
		checkMenuCookie(session);


		return "write";
	}

	//게시판 내용을 한번만 가져오고 메뉴 이동할 때는 미리 저장된 값을 가져오게 설정
	public void checkMenuCookie(HttpSession session) {
		if(session.getAttribute("menu") == null) {
			System.out.println("session이 없는 경우");
			session.setAttribute("menu", mainService.getContent());
		} else {
			System.out.println("session이 있는 경우");
		}
		
	}
}
