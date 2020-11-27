package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBConnection;
import dto.MemberDTO;

public class MemberDAO {
	
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



	public boolean memberIdCheck(String mid) {
		String sql = "SELECT MID FROM MEMBER WHERE MID = ?";
		boolean idChResult = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				idChResult = true;
			}else {
				idChResult = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		return idChResult;
	}



	public int memberJoin(MemberDTO member) {
		String sql = "INSERT INTO MEMBER(MID,MPW, MNAME, MBIRTH, MPHONE, MEMAIL, MADDRESS, MPROFILE) VALUES(?,?,?,?,?,?,?,?)";
		int joinResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getMid());
			pstmt.setString(2, member.getMpw());
			pstmt.setString(3, member.getMname());
			pstmt.setString(4, member.getMbirth());
			pstmt.setString(5, member.getMphone());
			pstmt.setString(6, member.getMemail());
			pstmt.setString(7, member.getMaddress());
			pstmt.setString(8, member.getMprofile());
			joinResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		
		return joinResult;
	}



	public boolean memberLogin(MemberDTO member) {
		String sql = "SELECT * FROM MEMBER WHERE MID = ? AND MPW = ?";
		boolean loginResult = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getMid());
			pstmt.setString(2, member.getMpw());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				loginResult = true;
			}else {
				loginResult = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		return loginResult;
	}



	public boolean profile(MemberDTO member) {
		String sql = "SELECT * FROM MEMBER WHERE MID = ?";
	    boolean profileResult = false;
	    try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getMid());
			rs=pstmt.executeQuery();
			if (rs.next()) {
				profileResult = true;
				member.setMprofile(rs.getString("MPROFILE"));
			}else {
				profileResult = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
	    
		return profileResult;
	}

}
