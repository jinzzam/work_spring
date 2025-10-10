package com.lgy.board_std_mysql.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.lgy.board_std_mysql.dto.BoardDTO;

public interface BoardService {
//	public void execute(Model model);
	public ArrayList<BoardDTO> list();
	public void write(HashMap<String, String> param);
	public BoardDTO contentView(HashMap<String, String> param);
	public void modify(HashMap<String, String> param);
	public void delete(HashMap<String, String> param);	
}
