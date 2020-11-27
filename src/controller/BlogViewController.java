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

import dto.BlogDTO;
import dto.BoardDTO;
import dto.CategoryDTO;
import dto.PageDTO;
import service.BlogViewService;
import service.BoardCategoryService;
import service.BoardListService;
import service.CategoryListService;

@WebServlet("/blogview")
public class BlogViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BlogViewController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	
    	BlogViewService bViewSer = new BlogViewService();
    	BlogDTO blog = bViewSer.blogview(request,response);
    	
    	BoardListService bListSer = new BoardListService();
    	List<BoardDTO> bList = new ArrayList<BoardDTO>();
    	PageDTO paging = new PageDTO();
    	bList = bListSer.boardList(request, response);
    	paging = bListSer.paging(request, response);
    	
    	CategoryListService cListSer = new CategoryListService();
    	List<CategoryDTO> cList = new ArrayList<CategoryDTO>();
		HttpSession session = request.getSession();
		String cwriter = (String)session.getAttribute("loginId");
		cList = cListSer.categoryList(cwriter);
		
    	BoardCategoryService bCategorySer = new BoardCategoryService();
    	List<BoardDTO> bCategoryList = new ArrayList<BoardDTO>();
		PageDTO paging2 = new PageDTO();
		bCategoryList = bCategorySer.boardCategory(request,response);
		paging2 = bCategorySer.paging2(request,response);
		
    	if(blog != null) {
            request.setAttribute("blog", blog);
    		request.setAttribute("cList", cList);
    		request.setAttribute("bList", bList);
    		request.setAttribute("paging", paging);
    		request.setAttribute("bcList", bCategoryList);
    		request.setAttribute("paging", paging2);
    		RequestDispatcher dispatcher = request.getRequestDispatcher("BlogView.jsp");
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
