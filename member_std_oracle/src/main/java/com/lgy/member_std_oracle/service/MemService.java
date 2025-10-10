package com.lgy.member_std_oracle.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.lgy.member_std_oracle.dao.MemDAO;
import com.lgy.member_std_oracle.dto.MemDTO;

public interface MemService {
	public ArrayList<MemDTO> loginYn(@RequestParam HashMap<String, String> param);
	public void write(@RequestParam HashMap<String, String> param);
	public String registerOk(@RequestParam HashMap<String, String> param);
}
