<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../resources/styles/board/reviewCreate.css" rel="stylesheet" />
</head>
<body>
	<h1>이용후기 수정</h1>
	<div class="form-0">
		<form
			action="${pageContext.request.contextPath}/reviewedit/${review.id}"
			method="post">
			 <input	class='write-1' type="text" name="title" maxlength="44"
				placeholder="${review.title}">
				<hr> 
			<textarea class="write-2" id="content" name="content">${review.content}</textarea>
			<br /> <input class="write-4" type="submit" value="저장" style="height: 33px;"/>
		</form>
		<form action="/camping/review">
			<button class='write-5' type="submit" value="돌아가기" style="height: 33px;">돌아가기</button>
		</form>
	</div>
</body>
</html>