<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="tukorea.websvc.club.domain.*, java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Page</title>
<link rel="stylesheet" href="resources/table.css" type="text/css"></link>
<link rel="stylesheet" href="resources/main.css" type="text/css"></link>

</head>
<body>
	<header>
		<a href="http://localhost:8080/jeongdong_free/admin.html">TUK Student List</a>
	</header>
	<hr>
	<table>
		<thead>
			<tr>
				<td>계정</td>
				<td>이름</td>
				<td>학번</td>
				<td>학과</td>
				<td>핸드폰</td>
				<td>메일주소</td>
				<td>관리</td>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="vo" items="${requestScope.studentList}">
				<c:if test="${not vo.getId().equals('admin')}">
					<tr>
						<td><c:out value="${vo.getId()}" /></td>
						<td><c:out value="${vo.getUsername()}" /></td>
						<td><c:out value="${vo.getSnum()}" /></td>
						<td><c:out value="${vo.getDepart()}" /></td>
						<td><c:out value="${vo.getMobile()}" /></td>
						<td><c:out value="${vo.getEmail()}" /></td>
						<td>
							<button class="view" type="button" onclick="location.href='http://localhost:8080/jeongdong_free/StudentSevlet?cmd=update&id=${vo.getId()}'">수정</button>	
							<button class="delete" type="button" onclick="location.href='http://localhost:8080/jeongdong_free/StudentSevlet?cmd=delete&id=${vo.getId()}'">삭제</button>		
						</td>
					</tr>
				</c:if>

			</c:forEach>
		</tbody>
	</table>
</body>
</html>