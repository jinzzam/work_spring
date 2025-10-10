package com.lgy.board_std_mysql.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgy.board_std_mysql.dao.BoardDAO;
import com.lgy.board_std_mysql.dto.BoardDTO;

//@Service("BoardService")
@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public ArrayList<BoardDTO> list() {
//		BoardDAO dao = new BoardDAO();
//		ArrayList<BoardDTO> dtos = dao.list();
//		model.addAttribute("list", dtos);
		
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		ArrayList<BoardDTO> list = dao.list();
		
		return list;
	}

	@Override
	public void write(HashMap<String, String> param) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
//		dao.write(request.getParameter("boardName")
//				, request.getParameter("boardTitle")
//				, request.getParameter("boardContent"));
		dao.write(param);
	}

	@Override
	public BoardDTO contentView(HashMap<String, String> param) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
//		dao.contentView(request.getParameter("boardNo"));
		BoardDTO dto = dao.contentView(param);
		return dto;
	}

	@Override
	public void modify(HashMap<String, String> param) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
//		dao.modify(request.getParameter("boardNo")
//				, request.getParameter("boardName")
//				, request.getParameter("boardTitle")
//				, request.getParameter("boardContent"));
		dao.modify(param);
	}

	@Override
	public void delete(HashMap<String, String> param) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
//		dao.delete(request.getParameter("boardNo"));
		dao.delete(param);
	}

}
