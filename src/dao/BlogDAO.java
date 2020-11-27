package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBConnection;
import dto.BlogDTO;

public class BlogDAO {
	
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



	public BlogDTO blogMaking(BlogDTO blog) {
		String sql = "INSERT INTO BLOG(BLOGNUM,BLOGID,BLOGNAME,BLOGHITS,BLOGIMAGE) VALUES(SEQ_BLOG.NEXTVAL,?,?,0,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, blog.getBlogid());
			pstmt.setString(2, blog.getBlogname());
			pstmt.setString(3, blog.getBlogimage());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return blog;
	}



	public BlogDTO blogView(BlogDTO blog) {
		String sql = "SELECT * FROM BLOG WHERE BLOGID =?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, blog.getBlogid());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				blog = new BlogDTO();
				blog.setBlognum(rs.getInt("BLOGNUM"));
				blog.setBlogid(rs.getString("BLOGID"));
				blog.setBlogname(rs.getString("BLOGNAME"));
				blog.setBlogimage(rs.getString("BLOGIMAGE"));
				blog.setBloghits(rs.getInt("BLOGHITS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		
		return blog;
	}

	public int updateHits(String blogid) {
		String sql = "SELECT SUM(BHITS) FROM BOARD WHERE BWRITER= ?";
		int blogHits = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, blogid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				blogHits = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
	   return blogHits;
	}



	public List<BlogDTO> blogHot() {
		String sql ="SELECT * FROM BLOG ORDER BY BLOGHITS DESC";
		List<BlogDTO> blogList = new ArrayList<BlogDTO>();
		BlogDTO blog = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				blog = new BlogDTO();
				blog.setBlognum(rs.getInt("BLOGNUM"));
				blog.setBlogid(rs.getString("BLOGID"));
				blog.setBlogname(rs.getString("BLOGNAME"));
				blog.setBlogimage(rs.getString("BLOGIMAGE"));
				blog.setBloghits(rs.getInt("BLOGHITS"));
				blogList.add(blog);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		
		return blogList;
	}

	public void hits(int hits, String blogid) {
		System.out.println(hits+"DAO");
		System.out.println(blogid);
		String sql = "UPDATE BLOG SET BLOGHITS = ?  WHERE BLOGID = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, hits);
			pstmt.setString(2, blogid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pstmtClose();
		}
		
	}
























}
