package service;

import java.util.*;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardHotService {

	public List<BoardDTO> boardHot() {
		List<BoardDTO> bList = new ArrayList<BoardDTO>();
		BoardDAO bDAO = new BoardDAO();
		bDAO.dbConnection();
		bList = bDAO.boardHot();
		bDAO.dbClose();
		return bList;
	}

}
