package servlet.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThirdSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   //jsp
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 기존 세션을 다시 받아온다
		 * JSESSIONID값을 웹으로 다시 출력
		 * 세션에 바인딩된 데이타가 있다면...세션을 죽인다....로그아웃
		 * 이때 팝업창을 띄워서 "로그아웃 하셨습니다" 라는 메세지가 뜨게...
		 * 네비게이션...session.html
		 * 
		 */
	}
}
