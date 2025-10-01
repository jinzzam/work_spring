package com.lgy.item_jdbc_oracle.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.item_jdbc_oracle.service.ItemContentService;
import com.lgy.item_jdbc_oracle.service.ItemService;
import com.lgy.item_jdbc_oracle.service.ItemWriteService;
import com.lgy.item_jdbc_oracle.util.Constant;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ItemController {
	ItemService item;
	public JdbcTemplate template;
	
//	servlet-context.xml 에 있는 template 객체를 저장
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
//		Constant.template 를 dao 에서 사용
		Constant.template = this.template;
	}
	
	// 상품 목록 조회
	@RequestMapping("/content_view")
	public String content_view(Model model) {
		log.info("@# content_view()");
		
		item = new ItemContentService();
		item.execute(model);
		
		return "content_view";
	}
	
//	상품 등록
	@RequestMapping("/write_result")
	public String write(HttpServletRequest request, Model model) {
		log.info("@# write_result()");
		
		model.addAttribute("request", request);
		item = new ItemWriteService();
		item.execute(model);
		
		return "write_result";
	}
	
	@RequestMapping("/write_view")
//	request : 뷰에서 값을 받아옴
	public String write_view(HttpServletRequest request, Model model) {
		log.info("@# write_view()");
		
		return "item_write";
	}
	
}
