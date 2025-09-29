package com.lgy.board_mysql.dao;

import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

// DB SQL 처리
public class BoardDAO {
	DataSource dataSource;
	public BoardDAO() {
		// dbcp 방식으로 db 연결
		try {
			Context ctx = new InitialContext();
//			dataSource : 조회, 저장, 수정, 삭제 쿼리에 모두 사용 가능
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/mysql");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	// 게시판 목록 조회
//	public ArrayList<E> name() {
//		
//	}
}
