<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="tukorea.websvc.club.domain.*"%>
<!DOCTYPE html>

<%
request.setCharacterEncoding("UTF-8");
if (session.isNew()) session.setAttribute("id", request.getParameter("id"));
%>

<html>
<head>
<meta charset="UTF-8">
<title>TUK ToDoList</title>
<link rel="stylesheet" href="resources/main.css" type="text/css"></link>
</head>
<body>

	<header>
		TUKOREA<br> To Do List

	</header>
	<p id="sect">${sessionScope.id}님,<br> TUK ToDoList 서비스에 오신 것을
		환영합니다.
	</p>

	<p style="text-align: center;">
		<a
			href="http://localhost:8080/jeongdong_free/ArticleServlet?cmd=list&id=${sessionScope.id}"
			target="_self">Todo List 보기</a> <br>
		<br> <a href="http://localhost:8080/jeongdong_free/logout.jsp">로그아웃</a>
	</p>

</body>
</html>