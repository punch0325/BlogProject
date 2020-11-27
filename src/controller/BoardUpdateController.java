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
import dto.CategoryDTO;
import service.BoardUpdateService;
import service.CategoryListService;
              
@WebServlet("/boardupdate")
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardUpdateController() {
        super();
    }

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
    	BoardUpdateService bUpdateSer = new BoardUpdateService();
    	BoardDTO board = bUpdateSer.boardUpdate(request,response); 
    	
    	CategoryListService cListSer = new CategoryListService();
		List<CategoryDTO> cList = new ArrayList<CategoryDTO>();
		HttpSession session = request.getSession();
		String cwriter = (String)session.getAttribute("loginId");
		cList = cListSer.categoryList(cwriter);
		
    	if(board != null) {
    		request.setAttribute("board", board);
    		request.setAttribute("cList", cList);
    		RequestDispatcher dispatcher = request.getRequestDispatcher("BoardUpdate.jsp");
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
