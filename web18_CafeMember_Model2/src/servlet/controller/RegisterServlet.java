package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<MemberVO> list = new ArrayList<MemberVO>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	//register_result.jsp
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter(); //1. PrintWriter 리턴받고
	String id = request.getParameter("id"); // 2. 폼값 받아서
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String address = request.getParameter("address");
	
	MemberVO vo = new MemberVO(id,name,password,address); //* 3. VO생성
	
	try {
		MemberDAO.getInstance().registerMember(vo); //4. DAO 리턴 받아서
		//out.println(name+"님이 가입에 성공하였습니다. ");
		request.getRequestDispatcher("register.jsp").forward(request, response);
		
		
	} catch (Exception e) {
		out.println(name+"님이 가입에 실패하였습니다. ");
		
	} //try catch
//	list.add(vo);
//	getServletContext().setAttribute("list",list);
//	response.sendRedirect("index.jsp");
	}

}












