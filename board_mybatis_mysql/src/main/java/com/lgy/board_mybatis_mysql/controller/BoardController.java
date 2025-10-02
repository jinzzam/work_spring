package com.lgy.board_mybatis_mysql.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.board_mybatis_mysql.dao.BoardDAO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/list")
	public String list(Model model) {
		log.info("@# list()");
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		model.addAttribute("list", dao.list());
		return "list";
	}
	
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		log.info("@# write()");
		
//		model.addAttribute("request", request);
//		
//		service = new BoardWriteService();
//		service.execute(model);
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.write(request.getParameter("boardName")
				, request.getParameter("boardTitle")
				, request.getParameter("boardContent"));
		
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
		
//		model.addAttribute("request", request);
//		
//		service = new BoardContentService();
//		service.execute(model);
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
//		서비스 단에서 처리했던 것을 컨트롤러 단에서 처리
		model.addAttribute("content_view", dao.contentView(request.getParameter("boardNo")));
		
		return "content_view";
	}
	
	
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model) {
		log.info("@# modify()");
		
//		model.addAttribute("request", request);
//		
//		service = new BoardModifyService();
//		service.execute(model);
		
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
//		서비스 단에서 처리했던 것을 컨트롤러 단에서 처리
		dao.modify(request.getParameter("boardNo")
				, request.getParameter("boardName")
				, request.getParameter("boardTitle")
				, request.getParameter("boardContent"));
		
		return "redirect:list";
	}
	
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		log.info("@# delete()");
		
//		model.addAttribute("request", request);
//		
//		service = new BoardDeleteService();
//		service.execute(model);
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
//		서비스 단에서 처리했던 것을 컨트롤러 단에서 처리
		dao.delete(request.getParameter("boardNo"));
		
		return "redirect:list";
	}
	
}









