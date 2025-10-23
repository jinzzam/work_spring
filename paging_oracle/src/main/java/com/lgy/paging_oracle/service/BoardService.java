package com.lgy.paging_oracle.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.lgy.paging_oracle.dto.BoardDTO;
import com.lgy.paging_oracle.dto.Criteria;

public interface BoardService {
//	public void execute(Model model);
	public ArrayList<BoardDTO> list();
//	페이징 처리하는 서비스
	public ArrayList<BoardDTO> list(Criteria cri);
	public void write(HashMap<String, String> param);
	public BoardDTO contentView(HashMap<String, String> param);
	public void modify(HashMap<String, String> param);
	public void delete(HashMap<String, String> param);	
	public int getTotalCount();
}
