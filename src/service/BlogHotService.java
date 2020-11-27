package service;

import java.util.ArrayList;
import java.util.List;

import dao.BlogDAO;
import dto.BlogDTO;

public class BlogHotService {

	public List<BlogDTO> blogHot() {
		List<BlogDTO> blogList = new ArrayList<BlogDTO>();
		BlogDAO blogDAO = new BlogDAO();
		blogDAO.dbConnection();
		blogList = blogDAO.blogHot();
		blogDAO.dbClose();
		return blogList;
	}

}
