package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBConnection;
import dto.BoardDTO;


public class BoardDAO {
	
	Connection con = null;
	PreparedStatement pstmt = null; 
	ResultSet rs = null;
	
	public void dbConnection() {
		con = DBConnection.getConnection();
	}
	
	public void dbClose() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void pstmtClose() {
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void rsClose() {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int boardWrite(BoardDTO board) {
		String sql = "INSERT INTO BOARD(BNUMBER, BWRITER, BTITLE, BCONTENTS, BDATE, BHITS, BFILE, BCATEGORY) VALUES(SEQ_BOARD.NEXTVAL,?,?,?,SYSDATE,0,?,?)";
		int writeResult =0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getBwriter());
			pstmt.setString(2, board.getBtitle());
			pstmt.setString(3, board.getBcontents());
			pstmt.setString(4, board.getBfile());
			pstmt.setString(5, board.getBcategory());
			writeResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return writeResult;
	}

	public List<BoardDTO> boardList(int startRow, int endRow) {
		String sql = "SELECT * FROM BOARDLIST WHERE RN BETWEEN ? AND ?";
		List<BoardDTO> bList = new ArrayList<BoardDTO>();
		BoardDTO board = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				board = new BoardDTO();
				board.setBnumber(rs.getInt("BNUMBER"));
				board.setBwriter(rs.getString("BWRITER"));
				board.setBtitle(rs.getString("BTITLE"));
				board.setBcontents(rs.getString("BCONTENTS"));
				board.setBdate(rs.getDate("BDATE"));
				board.setBhits(rs.getInt("BHITS"));
				bList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		return bList;
	}

	public int listCount() {
		String sql = "SELECT COUNT(BNUMBER) FROM BOARDLIST";
		int listCount = 0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		return listCount;
	}

	public BoardDTO boardView(int bnumber) {
		String sql ="SELECT * FROM BOARD WHERE BNUMBER = ?";
		BoardDTO board = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bnumber);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				board = new BoardDTO();
				board.setBnumber(rs.getInt("BNUMBER"));
				board.setBwriter(rs.getString("BWRITER"));
				board.setBtitle(rs.getString("BTITLE"));
				board.setBcontents(rs.getString("BCONTENTS"));
				board.setBdate(rs.getDate("BDATE"));
				board.setBhits(rs.getInt("BHITS"));
				board.setBfile(rs.getString("BFILE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		return board;
	}

	public void updateHits(int bnumber) {
		String sql = "UPDATE BOARD SET BHITS = BHITS+1 WHERE BNUMBER =?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bnumber);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
	}

	public List<BoardDTO> boardCategory(int startRow, int endRow, String bcategory) {
		String sql = "SELECT * FROM BOARDLIST WHERE RN BETWEEN ? AND ? AND BCATEGORY=?";
		List<BoardDTO> bCategoryList = new ArrayList<BoardDTO>();
		BoardDTO board = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			pstmt.setString(3, bcategory);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				board = new BoardDTO();
				board.setBnumber(rs.getInt("BNUMBER"));
				board.setBwriter(rs.getString("BWRITER"));
				board.setBtitle(rs.getString("BTITLE"));
				board.setBcontents(rs.getString("BCONTENTS"));
				board.setBdate(rs.getDate("BDATE"));
				board.setBhits(rs.getInt("BHITS"));
				board.setBcategory(rs.getString("BCATEGORY"));
				bCategoryList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		return bCategoryList;
	}

	public int listCount2(String bcategory) {
		String sql = "SELECT COUNT(BNUMBER) FROM BOARDLIST WHERE BCATEGORY=?";
		int listCount = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bcategory);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		return listCount;
	}

	public List<BoardDTO> boardHot() {
		String sql = "SELECT * FROM BOARD ORDER BY BHITS DESC";
		List<BoardDTO> bList = new ArrayList<BoardDTO>();
		BoardDTO board = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				board = new BoardDTO();
				board.setBnumber(rs.getInt("BNUMBER"));
				board.setBwriter(rs.getString("BWRITER"));
				board.setBtitle(rs.getString("BTITLE"));
				board.setBcontents(rs.getString("BCONTENTS"));
				board.setBdate(rs.getDate("BDATE"));
				board.setBhits(rs.getInt("BHITS"));
				board.setBcategory(rs.getString("BCATEGORY"));
				bList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		
		return bList;
	}

	public BoardDTO boardUpdate(BoardDTO board) {
		String sql = "UPDATE BOARD SET BTITLE = ?, BCONTENTS = ? , BFILE = ? WHERE BNUMBER = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,board.getBtitle());
			pstmt.setString(2,board.getBcontents());
			pstmt.setString(3,board.getBfile());
			pstmt.setInt(4,board.getBnumber());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		
		return board;
	}

	public int boardDelete(int bnumber) {
		String sql = "DELETE BOARD WHERE BNUMBER = ?";
		int deleteResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bnumber);
			deleteResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return deleteResult;
	}



}
