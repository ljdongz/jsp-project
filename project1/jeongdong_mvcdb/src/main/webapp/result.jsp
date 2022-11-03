<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="tukorea.websvc.club.domain.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result Page</title>


<link rel="stylesheet" href="resources/student.css" type="text/css"></link>

</head>
<body>
	<header>
		TUKOREA 2022 <br> Web Service Programming Community
	</header>
	<p id="sect"><%=request.getAttribute("greetings")%><br>

		<%
		StudentVO studentVO = (StudentVO) request.getAttribute("studentVO");
		%>
	
	<div>
		<table>
			<tbody>
				<tr>
					<td>계정</td>
					<td>이름</td>
					<td>학번</td>
					<td>학과</td>
					<td>핸드폰</td>
					<td>이메일</td>
				</tr>
				<tr>
					<td><%=studentVO.getId()%></td>
					<td><%=studentVO.getUsername()%></td>
					<td><%=studentVO.getSnum()%></td>
					<td><%=studentVO.getDepart()%></td>
					<td><%=studentVO.getMobile()%></td>
					<td><%=studentVO.getEmail()%></td>
			</tbody>
		</table>
	</div>


	<p style="text-align: center;">
		<a href="http://localhost:8080/jeongdong_mvcdb/welcome.html">메인
			페이지 이동</a>
	</p>
	<p style="text-align: center;">
		<a href="http://localhost:8080/jeongdong_mvcdb/StudentSevlet?cmd=list"
			target="_self">전체 회원 목록 보기 이동</a>
	</p>
</body>
</html>