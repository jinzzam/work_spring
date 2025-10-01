package com.lgy.board_jdbc_mysql.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.board_jdbc_mysql.service.BoardListService;
import com.lgy.board_jdbc_mysql.util.Constant;
import com.lgy.board_jdbc_mysql.service.*;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {
	BoardService service;
	public JdbcTemplate template;
	
//	servlet-context.xml 에 있는 template 객체를 저장
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
//		Constant.template 를 dao 에서 사용
		Constant.template = this.template;
	}
	
	//게시판 목록 조회
	@RequestMapping("/list")
	public String list(Model model) {
		log.info("@# list()");
		
		//service(command)단 호출
//		BoardListService service = new BoardListService();
		service = new BoardListService();
		service.execute(model);
		
		return "list";
	}
	
	
	@RequestMapping("/write")
//	request : 뷰에서 값을 받아옴
	public String write(HttpServletRequest request, Model model) {
		log.info("@# write()");
		
//		request 에 boardName, boardTitle, boardContent 값들이 있음
		model.addAttribute("request", request);
		
		//service(command)단 호출
//		BoardWriteService service = new BoardWriteService();
		service = new BoardWriteService();
//		model 에 request 를 담고 있음
		service.execute(model);
		
//		return "list";
//		redirect:list => @RequestMapping("/list") 으로 찾아감
		return "redirect:list";
	}
	
	@RequestMapping("/write_view")
	public String write_view() {
		log.info("@# write_view()");
		
		return "write_view";
	}
	
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		log.info("@# content_view()");
		
		model.addAttribute("request", request);
		
		service = new BoardContentService();
		service.execute(model);
		
		return "content_view";
	}
	
	
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model) {
		log.info("@# modify()");
		
		model.addAttribute("request", request);
		
		service = new BoardModifyService();
		service.execute(model);
		
		return "redirect:list";
	}
	
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		log.info("@# delete()");
		
		model.addAttribute("request", request);
		
		service = new BoardDeleteService();
		service.execute(model);
		
		return "redirect:list";
	}
	
}









