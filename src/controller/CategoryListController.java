package controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.CategoryDTO;
import service.CategoryListService;

              
@WebServlet("/categorylist")
public class CategoryListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CategoryListController() {
        super();
    }

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		CategoryListService cListSer = new CategoryListService();
		List<CategoryDTO> cList = new ArrayList<CategoryDTO>();
		HttpSession session = request.getSession();
		String cwriter = (String)session.getAttribute("loginId");
		
		cList = cListSer.categoryList(cwriter);
  
		request.setAttribute("cList", cList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("blogview?blogid="+cwriter);
		dispatcher.forward(request, response);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
