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
import service.BoardCategoryService;
              
@WebServlet("/boardcategory")
public class BoardCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardCategoryController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	
    	BoardCategoryService bCategorySer = new BoardCategoryService();
    	List<BoardDTO> bCategoryList = new ArrayList<BoardDTO>();
		PageDTO paging2 = new PageDTO();
	
		bCategoryList = bCategorySer.boardCategory(request,response);
		paging2 = bCategorySer.paging2(request,response);
		
		HttpSession session = request.getSession();
		String blogid = (String) session.getAttribute("loginId");
		String cname = request.getParameter("bcategory");
		
		request.setAttribute("bcList", bCategoryList);
		request.setAttribute("paging", paging2);
		request.setAttribute("cname", cname);
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
