package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.BoardViewService;


@WebServlet("/boardview")
public class BoardViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardViewController() {
        super();
    }

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
    	BoardViewService bViewSer = new BoardViewService();
    	BoardDTO board = new BoardDTO();
    	board = bViewSer.boardVeiw(request, response);
    	
//    	HttpSession session = request.getSession();
//		String blogid = (String) session.getAttribute("loginId");
    	if (board != null) {
    		request.setAttribute("board", board);
    		RequestDispatcher dispatcher = request.getRequestDispatcher("BoardView.jsp");
    		dispatcher.forward(request, response);
    	}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
