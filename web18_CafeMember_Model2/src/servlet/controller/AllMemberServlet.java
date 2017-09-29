package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

/**
 * Servlet implementation class AllMemberServlet
 */
public class AllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//결과는 allView.jsp로 돌린다.
		
		try {
			ArrayList<MemberVO> list = MemberDAO.getInstance().getAllMember();
			request.setAttribute("list", list);
			request.getRequestDispatcher("allview.jsp").forward(request, response);
			
		} catch (Exception e) {
		}
	}

}














