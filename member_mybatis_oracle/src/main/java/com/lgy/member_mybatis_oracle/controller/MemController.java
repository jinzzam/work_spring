package com.lgy.member_mybatis_oracle.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.member_mybatis_oracle.dao.MemDAO;
import com.lgy.member_mybatis_oracle.dto.MemDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemController {
	@Autowired
	private SqlSession sqlSession;
	
//	로그인 화면 이동
	@RequestMapping("/login")
	public String login() {
		log.info("@# login()");
		
		return "login";
	}
	
//	로그인화면->로그인 여부 판단
	@RequestMapping("/login_yn")
	public String login_yn(HttpServletRequest request, Model model) {
		log.info("@# login_yn()");
		MemDAO dao = sqlSession.getMapper(MemDAO.class);
		ArrayList<MemDTO> dtos = 
				dao.loginYn(request.getParameter("mem_uid")
						  , request.getParameter("mem_pwd"));
		
		if (dtos.isEmpty()) {
			return "login";
		} else {
			if (request.getParameter("mem_pwd").equals(dtos.get(0).getMem_pwd())) {
				return "login_ok";
			} else {
				return "login";
			}
		}
		/*
//		아이디와 비밀번호가 일치
		if (result == 1) {
			return "login_ok";
		}
		return "login";
		*/
		
	}

//	등록 화면 이동
	@RequestMapping("/register")
	public String register() {
		log.info("@# register()");
		
		return "register";
	}
	
	@RequestMapping("/registerOk")
	public String registerOk(HttpServletRequest request, Model model) {
		log.info("@# registerOk()");
		
//		model.addAttribute("request", request);
	
		MemDAO dao = sqlSession.getMapper(MemDAO.class);
		
		dao.write(request.getParameter("mem_uid")
				, request.getParameter("mem_pwd")
				, request.getParameter("mem_name"));
		
		return "login";
	}
}
