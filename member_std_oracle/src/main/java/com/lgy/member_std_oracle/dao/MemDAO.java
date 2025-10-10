package com.lgy.member_std_oracle.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestParam;

import com.lgy.member_std_oracle.dto.MemDTO;


public interface MemDAO {
	public ArrayList<MemDTO> loginYn(@RequestParam HashMap<String, String> param);
	public void write(@RequestParam HashMap<String, String> param);
	public MemDAO registerOk(@RequestParam HashMap<String, String> param);
}






















