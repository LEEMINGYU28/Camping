<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>공지사항 상세 정보</title>
</head>
<body>
	<h1>공지사항 상세 정보</h1>
	<c:if test="${notice != null}">
		<p>
			<strong>글쓴이:</strong> ${notice.admin.name}
		</p>
		<p>
			<strong>제목:</strong> ${notice.title}
		</p>
		<p>
			<strong>내용:</strong> ${notice.content}
		</p>
	</c:if>
	<a href="edit/${notice.id}">수정</a>
	<a href="delete/${notice.id}">삭제</a>

	<a href="/camping/admin">돌아가기</a>
</body>
</html>

