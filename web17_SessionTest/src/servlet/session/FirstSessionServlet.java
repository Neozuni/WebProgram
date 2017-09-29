package servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FirstSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//1 세션하나 받아온다 
		// console 로 jsession ID 값을 출력 해본다 .
		
		HttpSession session = request.getSession(true);
		System.out.println("JsessionID ::" +session.getId());
		
		//2 폼에서 받은 값이 kosta 라 치고 ... 이 값을 세션에 저장 
		session.setAttribute("name", "KOSTA");
		
		//3 페이지를 forading 방법으로 이동 ..   (SeconfSessionServlet)
		request.getRequestDispatcher("Second").forward(request, response);
		
		
	}
}
