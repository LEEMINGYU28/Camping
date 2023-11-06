<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>이미지 업로드</title>
</head>
<body>
	<h1>이미지 업로드</h1>
	<form action="/upload" method="post" enctype="multipart/form-data">
		<input type="file" name="image" accept="image/*"> <input
			type="submit" value="업로드">
	</form>
</body>
</html>