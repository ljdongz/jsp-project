<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="tukorea.websvc.club.domain.*, java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TUK ToDoList</title>
<link rel="stylesheet" href="resources/table.css" type="text/css"></link>
<link rel="stylesheet" href="resources/main.css" type="text/css"></link>
</head>
<body>
	<header> <a href="http://localhost:8080/jeongdong_free/result.jsp">To Do List</a> </header>
	<hr>

	<table>
		<thead>
			<tr>
				<th>제목</th>
				<th>내용</th>
				<th>편집</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="vo" items="${requestScope.ArticleList}">
				<tr>
					<td>${vo.getTitle()}</td>
					<td>${vo.getContent()}</td>
					<td>
						<button class="view" type="button"
							onclick="location.href='http://localhost:8080/jeongdong_free/ArticleServlet?cmd=update&aid=${vo.getAid()}'">수정</button>
						<button class="delete" type="button"
							onclick="location.href='http://localhost:8080/jeongdong_free/ArticleServlet?cmd=delete&aid=${vo.getAid()}&id=${vo.getId()}'">삭제</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<p style="text-align: center;">
		<button class="add" type="button"
			onclick="location.href='http://localhost:8080/jeongdong_free/create_article.jsp'">할 일 추가</button>
	</p>
</body>
</html>