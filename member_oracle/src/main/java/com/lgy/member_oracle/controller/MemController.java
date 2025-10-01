package com.lgy.member_oracle.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.member_oracle.dao.MemDAO;
import com.lgy.member_oracle.service.MemLoginService;
import com.lgy.member_oracle.service.MemService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemController {
	MemService member;
	
	@RequestMapping("/login_view")
	public String write_view(HttpServletRequest request, Model model) {
		log.info("@# login_view()");
		
		return "login";
	}
	
	@RequestMapping("/login_result")
	public String result(HttpServletRequest servletRequest, Model model) {
		log.info("@# login_result()");
		
		model.addAttribute("request", servletRequest);
		
		member = new MemLoginService();
		String isOk = member.execute(model);
//		
//		String uid = servletRequest.getParameter("mem_uid");
//		String pwd = servletRequest.getParameter("mem_pwd");
//		
//		MemDAO dao = new MemDAO();
//		
//		model.addAttribute("mem_uid", uid);
//		model.addAttribute("mem_pwd", pwd);
//		String isOk = dao.login(uid, pwd);
		
		if(isOk.equals("Ok")) {
			return "login_ok";
		} else {
			return "redirect:login";
		}
	}
}
