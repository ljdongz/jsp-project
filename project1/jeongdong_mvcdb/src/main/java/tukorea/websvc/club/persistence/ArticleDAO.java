package tukorea.websvc.club.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tukorea.websvc.club.domain.*;

public class ArticleDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	private String jdbc_url = "jdbc:mysql://localhost/jspdb?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";

	private void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "jspbook", "wjdehd3985");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void disconnect() {
		try {
			conn.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public boolean add(ArticleVO ao) {
		connect();
		String sql = "insert into jd_article(id, title, content) values (?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ao.getId());
			pstmt.setString(2, ao.getTitle());
			pstmt.setString(3, ao.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;
	}

	public boolean update(ArticleVO vo) {
		connect();
		String sql = "update jd_article set title=?, content=? where aid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getAid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return true;
	}

	public ArticleVO read(String strId) {
		connect();
		ArticleVO articleVO = new ArticleVO();
		String sql = "select * from jd_article where aid=?";
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, strId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				articleVO.setTitle(rs.getString("title"));
				articleVO.setContent(rs.getString("content"));
				articleVO.setAid(rs.getString("aid"));
				articleVO.setId(rs.getString("id"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return articleVO;
	}

	public void delete(String strId) {
		connect();
		String sql = "delete from jd_article where aid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, strId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public ArrayList<ArticleVO> getArticleList(String id) {
		connect();
		ArrayList<ArticleVO> articlelist = new ArrayList<ArticleVO>();
		String sql = "select * from jd_article where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ArticleVO vo = new ArticleVO();
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setId(rs.getString("id"));
				vo.setAid(rs.getString("aid"));
				articlelist.add(vo);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return articlelist;
	}
}
