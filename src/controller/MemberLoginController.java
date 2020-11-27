package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberLoginService;

@WebServlet("/memberlogin")
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberLoginController() {
        super();
    }

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		MemberLoginService mLoginSer = new MemberLoginService();
		String loginId = mLoginSer.memberLogin(request,response);
		String blogProfile = mLoginSer.profile(request,response);
		HttpSession session = request.getSession();
		if (loginId != null) {
			session.setAttribute("loginId", loginId);
			session.setAttribute("blogProfile",blogProfile);
			response.sendRedirect("MainPage.jsp");
		}else {
			response.sendRedirect("MemberLoginFail.jsp");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
