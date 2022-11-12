<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="tukorea.websvc.club.domain.*, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header> Member List </header>
	<hr>
	<p style="text-align: center;">
		<a href="http://localhost:8080/jeongdong_mvcdb/welcome.html"
			target="_self">메인 페이지 이동</a>
	</p>
	<table>
		<tbody>
			<tr>
				<td>제목</td>
				<td>내용</td>
				<td>관리</td>
			</tr>
			<%
			List<ArticleVO> articleList = (List<ArticleVO>)request.getAttribute("ArticleList");
			for (ArticleVO vo : articleList) {
			%>
			<tr>
				<td><%=vo.getTitle()%></td>
				<td><%=vo.getContent()%></td>
				<td><a
					href="http://localhost:8080/jeongdong_mvcdb/StudentSevlet?cmd=update&id=<%=vo.getId()%>"
					target="_self"> 수정</a> <a
					href="http://localhost:8080/jeongdong_mvcdb/StudentSevlet?cmd=delete&id=<%=vo.getId()%>"
					target="_self"> 삭제</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>