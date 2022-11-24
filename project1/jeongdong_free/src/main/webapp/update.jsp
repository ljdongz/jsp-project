<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="tukorea.websvc.club.domain.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TUK ToDoList</title>
</head>
<body>
	<div align="center">
		<header>Member Update</header>
		<hr>
		<form action="http://localhost:8080/jeongdong_free/StudentSevlet?cmd=update" method="post">
		
<%-- 		<%
			StudentVO student = (StudentVO)request.getAttribute("student");
		%> --%>
		<fieldset>
			<legend> Information Update </legend>
			<ul>
				<li>ID: <input type="text" name="id" value= "${requestScope.student.getId()}" readonly ></li>
				<li>PASSWORD: <input type="password" name="passwd" value= "${requestScope.student.getPasswd()}" autofocus ></li>
				<li>USERNAME: <input type="text" name="username" value= "${requestScope.student.getUsername()}"></li>
				<li>STUDENTNUMBER: <input type="text" name="snum" value= "${requestScope.student.getSnum()}"></li>
				<li>DEPART: <input type="text" name="depart" value= "${requestScope.student.getDepart()}"></li>
				<li>MOBILE: <input type="text" name="mobile" value= "${requestScope.student.getMobile()}"></li>
				<li>EMAIL: <input type="text" name="email" value= "${requestScope.student.getEmail()}"></li>
			</ul>
		</fieldset>
		<br>
		<fieldset>
			<input type="submit" name="submit" value="최종수정">
			<input type="reset" name="reset" value="다시작성">
		</fieldset>
		</form>
	</div>
</body>
</html>