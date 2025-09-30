package com.lgy.board_mysql.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lgy.board_mysql.dao.BoardDAO;
import com.lgy.board_mysql.dto.BoardDTO;

public class BoardContentService implements BoardService {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String boardNo = request.getParameter("boardNo");
		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.contentView(boardNo);
//		dto 객체를 모델에 추가 (뷰에서 꺼내 사용할 수 있음)
		model.addAttribute("content_view", dto);
	}

}
