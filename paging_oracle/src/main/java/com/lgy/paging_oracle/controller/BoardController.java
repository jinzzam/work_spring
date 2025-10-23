package com.lgy.paging_oracle.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lgy.paging_oracle.dto.BoardDTO;
import com.lgy.paging_oracle.dto.Criteria;
import com.lgy.paging_oracle.dto.PageDTO;
import com.lgy.paging_oracle.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping("/list_old")
	public String list(Model model) {
		log.info("@# list()");
		
		ArrayList<BoardDTO> list = service.list();
		model.addAttribute("list", list);
		return "list";
	}
	
	@RequestMapping("/list")
	public String list(Criteria cri, Model model) {
		log.info("@# list()");
		log.info("@# cri=>"+cri);
		
		ArrayList<BoardDTO> list = service.list(cri);
		int total = service.getTotalCount();
		
		model.addAttribute("list", list);
//		model.addAttribute("pageMaker", new PageDTO(123, cri));
		model.addAttribute("pageMaker", new PageDTO(total, cri));
		return "list";
	}
	
	
	@RequestMapping("/write")
	public String write(@RequestParam HashMap<String, String> param, Model model) {
		log.info("@# write()");
		
		service.write(param);
		
		return "redirect:list";
	}
	
	@RequestMapping("/write_view")
	public String write_view() {
		log.info("@# write_view()");
		
		return "write_view";
	}
	
	
	@RequestMapping("/content_view")
	public String content_view(@RequestParam HashMap<String, String> param, Model model) {
		log.info("@# content_view()");
		
		service.contentView(param);
		BoardDTO dto = service.contentView(param);
		model.addAttribute("content_view", dto);
//		content_view.jsp에서 pageMaker를 가지고 페이징 처리
		model.addAttribute("pageMaker", param);
		
		return "content_view";
	}
	
	
	@RequestMapping("/modify")
//	public String modify(@RequestParam HashMap<String, String> param, Model model) {
//	RedirectAttributes rttr : 쿼리 스트링 뒤에 추가
//	@ModelAttribute("cri") Criteria cri : Criteria 객체를 cri로 받는다
	public String modify(@RequestParam HashMap<String, String> param,
						 @ModelAttribute("cri") Criteria cri,
						 RedirectAttributes rttr) {
		log.info("@# modify()");
		log.info("@# cri=>"+cri);
		
		service.modify(param);
//		페이지 이동 시 뒤에 페이지 번호, 글 개수 추가
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		
		return "redirect:list";
	}
	
	
	@RequestMapping("/delete")
//	public String delete(@RequestParam HashMap<String, String> param, Model model) {
	public String delete(@RequestParam HashMap<String, String> param,
			 			 @ModelAttribute("cri") Criteria cri,
			 			 RedirectAttributes rttr) {
		log.info("@# delete()");
		log.info("@# cri=>"+cri);
		
		service.delete(param);
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		
		return "redirect:list";
	}
	
}
