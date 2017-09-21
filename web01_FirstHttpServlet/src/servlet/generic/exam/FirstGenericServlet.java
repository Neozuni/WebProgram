package servlet.generic.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstGenericServlet extends GenericServlet{

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); // 메소드가 프린터 라이트 객체를 만듬 ...
		out.println("<html><body bgcolor='yellow'>");
		out.println("<h2> Hello GenericServlet !!~~~</h2>");
		out.println("</body></html>");
		out.close();
	}

		
	
}
