package com.lgy.item_oracle.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.item_oracle.service.ItemContentService;
import com.lgy.item_oracle.service.ItemService;
import com.lgy.item_oracle.service.ItemWriteService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ItemController {
	ItemService item;
	
	// 게시판 목록 조회
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		log.info("@# list()");
		
		// service(command)단 호출
		model.addAttribute("request", request);
		item = new ItemContentService();
		item.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping("/write_result")
	public String write_result(Model model) {
		log.info("@# write_result()");
		
		// service(command)단 호출
		item = new ItemContentService();
		item.execute(model);
		
		return "write_result";
	}

	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		log.info("@# write()");
		
		model.addAttribute("request", request);
		item = new ItemWriteService();
		item.execute(model);
		
		return "write_result";
	}
	
	@RequestMapping("/write_view")
//	request : 뷰에서 값을 받아옴
	public String write_view(HttpServletRequest request, Model model) {
		log.info("@# write_view()");
		
		model.addAttribute("request", request);
		// service(command)단 호출
		item = new ItemContentService();
//		model에 request를 담고 있음
		item.execute(model);
		
		return "write_result";
	}
	
	@RequestMapping("/content_view")
//	request : 뷰에서 값을 받아옴
	public String content_view(HttpServletRequest request, Model model) {
		log.info("@# content_view()");
		
		item = new ItemContentService();
//		model에 request를 담고 있음
		item.execute(model);
		
		return "content_view";
	}
}
