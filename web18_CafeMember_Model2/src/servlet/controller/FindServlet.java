package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;
import model.MemberVO;
public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	//find_action.jsp
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String path = "find_fail.jsp";
		
		try {
			MemberVO rvo = MemberDAO.getInstance().findMemberById(id);
			if(rvo!=null) {
				//out.println(id+"에 해당하는 정보 출력 : <br>"+rvo);
				request.setAttribute("mvo", rvo);
				path = "find_ok.jsp";
			}

			
			else {
				//out.println(id+"에 해당하는 사람이 없습니다. ");
				//path = "find_fail.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}















