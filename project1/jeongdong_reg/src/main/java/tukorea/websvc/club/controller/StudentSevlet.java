package tukorea.websvc.club.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tukorea.websvc.club.domain.*;
import tukorea.websvc.club.persistence.*;

/**
 * Servlet implementation class StudentSevlet
 */
@WebServlet("/StudentSevlet")
public class StudentSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		RequestDispatcher view = request.getRequestDispatcher("register.html");
//		view.forward(request, response);
		
		String cmdReq="";
		
		// queryString 파라미터 cmd
		cmdReq = request.getParameter("cmd");
		
		if(cmdReq.equals("join")) {
			response.sendRedirect("register.html");
		} else if (cmdReq.equals("list")) {
			StudentDAO dao = new StudentDAO();
			ArrayList<StudentVO> studentList = dao.getStudentList();  // DB에 저장된 학생 객체들을 불러
			request.setAttribute("studentList", studentList);
			RequestDispatcher view = request.getRequestDispatcher("student_list.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String cmdReq = "";
		String message = "";
		
		// queryString 파라미터 cmd
		cmdReq = request.getParameter("cmd");
		
		if(cmdReq.equals("join")) {
			// 학생 객체
			StudentVO studentVO = new StudentVO();
			
			studentVO.setId(request.getParameter("id"));
			studentVO.setPasswd(request.getParameter("password"));
			studentVO.setUsername(request.getParameter("username"));
			studentVO.setSnum(request.getParameter("snum"));
			studentVO.setDepart(request.getParameter("depart"));
			studentVO.setMobile(request.getParameter("mobile"));
			studentVO.setEmail(request.getParameter("email"));
			
			
			StudentDAO studentDAO = new StudentDAO();
			studentDAO.join(studentVO);
			
			// DB에 학생 객체 저장
			if(studentDAO.add(studentVO)) message = "가입 축하합니다";
			else message = "가입 실패입니다";
			
			request.setAttribute("studentVO", studentVO);
			request.setAttribute("greetings", message);
			
			RequestDispatcher view = request.getRequestDispatcher("result.jsp");
			view.forward(request, response);
		}
		
	}

}
