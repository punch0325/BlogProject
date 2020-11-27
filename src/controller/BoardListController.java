package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.BoardDTO;
import dto.PageDTO;
import service.BoardListService;


@WebServlet("/boardlist")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardListController() {
        super();
    }

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<BoardDTO> bList = new ArrayList<BoardDTO>();
		PageDTO paging = new PageDTO();
		BoardListService bListSer = new BoardListService();
		
		bList = bListSer.boardList(request, response);
		paging = bListSer.paging(request, response);
		
		HttpSession session = request.getSession();
		String blogid = (String) session.getAttribute("loginId");
		request.setAttribute("bList", bList);
		request.setAttribute("paging", paging);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("blogview?blogid="+blogid);
		dispatcher.forward(request, response);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
