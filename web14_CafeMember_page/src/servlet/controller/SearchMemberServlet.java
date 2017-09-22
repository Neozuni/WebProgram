package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.beans.finder.PrimitiveWrapperMap;

import context.model.MemberDAO;
import context.model.MemberVO;

public class SearchMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	
	String id = request.getParameter("id");
	
	MemberDAO dao = MemberDAO.getInstance(); // 싱글톤 비지니스 로직 받기 
	
	try {
		MemberVO rvo=dao.findByIdMember(id); // rvo, pvo 어디서 부터 리턴되었는지 표시하기 위해 
		request.setAttribute("vo", rvo);

		
		out.println("<h2>RequestDispatcher ... getting </h2><p>"); // 왜 출력이 안될까 ?? 브라우저 응답을 안하기 때문에 ...(foward)
		/*
		 * 1. requesDispatcher 얻어내고 path를 | ResultViewServlet 으로   
		 * 2. forward()
		 */
		
		//request.getRequestDispatcher("ResultViewServlet");
		//RequestDispatcher rdp = request.getRequestDispatcher("ResultViewServlet");
		RequestDispatcher rdp = request.getRequestDispatcher("resultView.jsp");
		rdp.forward(request, response);
		
		
		//request.getRequestDispatcher("include.jsp").include(request, response);
		
		
		out.println("<p><h1>FORWARD... <h1>");
		out.close();
		
	} catch (SQLException e) {
	}
	
	}

}
