package controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BlogDTO;
import service.BlogHotService;

@WebServlet("/bloghot")
public class BlogHotController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BlogHotController() {
        super();
    }

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		List<BlogDTO> blogList = new ArrayList<BlogDTO>();
		BlogHotService blogHotSer = new BlogHotService();
		blogList = blogHotSer.blogHot();
		
		request.setAttribute("blogList", blogList);
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
