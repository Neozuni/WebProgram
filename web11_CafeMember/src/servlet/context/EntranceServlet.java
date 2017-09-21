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

public class EntranceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServletContext cont;
    ArrayList<PersonVo> list = new ArrayList<PersonVo>();
	
    
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		System.out.println("1. 폼으로부터 값 받아옴..");
		
		PersonVo vo = new PersonVo(name, age);
		System.out.println("2. 폼으로부터 받은 값으로 VO생성...");
		
		cont = getServletContext();
		System.out.println(":: EntS :: SC 의 주소값 ");
		list = (ArrayList<PersonVo>)cont.getAttribute("list");
		System.out.println(" :: EntS :: List 의 주소값 "+list.hashCode());
		list.add(vo);
		
		cont = getServletContext();// Config의 기능으로부터 servletContext를 받아온다
		cont.setAttribute("list", list);
		System.out.println("3. Attribute에 바인딩...");
		
		//네비게이션 
		out.println(name+"님이 카페 가입하셨습니다.");
		out.println("<a href=ViewSevlet?name="+name+">회원 명단 보러가기</a>");
		
		out.close();
		
	}

}










