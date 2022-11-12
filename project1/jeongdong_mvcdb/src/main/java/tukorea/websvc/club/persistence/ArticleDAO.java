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
		String sql = "insert into article(id, title, content) values (?,?,?)";
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

//	public boolean update(StudentVO vo) {
//		connect();
//		String sql = "update student set passwd=?, username=?, snum=?, depart=?, mobile=?, email=? where id=?";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, vo.getPasswd());
//			pstmt.setString(2, vo.getUsername());
//			pstmt.setString(3, vo.getSnum());
//			pstmt.setString(4, vo.getDepart());
//			pstmt.setString(5, vo.getMobile());
//			pstmt.setString(6, vo.getEmail());
//			pstmt.setString(7, vo.getId());
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			disconnect();
//		}
//
//		return true;
//	}

//	public StudentVO read(String strId) {
//		connect();
//		StudentVO studentVO = new StudentVO();
//		String sql = "select * from student where id=?";
//		ResultSet rs = null;
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, strId);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				studentVO.setId(rs.getString("id"));
//				studentVO.setPasswd(rs.getString("passwd"));
//				studentVO.setUsername(rs.getString("username"));
//				studentVO.setSnum(rs.getString("snum"));
//				studentVO.setDepart(rs.getString("depart"));
//				studentVO.setMobile(rs.getString("mobile"));
//				studentVO.setEmail(rs.getString("email"));
//			}
//			rs.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			disconnect();
//		}
//		return studentVO;
//	}

//	public void delete(String strId) {
//		connect();
//		String sql = "delete from student where id=?";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, strId);
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			disconnect();
//		}
//	}

	public ArrayList<ArticleVO> getArticleList(String id) {
		connect();
		ArrayList<ArticleVO> articlelist = new ArrayList<ArticleVO>();
		String sql = "select * from article where id=(?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ArticleVO vo = new ArticleVO();
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
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
