package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberLoginService {

	public String memberLogin(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
        
		MemberDTO member = new MemberDTO();
		member.setMid(mid);
		member.setMpw(mpw);
		
		MemberDAO mDAO = new MemberDAO();
		mDAO.dbConnection();
		boolean loginResult = mDAO.memberLogin(member);
		
		String loginId = "";
		if (loginResult == true) {
			loginId = mid;
		}else {
			loginId = null;
		}
		mDAO.dbClose();
		
		return loginId;
	}

	public String profile(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		MemberDTO member = new MemberDTO();
		member.setMid(mid);
		
		MemberDAO mDAO = new MemberDAO();
		mDAO.dbConnection();
		boolean profileResult = mDAO.profile(member);
		
		String blogProfile = "";
		if (profileResult == true) {
			blogProfile = member.getMprofile();
		}else {
			blogProfile = null;
		}
		mDAO.dbClose();
		
		return blogProfile;
	}


}
