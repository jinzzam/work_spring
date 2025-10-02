package com.lgy.item_oracle_test.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.lgy.item_oracle_test.dao.ItemDAO;
import com.lgy.item_oracle_test.dto.ItemDTO;


public class ItemContentService implements ItemService{

	@Override
	public void execute(Model model) {
		ItemDAO dao = new ItemDAO();
		ArrayList<ItemDTO> dtos = dao.list();
		model.addAttribute("list", dtos);
	}
}
