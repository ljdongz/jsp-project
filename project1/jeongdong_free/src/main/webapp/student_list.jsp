<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="tukorea.websvc.club.domain.*, java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/student.css" type="text/css"></link>

</head>
<body>
	<header> TUK Student List </header>
	<hr>
	<%
	List<StudentVO> studentList = (List<StudentVO>) request.getAttribute("studentList");
	%>
	<table>
		<tbody>
			<tr>
				<td>계정</td>
				<td>이름</td>
				<td>학번</td>
				<td>학과</td>
				<td>핸드폰</td>
				<td>메일주소</td>
				<td>관리</td>
			</tr>
			<c:forEach var="vo" items="${studentList}">
				<c:if test="${not vo.getId().equals('admin')}">
					<tr>
						<td><c:out value="${vo.getId()}" /></td>
						<td><c:out value="${vo.getUsername()}" /></td>
						<td><c:out value="${vo.getSnum()}" /></td>
						<td><c:out value="${vo.getDepart()}" /></td>
						<td><c:out value="${vo.getMobile()}" /></td>
						<td><c:out value="${vo.getEmail()}" /></td>
						<td><a
							href="http://localhost:8080/jeongdong_free/StudentSevlet?cmd=update&id=${vo.getId()}"
							target="_self"> 수정</a> <a
							href="http://localhost:8080/jeongdong_free/StudentSevlet?cmd=delete&id=${vo.getId()}"
							target="_self"> 삭제</a></td>
					</tr>
				</c:if>

			</c:forEach>
			<%-- 			<%
			/* List<StudentVO> studentList = (List<StudentVO>) request.getAttribute("studentList"); */
			for (StudentVO vo : studentList) {
				if (vo.getId().equals("admin"))
					continue;
			%>
			<tr>
				<td><%=vo.getId()%></td>
				<td><%=vo.getUsername()%></td>
				<td><%=vo.getSnum()%></td>
				<td><%=vo.getDepart()%></td>
				<td><%=vo.getMobile()%></td>
				<td><%=vo.getEmail()%></td>
				<td><a
					href="http://localhost:8080/jeongdong_mvcdb/StudentSevlet?cmd=update&id=<%=vo.getId()%>"
					target="_self"> 수정</a> <a
					href="http://localhost:8080/jeongdong_mvcdb/StudentSevlet?cmd=delete&id=<%=vo.getId()%>"
					target="_self"> 삭제</a></td>
			</tr>
			<%
			}
			%> --%>
		</tbody>
	</table>
</body>
</html>