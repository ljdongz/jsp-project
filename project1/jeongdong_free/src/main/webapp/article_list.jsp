<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="tukorea.websvc.club.domain.*, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TUK ToDoList</title>
<link rel="stylesheet" href="resources/student.css" type="text/css"></link>
</head>
<body>
	<header> To Do List </header>
	<hr>
	</p>
	<p style="text-align: center;">
		<a href="http://localhost:8080/jeongdong_free/create_article.jsp"
			target="_self">추가</a>
	</p>
	<table>
		<tbody>
			<tr>
				<td>제목</td>
				<td>내용</td>
				<td>관리</td>
			</tr>
			<%
			List<ArticleVO> articleList = (List<ArticleVO>)request.getAttribute("ArticleList");
			for (ArticleVO vo : articleList) {
			%>
			<tr>
				<td><%=vo.getTitle()%></td>
				<td><%=vo.getContent()%></td>
				<td><a
					href="http://localhost:8080/jeongdong_free/ArticleServlet?cmd=update&aid=<%=vo.getAid()%>"
					target="_self"> 수정</a> <a
					href="http://localhost:8080/jeongdong_free/ArticleServlet?cmd=delete&aid=<%=vo.getAid()%>&id=<%=vo.getId() %>"
					target="_self"> 삭제</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>