package com.lgy.board_jdbc_mysql.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.lgy.board_jdbc_mysql.dto.BoardDTO;
import com.lgy.board_jdbc_mysql.util.Constant;

//DB SQL 처리
public class BoardDAO {
//	DataSource dataSource;
	JdbcTemplate template=null;
	
	public BoardDAO() {
		/*
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/mysql");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		*/
//		Constant.template : 컨트롤러에서 설정됨
		template = Constant.template;
	}
	
	public ArrayList<BoardDTO> list() {
//		3. 방법 1줄
		return (ArrayList<BoardDTO>) template.query("select boardNo, boardName, boardTitle, boardContent, boardDate, boardHit from tbl_board", new BeanPropertyRowMapper(BoardDTO.class));
		/*
		2. 방법 2줄
		String sql="select boardNo, boardName, boardTitle, boardContent, boardDate, boardHit from tbl_board";
		return (ArrayList<BoardDTO>) template.query(sql, new BeanPropertyRowMapper(BoardDTO.class));
		*/
		/*
		//		1. 방법 4줄
		ArrayList<BoardDTO> dtos=null;
		String sql="select boardNo, boardName, boardTitle, boardContent, boardDate, boardHit from tbl_board";
//		query : jdbc template 쿼리 처리
		dtos = (ArrayList<BoardDTO>) template.query(sql, new BeanPropertyRowMapper(BoardDTO.class));
		return dtos;
		*/
		/*
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select boardNo, boardName, boardTitle, boardContent, boardDate, boardHit from tbl_board";
		ArrayList<BoardDTO> dtos=new ArrayList<BoardDTO>();
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int boardNo = rs.getInt("boardNo");
				String boardName = rs.getString("boardName");
				String boardTitle = rs.getString("boardTitle");
				String boardContent = rs.getString("boardContent");
				Timestamp boardDate = rs.getTimestamp("boardDate");
				int boardHit = rs.getInt("boardHit");
				
				BoardDTO dto = new BoardDTO(boardNo, boardName, boardTitle, boardContent, boardDate, boardHit);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return dtos;
		*/
	}
	
	
	public void write(final String boardName, final String boardTitle, final String boardContent) {
//		update : jdbc template으로 insert(PreparedStatementCreator 객체 사용)
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql="insert into tbl_board(boardName, boardTitle"
						+ ", boardContent) values(?,?,?)";
//				con : 메소드 매개변수와 이름 일치
				PreparedStatement pstmt = con.prepareStatement(sql);
//				파라미터 등은 final로 구성
				pstmt.setString(1, boardName);
				pstmt.setString(2, boardTitle);
				pstmt.setString(3, boardContent);
				pstmt.executeUpdate();
				return pstmt;
			}
		});
		
		/*
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="insert into tbl_board(boardName, boardTitle"
				 + ", boardContent) values(?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, boardName);
			pstmt.setString(2, boardTitle);
			pstmt.setString(3, boardContent);
			pstmt.executeUpdate();
			conn = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		*/
	}
	
//	게시글 하나를 리턴하기 위해서 BoardDTO 사용(strID: 글번호)
	public BoardDTO contentView(String strID) {
		//게시글 조회수 올리기
		upHit(strID);
		
		String sql="select boardNo, boardName, boardTitle, boardContent, boardDate, boardHit "
				+ "from tbl_board where boardNo=" + strID;
		return template.queryForObject(sql, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
		/*
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select boardNo, boardName, boardTitle, boardContent, boardDate, boardHit "
				 + "from tbl_board where boardNo=?";
		BoardDTO dto=null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(strID));
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				int boardNo = rs.getInt("boardNo");
				String boardName = rs.getString("boardName");
				String boardTitle = rs.getString("boardTitle");
				String boardContent = rs.getString("boardContent");
				Timestamp boardDate = rs.getTimestamp("boardDate");
				int boardHit = rs.getInt("boardHit");
				
//				하나의 게시글 객체
				dto = new BoardDTO(boardNo, boardName, boardTitle, boardContent, boardDate, boardHit);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return dto;
		*/
	}
	
	//게시글 조회수 올리기
	public void upHit(final String boardNo) {
		String sql="update tbl_board set boardHit=boardHit+1 where boardNo=?";
//		update : sql update(PreparedStatementSetter 객체 사용)
		template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(boardNo));
				
			}
		});
		/*
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="update tbl_board set boardHit=boardHit+1 where boardNo=?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);			
			pstmt.setInt(1, Integer.parseInt(boardNo));
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		*/
	}
	
	public void modify(final String boardNo, final String boardName, final String boardTitle, final String boardContent) {
		String sql="update tbl_board set boardName=?, boardTitle=?, boardContent=? where boardNo=?";
		template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, boardName);
				ps.setString(2, boardTitle);
				ps.setString(3, boardContent);
				ps.setInt(4, Integer.parseInt(boardNo));
			}
		});
		/*
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="update tbl_board set boardName=?, boardTitle=?, boardContent=? where boardNo=?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, boardName);
			pstmt.setString(2, boardTitle);
			pstmt.setString(3, boardContent);
			pstmt.setInt(4, Integer.parseInt(boardNo));
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		*/
	}
	
	
//	게시글 삭제
	public void delete(final String strID) {
		String sql="delete from tbl_board where boardNo=?";
//		update : jdbc template 삭제 처리
		template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(strID));
			}
		});
		
		/*
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="delete from tbl_board where boardNo=?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);			
			pstmt.setInt(1, Integer.parseInt(strID));
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		*/
	}
	
}






















