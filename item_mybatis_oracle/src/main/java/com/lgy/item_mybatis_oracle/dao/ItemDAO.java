package com.lgy.item_mybatis_oracle.dao;

import java.util.ArrayList;

import com.lgy.item_mybatis_oracle.dto.ItemDTO;


//public class BoardDAO {
public interface ItemDAO {
	public ArrayList<ItemDTO> list();
	public void write(final String name, final int price, final String description);
	public ItemDTO contentView(String strName);

		/*
	JdbcTemplate template=null;
	
	public BoardDAO() {
		template = Constant.template;
	}
	
	public ArrayList<BoardDTO> list() {
		return (ArrayList<BoardDTO>) template.query("select boardNo, boardName, boardTitle, boardContent, boardDate, boardHit from tbl_board", new BeanPropertyRowMapper(BoardDTO.class));
	}
	
	
	public void write(final String boardName, final String boardTitle, final String boardContent) {
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql="insert into tbl_board(boardName, boardTitle"
						+ ", boardContent) values(?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, boardName);
				pstmt.setString(2, boardTitle);
				pstmt.setString(3, boardContent);
				pstmt.executeUpdate();
				return pstmt;
			}
		});
		
	}
	
	public BoardDTO contentView(String strID) {
		upHit(strID);
		
		String sql="select boardNo, boardName, boardTitle, boardContent, boardDate, boardHit "
				+ "from tbl_board where boardNo=" + strID;
		return template.queryForObject(sql, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
	}
	
	public void upHit(final String boardNo) {
		String sql="update tbl_board set boardHit=boardHit+1 where boardNo=?";
		template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(boardNo));
				
			}
		});
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
	}
	
	
	public void delete(final String strID) {
		String sql="delete from tbl_board where boardNo=?";
		template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(strID));
			}
		});
	}
	*/
}






















