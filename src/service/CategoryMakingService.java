package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import dto.CategoryDTO;

public class CategoryMakingService {

	public int categoryMaking(HttpServletRequest request, HttpServletResponse response) {
		String cwriter = request.getParameter("cwriter");
		String cname = request.getParameter("cname");

		CategoryDTO category = new CategoryDTO();
		category.setCwriter(cwriter);
		category.setCname(cname);
		
		CategoryDAO cDAO = new CategoryDAO();
		cDAO.dbConnection();
		int makeResult = cDAO.categoryMaking(category);
		cDAO.dbClose();
		
		return makeResult;
	}

}
