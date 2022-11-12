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
 * Servlet implementation class ArticleServlet
 */
@WebServlet("/ArticleServlet")
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cmdReq = "";
		String id = "";

		// queryString 파라미터 cmd
		cmdReq = request.getParameter("cmd");
		id = request.getParameter("id");

		if (cmdReq.equals("list")) {
			ArticleDAO dao = new ArticleDAO();
			ArrayList<ArticleVO> articleList = dao.getArticleList(id);
			request.setAttribute("ArticleList", articleList);
			RequestDispatcher view = request.getRequestDispatcher("article_list.jsp");
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String cmdReq = "";
		cmdReq = request.getParameter("cmd");
		
		if (cmdReq.equals("create")) {
			ArticleVO vo = new ArticleVO();
			vo.setId(request.getParameter("id"));
			vo.setTitle(request.getParameter("title"));
			vo.setContent(request.getParameter("content"));
			
			
			
			ArticleDAO dao = new ArticleDAO();
			dao.add(vo);
			
			ArrayList<ArticleVO> articleList = dao.getArticleList(request.getParameter("id"));
			
			RequestDispatcher view = request.getRequestDispatcher("article_list.jsp");
			request.setAttribute("ArticleList", articleList);
			view.forward(request, response);
		}
	}

}
