package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

public class MemberIdCheckService {

	public boolean memberIdCheck(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		MemberDAO mDAO = new MemberDAO();
		mDAO.dbConnection();
		boolean idChResult = mDAO.memberIdCheck(mid);
		mDAO.dbClose();
		return idChResult;
	}

}
