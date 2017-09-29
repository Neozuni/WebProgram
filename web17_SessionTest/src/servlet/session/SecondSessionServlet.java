package servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecondSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		HttpSession session  = request.getSession(false);
		if(session.getAttribute("name") != null) {
			String name = (String)session.getAttribute("name");
			out.println("SESSION BINDING Name :: "+name+"<br>");
			out.println("JSESSIONID VALUE :: "+session.getId());
			out.println("<hr>");
			out.println("<a href='Third'>ThirdSessionServlet GoGo</a>");
		}
		/*
		 * 기존에 만들어진 세션을 이어서 사용한다.(받아온다)
		 * 이때 세션에 바인딩된 값이 null 이 아니라면,
		 * 그 값을 찾아와서
		 * 출력(이때 값, jsessionid)
		 * 페이지 이동...a 태그로 이동...Thrd로 이동
		 */
	}

}















