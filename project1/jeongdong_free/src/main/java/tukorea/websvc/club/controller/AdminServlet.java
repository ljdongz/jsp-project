package tukorea.websvc.club.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tukorea.websvc.club.domain.StudentVO;
import tukorea.websvc.club.persistence.StudentDAO;
import tukorea.websvc.club.service.StudentService;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cmdReq = "";
		
		StudentService studentService = new StudentService();

		// queryString 파라미터 cmd
		cmdReq = request.getParameter("cmd");

		if (cmdReq.equals("list")) {
			ArrayList<StudentVO> studentList = studentService.readStudentList(); // DB에 저장된 학생 객체들을 불러
			request.setAttribute("studentList", studentList);
			RequestDispatcher view = request.getRequestDispatcher("student_list.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
