<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TUK ToDoList</title>
<link rel="stylesheet" href="resources/register.css" type="text/css"></link>
</head>
<body>
	<header>Create Your To Do List</header>

	<div>
		<form
			action="http://localhost:8080/jeongdong_free/ArticleServlet?cmd=create"
			method="post">
			<input type="hidden" name="id"
				value=<%=session.getAttribute("id")%>>
			<fieldset>
				<ul>
					<li>제목 : <input type="text" name="title" autofocus required
						placeholder="공백없이 입력"></li>
					<li>내용 : <input type="text" name="content" autofocus></li>
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