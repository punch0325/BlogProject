package controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.BoardHotService;

@WebServlet("/boardhot")
public class BoardHotController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardHotController() {
        super();
    }

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		List<BoardDTO> bList = new ArrayList<BoardDTO>();
		BoardHotService bHotSer = new BoardHotService();
		bList = bHotSer.boardHot();
		
		request.setAttribute("bList", bList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("MainPage.jsp");
		dispatcher.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
