package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberIdCheckService;

@WebServlet("/memberidcheck")
public class MemberIdCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberIdCheckController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	
    	MemberIdCheckService mIdChSer = new MemberIdCheckService();
    	boolean idChResult = mIdChSer.memberIdCheck(request,response);
    	
    	String mid = request.getParameter("mid");
    	if (idChResult == true) {
    		response.sendRedirect("MemberIdCheck.jsp");
    	}else {
    		request.setAttribute("id", mid);
    		RequestDispatcher dispatcher = request.getRequestDispatcher("MemberJoin.jsp");
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
