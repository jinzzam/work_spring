package com.lgy.member_std_oracle.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lgy.member_std_oracle.dto.MemDTO;
import com.lgy.member_std_oracle.service.MemService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemController {
	@Autowired
	private MemService service;
	
//	로그인 화면 이동
	@RequestMapping("/login")
	public String login() {
		log.info("@# login()");
		
		return "login";
	}
	
//	로그인화면->로그인 여부 판단
	@RequestMapping("/login_yn")
	public String login_yn(@RequestParam HashMap<String, String> param, Model model) {
		log.info("@# login_yn()");
		
		ArrayList<MemDTO> dtos = service.loginYn(param);
		if(dtos.isEmpty()) {
			return "login";
		}else {
			if (param.get("mem_pwd").equals(dtos.get(0).getMem_pwd())) {
				return "login_ok";
			}
			return "login";
		}
	}

//	등록 화면 이동
	@RequestMapping("/register")
	public String register() {
		log.info("@# register()");
		
		return "register";
	}
	
	@RequestMapping("/registerOk")
	public String registerOk(@RequestParam HashMap<String, String> param) {
		log.info("@# registerOk()");

		service.write(param);
		return "login";
	}
}
