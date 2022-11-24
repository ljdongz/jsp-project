<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="tukorea.websvc.club.domain.*"%>
<!DOCTYPE html>

<%
request.setCharacterEncoding("UTF-8");
session.setAttribute("id", request.getParameter("id"));
%>

<html>
<head>
<meta charset="UTF-8">
<title>TUK ToDoList</title>
<link rel="stylesheet" href="resources/student.css" type="text/css"></link>
</head>
<body>
<%-- 	<%
	StudentVO studentVO = (StudentVO) request.getAttribute("studentVO");
	%> --%>
	<header>
		<a href="http://localhost:8080/jeongdong_free">TUKOREA 2022 <br>
			To Do List
		</a>

	</header>
	<p id="sect">${sessionScope.id}의 To Do List
	</p>
	<p><a href="http://localhost:8080/jeongdong_free/logout.jsp">로그아웃</a></p>
	<br>

	<p style="text-align: center;">
		<a
			href="http://localhost:8080/jeongdong_free/ArticleServlet?cmd=list&id=${sessionScope.id}"
			target="_self">Todo List</a>
	</p>

</body>
</html>