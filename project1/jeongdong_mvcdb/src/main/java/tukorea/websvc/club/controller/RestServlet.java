package tukorea.websvc.club.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import tukorea.websvc.club.domain.*;
import tukorea.websvc.club.persistence.*;

/**
 * Servlet implementation class RestServlet
 */
@WebServlet("/RestServlet")
public class RestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String cmdReq;
		cmdReq = request.getParameter("cmd");
		if(cmdReq == null) return;
		
		StudentDAO studentDAO = new StudentDAO();
		JSONArray arrayJson = new JSONArray();
		
		if(cmdReq.equals("list")) {
			try {
				List<StudentVO> studentList = studentDAO.getStudentList();
				for(StudentVO vo : studentList) {
					JSONObject json = new JSONObject();
					json.put("id", vo.getId());
					json.put("password", vo.getPasswd());
					json.put("username", vo.getUsername());
					json.put("snum", vo.getSnum());
					json.put("depart", vo.getDepart());
					json.put("mobile", vo.getMobile());
					json.put("email", vo.getEmail());
					arrayJson.put(json);
				}
			} catch(JSONException e) {
				e.printStackTrace();
			}
			out.print(arrayJson);
		}
		
		if(cmdReq.equals("read")) {
			try {
				String id = request.getParameter("id");
				if (id == null ) {
					out.print("계정을 확인하세요");
					return;
				}
				StudentVO vo = studentDAO.read(id);
				JSONObject json = new JSONObject();
				json.put("id", vo.getId());
				json.put("password", vo.getPasswd());
				json.put("username", vo.getUsername());
				json.put("snum", vo.getSnum());
				json.put("depart", vo.getDepart());
				json.put("mobile", vo.getMobile());
				json.put("email", vo.getEmail());
				arrayJson.put(json);
			} catch(JSONException e) {
				e.printStackTrace();
			}
			out.print(arrayJson);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
