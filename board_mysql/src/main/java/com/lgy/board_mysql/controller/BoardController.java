package com.lgy.board_mysql.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {
	// 게시판 목록 조회
	@RequestMapping("/list")
	public void name() {
		log.info("@# list()");
		
		// service(command)단 호출
	}
}
