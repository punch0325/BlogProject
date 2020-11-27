package service;

import java.util.*;

import dao.CategoryDAO;
import dto.CategoryDTO;

public class CategoryListService {

	public List<CategoryDTO> categoryList(String cwriter) {
		List<CategoryDTO> cList = new ArrayList<CategoryDTO>();
		CategoryDAO cDAO = new CategoryDAO();
		cDAO.dbConnection();
		cList = cDAO.categoryList(cwriter);
		cDAO.dbClose();
		return cList;
	}

}
