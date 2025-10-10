package com.lgy.member_std_oracle.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.lgy.member_std_oracle.dao.MemDAO;
import com.lgy.member_std_oracle.dto.MemDTO;

@Service
public class MemServiceImpl implements MemService{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public ArrayList<MemDTO> loginYn(@RequestParam HashMap<String, String> param) {
		MemDAO dao = sqlSession.getMapper(MemDAO.class);
		ArrayList<MemDTO> dto = dao.loginYn(param);
		return dto;
//		
//		if (param.isEmpty()) {
//			return null;
//		} else {
//			if (param.get("mem_uid").equals(dto.get(0).getMem_pwd())) {
//				return dto;
//			} else {
//				return null;
//			}
//		}
	}
	
	@Override
	public void write(@RequestParam HashMap<String, String> param) {
		MemDAO dao = sqlSession.getMapper(MemDAO.class);
		dao.write(param);
	}

	@Override
	public String registerOk(HashMap<String, String> param) {
		MemDAO dao = sqlSession.getMapper(MemDAO.class);
		dao.write(param);
		return "login";
	}

}
