package com.lgy.item_mybatis_oracle.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ItemController {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	
//	로그인 화면 이동
	@RequestMapping("/login")
	public String login() {
		log.info("@# login()");
		MemberD
		
		return "login";
	}
	
//	로그인화면->로그인 여부 판단
	@RequestMapping("/login_yn")
	public String login_yn(HttpServletRequest request, Model model) {
		log.info("@# login_yn()");
		
		model.addAttribute("request", request);
		
		service = new MemLoginService();
		int result = service.execute(model);
		
//		아이디와 비밀번호가 일치
		if (result == 1) {
			return "login_ok";
		}
		return "login";
	}

	/*
//	등록 화면 이동
	@RequestMapping("/register")
	public String register() {
		log.info("@# register()");
		
		return "register";
	}
	
	@RequestMapping("/registerOk")
	public String registerOk(HttpServletRequest request, Model model) {
		log.info("@# registerOk()");
		
		model.addAttribute("request", request);
		
		service = new MWriteService();
		service.execute(model);
		
		return "login";
	}
	*/
}









