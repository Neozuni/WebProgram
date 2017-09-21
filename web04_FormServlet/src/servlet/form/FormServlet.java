package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.filters.SetCharacterEncodingFilter;

public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//  방향성을 고려해서 기능을들 다시 떠올려 봅시다..
		//setCharacterEncoding("utf-8")
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		//1. PrintWriter 리턴받음
		//response.setContentType("text/html;charset=utf-8"); // 한글설정 (설정을 먼저 해야함 PrintWriter 전에) 
		PrintWriter out = response.getWriter(); // 메소드가 프린터 라이트 객체를 만듬 ... 웹브라우저로 출력가능  
				
		//2. 폼에 입력된 값을 받아온다 ... 2개
		String name = request.getParameter("name");
		String addr = request.getParameter("address");
		
		
		//3. 받아온 값을 웹으로 출력함
				/*
				 * 당신의 이름은 kosta 
				 * 당신이 사는곳은 판교.. 
				 */
		
		out.println("<html><body bgcolor='gray'>");
		out.println("당신의 이름은 "+name+"<br>");
		out.println("당신의 주소 "+addr);
		out.println("</body></html>");
		out.close();

	}

}






