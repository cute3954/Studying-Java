package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.MemberDAO;
import model.Member;

@WebServlet("/MemberList")
public class MemberList extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			MemberDAO memberDAO = new MemberDAO();
			List<Member> memberList = null;
			
			memberList = memberDAO.getAllMember();
			request.setAttribute("memberList", memberList);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/memberList.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			System.out.println("Error: "+e);
			e.printStackTrace();
		}
	}
	
}
