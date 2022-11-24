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
		String id;
		
		cmdReq = request.getParameter("cmd");
		id = request.getParameter("id");
		
		if(cmdReq == null) return;
		
//		StudentDAO studentDAO = new StudentDAO();
		
		ArticleDAO articleDAO = new ArticleDAO();
		JSONArray arrayJson = new JSONArray();
		
		
		if(cmdReq.equals("articles") ) {
			try {
				List<ArticleVO> articleList = articleDAO.getArticleList(id);
				for(ArticleVO vo : articleList) {
					JSONObject json = new JSONObject();
					json.put("aid", vo.getAid());
					json.put("title", vo.getTitle());
					json.put("content", vo.getContent());
					arrayJson.put(json);
				}
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
