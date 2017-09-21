package servlet.context;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.vo.PersonVo;

public class ViewSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArrayList<PersonVo> list ;   
    private ServletContext cont;

    @Override
    public void init() throws ServletException {
    	cont = getServletContext();
    	System.out.println("1. servletcontext return ..");
    	
    	list= (ArrayList<PersonVo>)cont.getAttribute("list");
    	System.out.println("2. Reading .. by servletcontext");
    	
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		
		out.println("<html><body>");
		
		out.println("<b>"+name+"님입장을 환영합니다.</b><p><hr>");
		out.println("<h2>전체 Cafe 명단 리스트 보기</h2><p>");
		out.println("<table border=2 width=80%>");
		for(int i=0; i<list.size(); i++) {
			out.println("<tr>");
			out.println("<td>"+(i+1)+"</td>");
			out.println("<td>"+list.get(i).getName()+"</td>");
			out.println("<td>"+list.get(i).getAge()+"</td>");
			out.println("</tr>");
		}//for
		
		out.println("</body></html>");
		out.close();
	}
}



