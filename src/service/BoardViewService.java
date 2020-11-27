package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardViewService {

	public BoardDTO boardVeiw(HttpServletRequest request, HttpServletResponse response) {
		int bnumber = Integer.parseInt(request.getParameter("bnumber"));
		
		BoardDAO bDAO = new BoardDAO();
		bDAO.dbConnection();
		BoardDTO board = bDAO.boardView(bnumber);
		bDAO.updateHits(bnumber);
		bDAO.dbClose();
		
		return board;
	}

}
