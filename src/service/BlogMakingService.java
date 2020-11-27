package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BlogDAO;
import dto.BlogDTO;


public class BlogMakingService {

	public BlogDTO blogMaking(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String savePath = "D:\\source\\servlet\\_Blogproject\\WebContent\\BlogImages";
		
		MultipartRequest multi = new MultipartRequest(
			    request,
			    savePath,
			    10*1024*1024,
			    "UTF-8",
			    new DefaultFileRenamePolicy()
			);
		
		String blogid = multi.getParameter("blogid");
		String blogname = multi.getParameter("blogname");
		String blogimage = multi.getOriginalFileName((String)multi.getFileNames().nextElement());
		
		BlogDTO blog = new BlogDTO();
		blog.setBlogid(blogid);
		blog.setBlogname(blogname);
		blog.setBlogimage(blogimage);
		
		BlogDAO blogDAO = new BlogDAO();
		blogDAO.dbConnection();
		blog = blogDAO.blogMaking(blog);
		blogDAO.dbClose();
		
		return blog;
	}



}
