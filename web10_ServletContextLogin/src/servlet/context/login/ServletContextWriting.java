package servlet.context.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextWriting extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap userList;
    private ServletContext cont;
	
	@Override
	public void init() throws ServletException {
		cont = getServletContext();
		userList = new HashMap();
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");
		String userLv = request.getParameter("userLv");
		
		userList.put("userId", userId);
		userList.put("userName", userName);
		userList.put("userPass", userPass);
		userList.put("userLv", userLv);
		
		cont.setAttribute("userList",userList);
		
		out.println("<html><body bgcolor=gray>"); //out. ~ 스트림에 텍스트를 기
		out.println("<b>===========The Communication Servlets==============<br>");
		out.println("사용자의 정보가 ServletContext에 바인딩 되었습니다...</b><p>");
		
		out.println("<a href='SC2'>접속자 명단 보기</a>");
		
	}

}
