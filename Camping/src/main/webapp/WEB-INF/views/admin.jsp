<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지테스트</title>
<style>
.container {
	display: grid;
	width: 1000px;
	height: 800px;
	border: solid;
	grid-template-columns: 1fr 1fr 1fr 1fr;
	grid-template-rows: 1fr 1fr 1fr 1fr;
}

.title {
	grid-column: 2/4;
	grid-row: 1/2;
	text-align: center;
}

.login {
	grid-row: 1;
	grid-column: 1/2;
	text-align: center;
	border: solid;
}

.login_submit {
	margin-top: 10px;
}

.category {
	
}
</style>
</head>
<body>
	<div class="container">
		<div class="title">관리자페이지</div>

		<div class="login">
			로그인
			<div class="input_login">
				<c:choose>
					<c:when test="${adminName != null }">${adminName }</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${adminName == null }">
						<form action="/camping/login" method="post">
							<label for="admin-id"> ID : <input type="text"
								name="admin-id" id="admin-id" />
							</label> <label for="admin-pw">Password : <input type="text"
								name="admin-pw" id="admin-pw" />
							</label>
							<button>로그인</button>							
						</form>
						<a href="/camping/adminregist"><button>회원가입</button></a>
					</c:when>
					<c:when test="${adminName =! null }">
						<form action="/camping/logout" method="post">
							<button>로그아웃</button>
						</form>
					</c:when>
				</c:choose>
			</div>
		</div>

		<div class="category">
			<div class="category-user">1</div>
			<div class="category-board">2</div>
			<div class="category-image">3</div>
		</div>


	</div>
</body>
</html>