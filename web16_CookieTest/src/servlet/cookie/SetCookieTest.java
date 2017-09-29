package servlet.cookie;
/*
 * 서버상의 첫번째 서블릿 페이지 
 * ::
 * 1. Cookie 생성
 * 	  --> Cookie c = new Cookie("key","value");
 * 2. 웹브라우저로 보냄
 *    --> resposne.addCookie(c);
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetCookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	
	//1 
	Date now = new Date(); // now를쿠키값으로 설정 .. 쿠키가 생성된 시각을 알수 있지 않을까 ?
	String id = "kosta";
	
	//2 
	Cookie c1 = new Cookie("now",now+" "); // now 는 date 객체임 string 가 들어가야되는데 에러가 남 tosting 를 써도 되지만 concat 을 붙여서 string 화함 
	Cookie c2 = new Cookie("id",id);
	
	//3 유효시간
	c1.setMaxAge(14*60*60); //하루로 세팅함 
	c2.setMaxAge(0); // 쿠키를 사용못하게 해본다  
	
	//4
	response.addCookie(c1);
	response.addCookie(c2);
	
	out.println("<h2> 쿠키가 생성된 시점의 시각::"+now+"<br>");
	out.println("아이디 :: "+id+"<br>");
	out.println("<a href=GetCookieTest>GetCookieTest GoGo....</a>");
	
	}

}
