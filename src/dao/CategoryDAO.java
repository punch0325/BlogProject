package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import db.DBConnection;
import dto.CategoryDTO;

public class CategoryDAO {
	
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

	public int categoryMaking(CategoryDTO category) {
		String sql = "INSERT INTO CATEGORY(CNUMBER,CWRITER,CNAME) VALUES(SEQ_C.NEXTVAL,?,?)";
		int makeResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, category.getCwriter());
			pstmt.setString(2, category.getCname());
			makeResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		
		return makeResult;
	}

	public List<CategoryDTO> categoryList(String cwriter) {
		String sql = "SELECT CNAME FROM CATEGORY WHERE CWRITER = ?";
		List<CategoryDTO> cList = new ArrayList<CategoryDTO>();
		CategoryDTO category = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,cwriter);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				category = new CategoryDTO();
				category.setCwriter(cwriter);
				category.setCname(rs.getString("CNAME"));
				cList.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		return cList;
	}
}
