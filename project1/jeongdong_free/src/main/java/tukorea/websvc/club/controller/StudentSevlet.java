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
import tukorea.websvc.club.service.StudentService;

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
		String strId;
		
		// queryString 파라미터 cmd
		cmdReq = request.getParameter("cmd");
		
		StudentService studentService = new StudentService();
		
		if(cmdReq.equals("join")) {
			response.sendRedirect("register.html");
		} else if (cmdReq.equals("login")) {
			response.sendRedirect("login.html");
		} else if (cmdReq.equals("list")) {
			
			ArrayList<StudentVO> studentList = studentService.readStudentList();  // DB에 저장된 학생 객체들을 불러
			request.setAttribute("studentList", studentList);
			RequestDispatcher view = request.getRequestDispatcher("student_list.jsp");
			view.forward(request, response);
		} else if (cmdReq.equals("delete")) {
			strId = request.getParameter("id");
			studentService.deleteStudent(strId);
			
			ArrayList<StudentVO> studentList = studentService.readStudentList();
			request.setAttribute("studentList", studentList);
			RequestDispatcher view = request.getRequestDispatcher("student_list.jsp");
			view.forward(request, response);
		} else if (cmdReq.equals("update")) {
			strId = request.getParameter("id");
			StudentVO student = studentService.readStudent(strId);
			
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
		
		StudentService studentService = new StudentService();
		
		String cmdReq = "";
		String message = "";
		
		String id;
		String passwd;
		String username;
		String snum;
		String depart;
		String mobile;
		String email;
		
		// queryString 파라미터 cmd
		cmdReq = request.getParameter("cmd");
		
		if(cmdReq.equals("join")) {
			// 학생 객체
			StudentVO studentVO = new StudentVO();
			
			id = request.getParameter("id");
			passwd = request.getParameter("password");
			username = request.getParameter("username");
			snum = request.getParameter("snum");
			depart = request.getParameter("depart");
			mobile = request.getParameter("mobile");
			email = request.getParameter("email");
			
			
//			StudentDAO studentDAO = new StudentDAO();
//			studentDAO.join(studentVO);
//			
//			// DB에 학생 객체 저장
//			if(studentDAO.add(studentVO)) message = "가입 축하합니다";
//			else message = "가입 실패입니다";
			
			StudentVO vo = studentService.joinStudent(id, passwd, username, snum, depart, mobile, email);
			message = studentService.addStudent(vo);
			
			request.setAttribute("studentVO", vo);
			//request.setAttribute("id", request.getParameter("id"));
			request.setAttribute("greetings", message);
			
			RequestDispatcher view = request.getRequestDispatcher("result.jsp");
			view.forward(request, response);
		} else if (cmdReq.equals("login")) {
			
			id = request.getParameter("id");
			passwd = request.getParameter("password");
			
			String result = studentService.login(id, passwd);
			
			if (result.equals("admin")) {
				RequestDispatcher view = request.getRequestDispatcher("admin.html");
				view.forward(request, response);
			} else if (result.equals("user")) {
				request.setAttribute("id", id);
				RequestDispatcher view = request.getRequestDispatcher("result.jsp");
				view.forward(request, response);
			} else if (result.equals("none")) {
				RequestDispatcher view = request.getRequestDispatcher("login.html");
				view.forward(request, response);
			}
			
		} else if (cmdReq.equals("update")) {
			StudentVO studentVO = new StudentVO();
			StudentDAO studentDAO = new StudentDAO();
			
			id = request.getParameter("id");
			passwd = request.getParameter("passwd");
			username = request.getParameter("username");
			snum = request.getParameter("snum");
			depart = request.getParameter("depart");
			mobile = request.getParameter("mobile");
			email = request.getParameter("email");
			
			studentService.updateStudent(id, passwd, username, snum, depart, mobile, email);
			
			
			ArrayList<StudentVO> studentList = studentService.readStudentList();  // DB에 저장된 학생 객체들을 불러
			request.setAttribute("studentList", studentList);
			RequestDispatcher view = request.getRequestDispatcher("student_list.jsp");
			view.forward(request, response);
		}
		
	}

}
