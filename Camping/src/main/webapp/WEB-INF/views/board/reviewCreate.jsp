<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="resources/styles/board/reviewCreate.css" rel="stylesheet" />
<title>이용후기 작성</title>
</head>
<body>
	<h1>이용후기</h1>

	<div class='form-0'>

		<form action="/reviewCreate" method="POST" enctype="multipart/form-data">
			<input type="hidden" name="id" value="${review.id}">
			 <input	class='write-1' type="text" name="title" maxlength="44"
				placeholder="제목 입력, 최대 44자까지 가능합니다">
			<hr>
			<textarea class='write-2' name="content" rows="20" cols="20"
				maxlength="254" placeholder="내용 작성, 최대 254자 가능합니다"></textarea>
			<input class='write-3' type="file" name="imageFile" id="fileToUpload">

			<hr>

			<button class='write-4' type="submit">글쓰기</button>
		</form>

		<form action="/review">
			<button class='write-5' type="submit" value="돌아가기">돌아가기</button>
		</form>



	</div>

</body>
</html>