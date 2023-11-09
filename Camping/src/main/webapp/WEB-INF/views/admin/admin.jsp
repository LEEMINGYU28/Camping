<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지테스트</title>
<link href="<%=contextPath%>/resources/styles/admin/admin.css"
	rel="stylesheet" />
<link href="<%=contextPath%>/resources/styles/admin/adminModal.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<style>
.container {
	padding: 0px;
}

a:not([href]):not([tabindex]) {
	color: white;
}

.nav-link {
	color: white;
}

.modal-content {
	background-color: #fefefe;
	margin: 20% auto; /* 15% from the top and centered */
	padding: 20px;
	border: 1px solid #888;
	width: 50%; /* Could be more or less, depending on screen size */
}
</style>

</head>
<body>
	<div class="container">

		<div class="title">
			<nav class="navbar navbar-expand navbar-dark bg-dark">
				<a class="navbar-brand" href="/camping/notices">관리자 페이지</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarsExample02" aria-controls="navbarsExample02"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarsExample02">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item active"><a class="nav-link"
							href="/camping/index">Home <span class="sr-only">(current)</span>
						</a></li>
						<c:choose>
							<c:when test="${adminName != null }">
								<li class="login-modal"><a class="nav-link">관리자
										${adminName } 님 반갑습니다.</a></li>
							</c:when>
							<c:otherwise>

								<li class="login-modal"><a class="btn" id="btn-modal"
									style="cursor: pointer;">Login</a></li>
							</c:otherwise>
						</c:choose>

						<c:choose>
							<c:when test="${adminName != null }">
								<form action="/camping/logout" method="post">
									<button class="logout-btn">로그아웃</button>
								</form>
							</c:when>
							<c:otherwise>
								<li class="create-modal"><a class="btn" id="btn-modal">관리자
										가입</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</nav>
			<div class="category">
				<div class="category-user">
					<div class="notice-list">
						<jsp:include page="./adminList.jsp" />
						<a href="notices/create">글쓰기</a>
					</div>
					<div class="category-admin">
						<a href="<%=contextPath%>/userList">회원 목록 조회</a>
					</div>
				</div>
				<div class="category-board"></div>
				<div class="category-image">3</div>
			</div>

		</div>

		<div class="modal">
			<div class="modal-content">
				<span class="close">&times;</span>
				<c:choose>
					<c:when test="${adminName == null }">
						<form action="/camping/login" method="post">
							<label for="admin-id" class="sr-only"><font
								style="vertical-align: inherit;"><font
									style="vertical-align: inherit;"></font></font></label> <input type="text"
								id="admin-id" class="form-control" placeholder="아이디 입력"
								name="admin-id" id="admin-id"> <label for="admin-pw"
								class="sr-only"><font style="vertical-align: inherit;"><font
									style="vertical-align: inherit;">비밀번호</font></font></label> <input
								type="password" id="admin-pw" class="form-control"
								placeholder="비밀번호" name="admin-pw">
							<button>로그인</button>
						</form>
					</c:when>
					<c:when test="${adminName != null }">
						<form action="/camping/logout" method="post">
							<button>로그아웃</button>
						</form>
					</c:when>
				</c:choose>
				<p class="mt-5 mb-3 text-muted">
					<font style="vertical-align: inherit;"><font
						style="vertical-align: inherit;">© 2023-11-01</font></font>
				</p>
			</div>

		</div>
	</div>


	<div class="modal">
		<div class="modal-content">
			<span class="close">&times;</span>
			<form action="/camping/regist" method="post">
				<label for="admin-id" class="sr-only"><font
					style="vertical-align: inherit;"><font
						style="vertical-align: inherit;"></font></font></label> <input type="text"
					id="admin-id" class="form-control" placeholder="아이디 입력"
					name="admin-id" id="admin-id"> <label for="admin-pw"
					class="sr-only"><font style="vertical-align: inherit;"><font
						style="vertical-align: inherit;"></font></font></label> <input type="password"
					id="admin-pw" class="form-control" placeholder="비밀번호"
					name="admin-pw"> <label for="admin-id" class="sr-only"><font
					style="vertical-align: inherit;"><font
						style="vertical-align: inherit;"></font></font></label> <input type="text"
					id="admin-name" class="form-control" placeholder="이름 입력"
					name="admin-name" id="admin-name">

				<button>관리자가입</button>
			</form>


		</div>
	</div>




	<script src=<%= contextPath %>/resources/script/adminModal.js></script>




</body>
</html>