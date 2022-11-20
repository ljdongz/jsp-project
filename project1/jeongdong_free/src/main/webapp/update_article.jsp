<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="tukorea.websvc.club.domain.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TUK ToDoList</title>
</head>
<body>
	<%
	ArticleVO vo = (ArticleVO) request.getAttribute("article");
	%>
	<header>Login Your Account</header>

	<div>
		<form
			action="http://localhost:8080/jeongdong_free/ArticleServlet?cmd=update"
			method="post">
			<input type="hidden" name="aid" value=<%=vo.getAid()%>> <input
				type="hidden" name="id" value=<%=vo.getId()%>>
			<fieldset>
				<legend>Personal Information</legend>
				<ul>
					<li>제목 : <input type="text" name="title" autofocus required
						placeholder="공백없이 입력" value=<%=vo.getTitle()%>></li>
					<li>내용 : <input type="text" name="content" autofocus
						value=<%=vo.getContent()%>></li>
				</ul>
			</fieldset>
			<br>
			<fieldset>
				<input type="submit" name="submit" value="보내기">
			</fieldset>
		</form>
	</div>
</body>
</html>