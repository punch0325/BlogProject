package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardUpdateProcessService {

	public BoardDTO boardUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
String savePath = "D:\\source\\servlet\\_Blogproject\\WebContent\\BlogImages";
		
		MultipartRequest multi = new MultipartRequest(
				request,
				savePath,
				10*1024*1024,
				"UTF-8",
				new DefaultFileRenamePolicy()
				);
		
		HttpSession session = request.getSession();
		String bwriter = (String) session.getAttribute("loginId");
		String btitle = multi.getParameter("btitle");
		String bcontents = multi.getParameter("bcontents");
		String bcategory = multi.getParameter("bcategory");
		String bfile = multi.getOriginalFileName((String)multi.getFileNames().nextElement());
		
		BoardDTO board = new BoardDTO();
		board.setBwriter(bwriter);
		board.setBtitle(btitle);
		board.setBcontents(bcontents);
		board.setBfile(bfile);
		board.setBcategory(bcategory);
		
		BoardDAO bDAO = new BoardDAO();
		bDAO.dbConnection();
		board = bDAO.boardUpdate(board);
		bDAO.dbClose();
		return board;
	}

}
