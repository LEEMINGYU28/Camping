<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>공지사항 삭제</h1>
<p>삭제</p>
<p>제목: ${notice.title}</p>
<p>내용: ${notice.content}</p>
<form action="${pageContext.request.contextPath}/notices/delete/${notice.id}" method="post">
    <input type="submit" value="삭제" />
</form>

</body>
</html>