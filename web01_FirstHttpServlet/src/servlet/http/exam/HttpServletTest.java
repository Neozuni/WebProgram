package servlet.http.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;       
   
    public HttpServletTest() {
       
    }
    //기본
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}
	//post방식을 쓰겠다...라고 지정할때만 구동됨...html 파일에서 한다
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//실제 로직은 여기서 작성...
		
		//웹 브라우저로 응답하기 위해서는 PrintWriter 객체를 하나 리턴
		//PrintWriter 객체에  브라우저로 출력하는 기능..println()
		//오늘은 목요일입니다..
		
		response.setContentType("text/html;charset=utf-8"); // 한글설정 (설정을 먼저 해야함 PrintWriter 전에) 
		PrintWriter out = response.getWriter(); // 메소드가 프린터 라이트 객체를 만듬 ... 웹브라우저로 출력가능 
		
		
		
		out.println("<html><body bgcolor='gray'>");
		out.println("<h2> 오늘은 목요일 입니다.  !!~~~</h2>");
		out.println("</body></html>");
		out.close();
		
	
		 
		
	}
}
/*
 * 1. 
 * Tomcat_Home>webapps>ContextPath(Project)>WEB-INF>classes>servlet>
 * >http>exam>HttpServletTest.class파일을 직접 배포
 * 
 * 2. 서버 restart
 * 
 * 3. 웹 브라우저 주소창에
 * http://127.0.0.1:8888/web01_FirstHttpServlet/HttpServletTest
 */











