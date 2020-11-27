package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberJoinService {

	public int memberJoin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String savePath = "D:\\source\\servlet\\_Blogproject\\WebContent\\Profile";
		
		MultipartRequest multi = new MultipartRequest(
			    request,
			    savePath,
			    10*1024*1024,
			    "UTF-8",
			    new DefaultFileRenamePolicy()
			);
		
		String mid = multi.getParameter("mid");
		String mpw = multi.getParameter("mpw");
		String mname = multi.getParameter("mname");
		String mbirth = multi.getParameter("mbirth");
		String mphone = multi.getParameter("mphone");
		String memail = multi.getParameter("memail");
		String maddress = multi.getParameter("maddress");
		String mprofile = multi.getOriginalFileName((String)multi.getFileNames().nextElement());
		
		MemberDTO member = new MemberDTO();
		member.setMid(mid);
		member.setMpw(mpw);
		member.setMname(mname);
		member.setMbirth(mbirth);
		member.setMphone(mphone);
		member.setMemail(memail);
		member.setMaddress(maddress);
		member.setMprofile(mprofile);
		
		MemberDAO mDAO = new MemberDAO();
		mDAO.dbConnection();
		int joinResult = mDAO.memberJoin(member);
		mDAO.dbClose();
		
		return joinResult;
	}

}
