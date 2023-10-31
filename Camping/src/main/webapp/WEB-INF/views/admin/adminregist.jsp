<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 가입 페이지</title>
</head>
<body>
	<form action="/camping/adminregist" method="post">
		<label for="admin-id">ID : 
		<input type="text" name="admin-id"
			id="admin-id" />
		</label> <label for="admin-pw">Password : 
		<input type="text"
			name="admin-pw" id="admin-pw" />
		</label> <label for="admin-name">NAME : 
		<input type="text"
			name="admin-name" id="admin-name" />
		</label>
		<button>관리자가입</button>
	</form>
	
</body>
</html>