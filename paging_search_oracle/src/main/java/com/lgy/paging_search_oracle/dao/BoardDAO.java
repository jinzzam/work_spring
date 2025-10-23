package com.lgy.paging_search_oracle.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.lgy.paging_search_oracle.dto.BoardDTO;
import com.lgy.paging_search_oracle.dto.Criteria;


public interface BoardDAO {
//	public ArrayList<BoardDTO> list();
//	public void write(final String boardName, final String boardTitle, final String boardContent);
//	public BoardDTO contentView(String strID);
//	public void modify(final String boardNo, final String boardName, final String boardTitle, final String boardContent);
//	public void delete(final String strID);

	public ArrayList<BoardDTO> list();
//	Criteria 객체를 이용해서 페이징 처리
	public ArrayList<BoardDTO> listWithPaging(Criteria cri);
	public void write(HashMap<String, String> param);
	public BoardDTO contentView(HashMap<String, String> param);
	public void modify(HashMap<String, String> param);
	public void delete(HashMap<String, String> param);
	public int getTotalCount(Criteria cri);
}






















