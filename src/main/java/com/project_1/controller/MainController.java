package com.project_1.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.project_1.service.MainService;
import com.project_1.vo.ContentVo;

@Controller
public class MainController {
	@Autowired
	MainService mainService;

	//홈으로 이동
	@RequestMapping("/")
	public String main(Model model, HttpSession session) {
		checkMenuSession(session);

		return "index";
	}

	//게시글 목록
	@RequestMapping("list")
	public String list(Model model, @RequestParam("boardNo") int boardNo, HttpSession session,
			@RequestParam(value="cntPage", required=false, defaultValue="1") int cntPage) {
		checkMenuSession(session);
		
		model.addAttribute("listMap", mainService.getContents(boardNo, cntPage));
		
		return "list";
	}

	//게시글 읽기
	@RequestMapping("/read")
	public String read(HttpSession session,Model model,@RequestParam("contentNo") int contentNo) {
		checkMenuSession(session);
		
		model.addAttribute("contentVo", mainService.getContent(contentNo));

		return "read";
	}
	
	//게시글폼을 가져오는데 사용
	@RequestMapping("/writeForm")
	public String writeForm(HttpSession session,Model model ,@RequestParam("boardNo") int boardNo) {
		checkMenuSession(session);

		
		System.out.println(boardNo);
		
		model.addAttribute("boardNo", boardNo);
		
		return "write";
	}
	
	//db에 정장될 내용을 전송하고 목록으로 이동하는 메소드
	@RequestMapping("/write")
	public String write(HttpSession session,Model model ,@ModelAttribute ContentVo contentVo,
			@RequestParam(value="file", required = false) MultipartFile file) {
		checkMenuSession(session);

		mainService.writeContent(contentVo, file);
		
		model.addAttribute("boardNo", contentVo.getBoardNo());
		return "redirect:/list";
	}

	@RequestMapping("/delete")
	@ResponseBody
	public int delete(@RequestBody  Map<String, Object> formData) {
		
		return mainService.delete(formData);
	}
	
	//게시판 내용을 한번만 가져오고 메뉴 이동할 때는 미리 저장된 값을 가져오게 설정
	public void checkMenuSession(HttpSession session) {
		if(session.getAttribute("menu") == null) {
			session.setAttribute("menu", mainService.getBoard());
		}	
	}
}
