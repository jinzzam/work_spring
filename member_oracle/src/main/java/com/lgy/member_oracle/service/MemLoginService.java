package com.lgy.member_oracle.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lgy.member_oracle.dao.MemDAO;


public class MemLoginService implements MemService{

	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String mem_uid = request.getParameter("mem_uid");
		String mem_pwd = request.getParameter("mem_pwd");
		
		MemDAO dao = new MemDAO();
		String isOk = dao.login(mem_uid, mem_pwd);
		model.addAttribute("mem_uid", mem_uid);
		model.addAttribute("mem_pwd", mem_pwd);
		return isOk;
	}
	
}
