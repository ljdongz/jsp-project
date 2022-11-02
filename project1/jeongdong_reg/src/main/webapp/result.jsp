<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="tukorea.websvc.club.domain.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result Page</title>


<link rel="stylesheet" href="resources/register.css" type="text/css"></link>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">

</head>
<body>
	<header>
		TUKOREA 2022 <br> Web Service Programming Community
	</header>
	<p id="sect"><%=request.getAttribute("greetings") %><br>

	<p id="sect">커뮤니티 가입을 축하합니다.</p>

	<% StudentVO studentVO = (StudentVO)request.getAttribute("studentVO"); %>

	<div>
		<table class="table table-warning table-striped">
			<tbody>
				<tr>
					<th scope="row">계정</th>
					<td><%=studentVO.getId()%></td>
				</tr>
				<tr>
					<th scope="row">이름</th>
					<td><%=studentVO.getUsername() %></td>
				</tr>
				<tr>
					<th scope="row">학번</th>
					<td><%=studentVO.getSnum() %></td>
				</tr>
				<tr>
					<th scope="row">학과</th>
					<td><%=studentVO.getDepart() %></td>
				</tr>
				<tr>
					<th scope="row">핸드폰</th>
					<td><%=studentVO.getMobile() %></td>
				</tr>
				<tr>
					<th scope="row">이메일</th>
					<td><%=studentVO.getEmail() %></td>
				</tr>
			</tbody>
		</table>
	</div>


	<p style="text-align: center;">
		<a href="http://localhost:8080/jeongdong_reg/welcome.html">메인 페이지
			이동</a>
	</p>
	<p style="text-align: center;">
		<a href="http://localhost:8080/jeongdong_reg/StudentSevlet?cmd=list" target="_self">전체 회원 목록 보기
			이동</a>
	</p>
</body>
</html>