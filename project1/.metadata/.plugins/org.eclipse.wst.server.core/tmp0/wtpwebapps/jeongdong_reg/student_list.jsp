<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="tukorea.websvc.club.domain.*, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<hr>
	<a href="http://localhost:8080/jeongdong_reg/welcome.html" target="_self">메인 페이지 이동</a>
	<table>
		<tr>
			<td>계정</td>
			<td>이름</td>
			<td>학번</td>
			<td>학과</td>
			<td>핸드폰</td>
			<td>메일주소</td>
			<td>관리</td>
		</tr>
		<%
			List<StudentVO> studentList = (List<StudentVO>)request.getAttribute("studentList");
			for(StudentVO vo : studentList) {
		%>
		<tr>
			<td><%= vo.getId() %></td>
			<td><%= vo.getUsername() %></td>
			<td><%= vo.getSnum() %></td>
			<td><%= vo.getDepart() %></td>
			<td><%= vo.getMobile() %></td>
			<td><%= vo.getEmail() %></td>
			<td></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>