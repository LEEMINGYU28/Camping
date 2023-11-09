<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<h1>이용후기 수정</h1>
	<c:if test="${not empty editReviewError}">
		<p style="color: red;">${editReviewError}</p>
	</c:if>

	<form action="<c:url value='/reviewEdit/${review.id}' />" method="post">
		<label for="title">Title:</label> <input type="text" id="title"
			name="title" value="${review.title}" /><br /> <label for="content">Content:</label>
		<textarea id="content" name="content">${review.content}</textarea>
		<br /> <input type="submit" value="Save">
	</form>
</body>
</html>