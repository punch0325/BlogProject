package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BlogDAO;
import dto.BlogDTO;

public class BlogViewService {

	public BlogDTO blogview(HttpServletRequest request, HttpServletResponse response) {
		String blogid = request.getParameter("blogid");
		
		BlogDTO blog = new BlogDTO();
		blog.setBlogid(blogid);
		
		BlogDAO blogDAO = new BlogDAO();
		blogDAO.dbConnection();
		blog = blogDAO.blogView(blog);
		blog.setBloghits(blogDAO.updateHits(blogid));
		int hits = blog.getBloghits();
		System.out.println(hits);
		blogDAO.hits(hits,blogid);
		blogDAO.dbClose();
		return blog;
		
		
	}
	
}
