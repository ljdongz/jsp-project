package tukorea.websvc.club.service;

import java.util.ArrayList;
import tukorea.websvc.club.domain.*;
import tukorea.websvc.club.persistence.*;

public class ArticleService {

	public void createArticle(String id, String title, String content) {
		ArticleVO vo = new ArticleVO();
		vo.setId(id);
		vo.setTitle(title);
		vo.setContent(content);
		
		ArticleDAO dao = new ArticleDAO();
		dao.add(vo);
		
	}
	
	public void updateArticle(String aid, String id, String title, String content) {
		ArticleVO vo = new ArticleVO();
		ArticleDAO dao = new ArticleDAO();
		
		vo.setAid(aid);
		vo.setId(id);
		vo.setTitle(title);
		vo.setContent(content);
		
		dao.update(vo);

	}
	
	public ArticleVO readArticle(String aid) {
		ArticleDAO dao = new ArticleDAO();
		ArticleVO vo = dao.read(aid);
		
		return vo;
	}
	
	public void deleteArticle(String aid) {
		ArticleDAO dao = new ArticleDAO();
		
		dao.delete(aid);
	}
	
	public ArrayList<ArticleVO> readArticleList(String id) {
		ArticleDAO dao = new ArticleDAO();
		ArrayList<ArticleVO> articleList = dao.getArticleList(id);
		return articleList;
	}
}
