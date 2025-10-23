package com.lgy.paging_search_oracle.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgy.paging_search_oracle.dao.BoardDAO;
import com.lgy.paging_search_oracle.dto.BoardDTO;
import com.lgy.paging_search_oracle.dto.Criteria;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardServiceImpl implements BoardService{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public ArrayList<BoardDTO> list() {
		
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		ArrayList<BoardDTO> list = dao.list();
		
		return list;
	}
	
	@Override
	public ArrayList<BoardDTO> list(Criteria cri) {
		log.info("@# cri=>" + cri);
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		ArrayList<BoardDTO> list = dao.listWithPaging(cri);
		
		return list;
	}
	
	@Override
	public void write(HashMap<String, String> param) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.write(param);
	}

	@Override
	public BoardDTO contentView(HashMap<String, String> param) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		BoardDTO dto = dao.contentView(param);
		return dto;
	}

	@Override
	public void modify(HashMap<String, String> param) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.modify(param);
	}

	@Override
	public void delete(HashMap<String, String> param) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.delete(param);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		log.info("@# getTotalCount()");
		
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
//		int count = dao.getTotalCount();
		int count = dao.getTotalCount(cri);
		
		return count;
	}


	


}
