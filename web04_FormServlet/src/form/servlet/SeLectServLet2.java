package form.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SeLectServLet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*
	 * 한글처리..양방향
	 * PrintWriter 리턴 받고
	 * 폼에 입력된 모든 값을 받아서::getParameter() | getParameterNames()
	 * 웹브라우저로 출력
	 * 
	 */
	
	// 한글처리 
	response.setContentType("text/html;charset=utf-8");
	request.setCharacterEncoding("utf-8");
		
	// PrintWriter 리턴 받고
	PrintWriter out = response.getWriter(); // 메소드가 프린터 라이트 객체를 만듬 ... 웹브라우저로 출력가능
	

// getParameter() 사용 폼에 입력된 모든 값을 받는다 ...
//	String id = request.getParameter("myId");
//	String pw = request.getParameter("myPass");
//	String hb = request.getParameter("hobby");
//	
//	//웹으로 출력 한다 .. 
//	out.println("<html><body bgcolor='gray'>");
//	out.println("ID :: "+id+"<br>");
//	out.println("Password :: "+pw+"<br>");
//	out.println("Hobby :: "+hb);
//	out.println("</body></html>");
//	out.close();
	
//getParameterNames() 사용 
	Enumeration<String> en=request.getParameterNames();
	while(en.hasMoreElements()) {
		String name = en.nextElement();
		String value = request.getParameter(name);
		out.println("<li>"+name+"  :: "+value+"</li><br>");
	}
	out.close();
	
		
	}

}
