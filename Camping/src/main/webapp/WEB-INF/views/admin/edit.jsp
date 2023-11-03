<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>공지사항 수정</h1>
	<form
		action="${pageContext.request.contextPath}/notices/edit/${notice.id}"
		method="post">
		<label for="title">제목:</label> <input type="text" id="title"
			name="title" value="${notice.title}" /><br /> <label for="content">내용:</label>
		<textarea id="content" name="content">${notice.content}</textarea>
		<br /> <input type="submit" value="저장" />
	</form>

</body>
</html>