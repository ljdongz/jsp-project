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
		} else if (cmdReq.equals("login")) {
			response.sendRedirect("login.html");
		} else if (cmdReq.equals("list")) {
			StudentDAO dao = new StudentDAO();
			ArrayList<StudentVO> studentList = dao.getStudentList();  // DB에 저장된 학생 객체들을 불러
			request.setAttribute("studentList", studentList);
			RequestDispatcher view = request.getRequestDispatcher("student_list.jsp");
			view.forward(request, response);
		} else if (cmdReq.equals("delete")) {
			StudentDAO dao = new StudentDAO();
			String strId = request.getParameter("id");
			dao.delete(strId);
			
			ArrayList<StudentVO> studentList = dao.getStudentList();
			request.setAttribute("studentList", studentList);
			RequestDispatcher view = request.getRequestDispatcher("student_list.jsp");
			view.forward(request, response);
		} else if (cmdReq.equals("update")) {
			StudentDAO dao = new StudentDAO();
			StudentVO student = dao.read(request.getParameter("id"));
			request.setAttribute("student", student);
			RequestDispatcher view = request.getRequestDispatcher("update.jsp");
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
			request.setAttribute("id", request.getParameter("id"));
			request.setAttribute("greetings", message);
			
			RequestDispatcher view = request.getRequestDispatcher("result.jsp");
			view.forward(request, response);
		} else if (cmdReq.equals("login")) {
			StudentVO studentVO;
			StudentDAO studentDAO = new StudentDAO();
			
			String id = request.getParameter("id");
			String passwd = request.getParameter("passwd");
			
			studentVO = studentDAO.read(id);
			if (studentVO.getId().equals(id) && studentVO.getPasswd().equals(passwd)) {
				RequestDispatcher view = request.getRequestDispatcher("login.html");
				view.forward(request, response);
			} else {
				message = "반갑";
				request.setAttribute("greetings", message);
				request.setAttribute("studentVO", studentVO);
				request.setAttribute("id", request.getParameter("id"));
				RequestDispatcher view = request.getRequestDispatcher("result.jsp");
				view.forward(request, response);
			}
			
			
		} else if (cmdReq.equals("update")) {
			StudentVO studentVO = new StudentVO();
			StudentDAO studentDAO = new StudentDAO();
			
			studentVO.setId(request.getParameter("id"));
			studentVO.setPasswd(request.getParameter("passwd"));
			studentVO.setUsername(request.getParameter("username"));
			studentVO.setSnum(request.getParameter("snum"));
			studentVO.setDepart(request.getParameter("depart"));
			studentVO.setMobile(request.getParameter("mobile"));
			studentVO.setEmail(request.getParameter("email"));
			
			if(studentDAO.update(studentVO)) message = "수정이 완료되었습니다.";
			else message = "수정 실패입니다. ";
			
			request.setAttribute("greetings", message);
			request.setAttribute("studentVO", studentVO);
			
			RequestDispatcher view = request.getRequestDispatcher("result.jsp");
			view.forward(request, response);
		}
		
	}

}
