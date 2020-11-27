package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;
import dto.PageDTO;

public class BoardCategoryService {
	
	private static final int PAGE_LIMIT = 5;
	private static final int BLOCK_LIMIT = 10;
	
	public List<BoardDTO> boardCategory(HttpServletRequest request, HttpServletResponse response) {
		int page = 1;
		if(request.getParameter("page") != null) {
			page =  Integer.parseInt(request.getParameter("page"));
		}
		String bcategory = request.getParameter("bcategory");
		
		BoardDAO bDAO = new BoardDAO();
		bDAO.dbConnection();
		
		int startRow = (page-1)* PAGE_LIMIT + 1;
		int endRow = page * PAGE_LIMIT;
		
		List<BoardDTO> bCategoryList = bDAO.boardCategory(startRow,endRow,bcategory);
		bDAO.dbClose();
		
		return bCategoryList;
	}

	public PageDTO paging2(HttpServletRequest request, HttpServletResponse response) {
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		String bcategory = request.getParameter("bcategory");
		
		BoardDAO bDAO = new BoardDAO();
		bDAO.dbConnection();
		int listCount = bDAO.listCount2(bcategory);
		bDAO.dbClose();
		
		int maxPage = (int)(Math.ceil((double)listCount/PAGE_LIMIT));
		int startPage = (((int)(Math.ceil((double)page/BLOCK_LIMIT))) - 1) * BLOCK_LIMIT + 1;
		int endPage = startPage + BLOCK_LIMIT - 1;
		if (endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageDTO paging = new PageDTO();
		paging.setPage(page);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		paging.setMaxPage(maxPage);
		
		return paging;
	}

}
