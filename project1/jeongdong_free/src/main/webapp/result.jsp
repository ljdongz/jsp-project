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
<title>Result Page</title>


<link rel="stylesheet" href="resources/student.css" type="text/css"></link>

</head>
<body>
	<%
	StudentVO studentVO = (StudentVO) request.getAttribute("studentVO");
	%>
	<header>
		TUKOREA 2022 <br> To Do List
	</header>
	<p id="sect"><%= studentVO.getId() %>의 To Do List</p><br>

	<p style="text-align: center;">
		<a href="http://localhost:8080/jeongdong_free/ArticleServlet?cmd=list&id=<%= session.getAttribute("id") %>" target="_self">Todo List</a>
	</p>

</body>
</html>