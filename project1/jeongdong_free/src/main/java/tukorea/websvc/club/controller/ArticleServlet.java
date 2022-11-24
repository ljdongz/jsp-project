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
import tukorea.websvc.club.service.*;

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
		String aid;

		// queryString 파라미터 cmd
		cmdReq = request.getParameter("cmd");
		id = request.getParameter("id");
		
		ArticleService articleService = new ArticleService();

		if (cmdReq.equals("list")) {
			
			ArrayList<ArticleVO> articleList = articleService.readArticleList(id);
			request.setAttribute("ArticleList", articleList);
			RequestDispatcher view = request.getRequestDispatcher("article_list.jsp");
			view.forward(request, response);
		} else if (cmdReq.equals("update")) {
			aid = request.getParameter("aid");
//			ArticleDAO dao = new ArticleDAO();
//			ArticleVO vo = dao.read(aid);

			ArticleVO vo = articleService.readArticle(aid);
			
			RequestDispatcher view = request.getRequestDispatcher("update_article.jsp");
			request.setAttribute("article", vo);
			view.forward(request, response);
			
		} else if (cmdReq.equals("delete")) {
			aid = request.getParameter("aid");
			articleService.deleteArticle(aid);
//			ArticleDAO dao = new ArticleDAO();
//			
//			dao.delete(aid);
			
			//ArrayList<ArticleVO> articleList = dao.getArticleList(id);
			ArrayList<ArticleVO> articleList = articleService.readArticleList(id);
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
		
		String aid;
		String id;
		String title;
		String content;
		
		String cmdReq = "";
		cmdReq = request.getParameter("cmd");
		
		ArticleService articleService = new ArticleService();
		
		if (cmdReq.equals("create")) {
			
//			ArticleVO vo = new ArticleVO();
//			vo.setId(request.getParameter("id"));
//			vo.setTitle(request.getParameter("title"));
//			vo.setContent(request.getParameter("content"));
//			
//			ArticleDAO dao = new ArticleDAO();
//			dao.add(vo);
//			
//			ArrayList<ArticleVO> articleList = dao.getArticleList(request.getParameter("id"));
			
			id = request.getParameter("id");
			title = request.getParameter("title");
			content = request.getParameter("content");
			
			articleService.createArticle(id, title, content);
			ArrayList<ArticleVO> articleList = articleService.readArticleList(id);
			
			
			RequestDispatcher view = request.getRequestDispatcher("article_list.jsp");
			request.setAttribute("ArticleList", articleList);
			view.forward(request, response);
		} else if (cmdReq.equals("update")) {
//			ArticleVO vo = new ArticleVO();
//			ArticleDAO dao = new ArticleDAO();
//			
//			vo.setAid(request.getParameter("aid"));
//			vo.setId(request.getParameter("id"));
//			vo.setTitle(request.getParameter("title"));
//			vo.setContent(request.getParameter("content"));
//			
//			dao.update(vo);
//			
//			ArrayList<ArticleVO> articleList = dao.getArticleList(request.getParameter("id"));
			
			aid = request.getParameter("aid");
			id = request.getParameter("id");
			title = request.getParameter("title");
			content = request.getParameter("content");
			
			articleService.updateArticle(aid, id, title, content);
			ArrayList<ArticleVO> articleList = articleService.readArticleList(id);
			
			request.setAttribute("ArticleList", articleList);
			
			RequestDispatcher view = request.getRequestDispatcher("article_list.jsp");
			view.forward(request, response);
			
			
		}
	}

}
