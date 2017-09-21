package servlet.context;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.group.Response;

public class ServletContextWriting extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap userList;
	private ServletContext cont;
       
	@Override
	public void init() throws ServletException {
		/*
		 * userList 를 생성
		 * cont 를 리턴받아옴
		 * 
		 */
		System.out.println("init() call...");
		cont=getServletContext();
		System.out.println("ServletContext...returning...");
		userList = new HashMap();
		System.out.println("Make user list...");
		
		// ServletContext 의 getInitParameter() 를 이용해서 받아온 값들을 콘솔로 출력
		
		//cont.getInitParameter("Name");
		System.out.println(getServletContext().getInitParameter("NAME"));
		System.out.println(getServletContext().getInitParameter("JOB"));
		System.out.println(getServletContext().getInitParameter("EMAIL"));
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*
	 * 
	 * 
	 * 0.한글처리 ... 필터링 
	 * 1.폼값을 받는다 . id, pw , name
	 * 
	 * 2.HashMap에 추가한다. (id, pw , name)
	 * 
	 * 3.HashMap 을 ServletContext 에 바인딩 // (setAttribute())
	 * 
	 * 4.html로 출력문을 간단하게 작성 // a태그를 사용해서 sc2 로 연결
	 * 
	 */
	
		
		PrintWriter out = response.getWriter(); // 응답할 출력 스트림을 얻어낸다.
		System.out.println("doPost()  call...");
		
		String userId =  request.getParameter("userId"); // 1.폼값을 받는다 
		String userPass =  request.getParameter("userPass");
		String userName =  request.getParameter("userName");
		
		userList.put("userId", userId); // 2.hashmap 에 추가한다 .
		userList.put("userPass", userPass);
		userList.put("userName", userName);
		
		cont.setAttribute("userList", userList); // 3.HashMap 을 ServletContext (cont)에 바인딩 
		
		
		out.println("<html><body bgcolor=pink>"); //out. ~ 스트림에 텍스트를 기
		out.println("<b>===========The Communication Servlets==============<br>");
		out.println("사용자의 정보가 ServletContext에 바인딩 되었습니다...</b><p>");
		
		out.println("<a href='SC2'>접속자 명단 보기</a>");
	}
}














