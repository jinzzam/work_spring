package com.lgy.item_std_oracle.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestParam;

import com.lgy.item_std_oracle.dto.ItemDTO;



public interface ItemDAO {
	public void write(@RequestParam HashMap<String, String> param);
	public ArrayList<ItemDTO> list();

}






















