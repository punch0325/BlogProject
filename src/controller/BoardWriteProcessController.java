package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardWriteProcessService;

@WebServlet("/boardwriteprocess")
public class BoardWriteProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardWriteProcessController() {
        super();
    }

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	
    	BoardWriteProcessService bWriteProSer = new BoardWriteProcessService();
    	int writeResult = bWriteProSer.boardWrite(request,response);
    	
    	if(writeResult == 1) {
    		response.sendRedirect("boardlist");
    	}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
