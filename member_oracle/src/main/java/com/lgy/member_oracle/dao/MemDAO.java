package com.lgy.member_oracle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class MemDAO {
	DataSource dataSource;
	public MemDAO() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
public String login(String str_uid, String str_pwd) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select mem_uid, mem_pwd from mvc_member where mem_uid = ?";
				  
		MemDAO dao = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,str_uid);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String mem_uid = rs.getString("mem_uid");
				String mem_pwd = rs.getString("mem_pwd");
				
				if(str_pwd.equals(mem_pwd)) {
					return "Ok";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return "";
	}
}
