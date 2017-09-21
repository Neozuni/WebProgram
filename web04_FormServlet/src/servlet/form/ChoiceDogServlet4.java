package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChoiceDogServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChoiceDogServlet4() {

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Hangle set 
		//response.setContentType("text/html;charset=utf-8");
		//request.setCharacterEncoding("utf-8");
		
	PrintWriter out = response.getWriter();
	String[] dogs = request.getParameterValues("dog");
	//받아온 값을 (이미지)테이블 형식으로 웹으로 출력  
	
	out.println("<html><body bgcolor='black'><p>");
	out.println("<h2 align='center'><font color='white'>다음은 당신이 선택한 강아지들입니다.</h2>");
	out.println("<table align='center' bgcolor='yellow' width=60%>");
	out.println("<tr>");
	
	//선택한 이미지가 여러개 ...td 가 여러개 ...
	for(int i=0; i<dogs.length; i++) {
		out.println("<td>");
		out.println("<img src='"+dogs[i]+ "' />");
		out.println("</td>");
	}//
	out.println("</tr></table></body></html>");
}
}





