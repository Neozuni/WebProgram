package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CBS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CBS() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		// 한글처리 
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
			
		// PrintWriter 리턴 받고
		PrintWriter out = response.getWriter(); // 메소드가 프린터 라이트 객체를 만듬 ... 웹브라우저로 출력가능
		
		String kisu = request.getParameter("kisu");
		String gender=  request.getParameter("gender");
		
		String[ ] menu = request.getParameterValues("menu");
		
		out.println("<html><body><h2><b>");
		out.println("다음은 "+kisu+" 기 "+gender+" 성들이 좋아하는 메뉴입니다");
		out.println("</b></h2><p>");
		for(String str : menu) {
			out.println("<li>"+str+"</li>");
		}
		out.println("</body></html>");
		out.close();		
	}

}

