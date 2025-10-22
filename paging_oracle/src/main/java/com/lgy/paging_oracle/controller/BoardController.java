package com.lgy.paging_oracle.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		model.addAttribute("list", list);
		model.addAttribute("pageMaker", new PageDTO(123, cri));
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
	public String modify(@RequestParam HashMap<String, String> param, Model model) {
		log.info("@# modify()");
		
		service.modify(param);
		
		return "redirect:list";
	}
	
	
	@RequestMapping("/delete")
	public String delete(@RequestParam HashMap<String, String> param, Model model) {
		log.info("@# delete()");
		
		service.delete(param);
		
		return "redirect:list";
	}
	
}
