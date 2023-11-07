<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="resources/styles/layout/modal.css" rel="stylesheet" />
<link href="resources/styles/layout/consent.css" rel="stylesheet" />
<link href="resources/styles/layout/join.css" rel="stylesheet" />
<script type="text/javascript" src="resources/script/modal.js"></script>
<script type="text/javascript" src="resources/script/consent.js"></script>
<script type="text/javascript" src="resources/script/join.js"></script>
<script>
	function showDropdown() {
		var dropdownMenu = document.getElementById('dropdownMenu');
		dropdownMenu.classList.add('show');
	}

	function hideDropdown() {
		var dropdownMenu = document.getElementById('dropdownMenu');
		dropdownMenu.classList.remove('show');
	}
</script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<link href="./resources/styles/layout/header.css" rel="stylesheet" />
</head>
<body>

	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<img src="./resources/img/categorys/campingLogo3.jpg" alt="Campfire Icon">
		<a class="navbar-brand" href="./index">Camp</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExample03" aria-controls="navbarsExample03"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarsExample03">
			<ul class="navbar-nav mr-auto">
				<c:choose>
					<c:when test="${userName == null }">

						<li class="nav-item"><a id="btn-modal" class="nav-link"
							style="cursor: pointer;">LOGIN</a></li>
					</c:when>
					<c:when test="${userName != null }">

						<li><a class="nav-link"> ${userName } 님 반갑습니다.</a></li>

						<form action="/camping/logouts" method="post">
							<input type="hidden" name="_method" value="post"> <a
								class="nav-link" type="button" style="cursor: pointer;"
								onclick="submitForm();">LOGOUT</a>
						</form>

						<script>
							function submitForm() {
								document.forms[0].submit(); 
							}
						</script>

					</c:when>
				</c:choose>
				<li class="nav-item separator"></li>
				<li class="nav-item"><a class="nav-link" href="mypage">MYPAGE</a></li>
				<li class="nav-item"><a class="nav-link" href="./main">HOME</a></li>
				<li class="nav-item dropdown" onmouseover="showDropdown()"
					onmouseout="hideDropdown()"><a class="nav-link"
					href="announcement" id="dropdownMenuButton" aria-haspopup="true"
					aria-expanded="false">캠핑장소식</a>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton"
						id="dropdownMenu">
						<a class="dropdown-item" href="announcement">공지사항</a> <a
							class="dropdown-item" href="review">이용후기</a>
					</div></li>
				<li class="nav-item"><a class="nav-link" href="fee">이용요금</a></li>
				<li class="nav-item"><a class="nav-link" href="reserve">캠핑장예약</a></li>
				<li class="realTimeReserveBtn">
					<jsp:include page='../layout/realTimeReserve.jsp'>
						<jsp:param name="pageName" value="reserve" />
					</jsp:include>
				</li>
			</ul>

		</div>
	</nav>

	<div id="modal" class="modal-overlay">
		<div class="modal-window">
			<div class="title">
				<h2>로그인</h2>
			</div>
			<div class="close-area">X</div>
			<div class="content">
				<form action="/camping/logins" method="post">
					<input type="text" id="userId" name="userId" placeholder="아이디">
					<input type="password" id="userPw" name="userPw" placeholder="비밀번호">
					<button id="login-button" type="submit">로그인</button>
				</form>
				<a class="join" type="button" id="signup-button"
					style="cursor: pointer; color: black;">회원가입</a>
			</div>
			<div class="maintain">
				<label for="remember-me" id="remember-me-label">로그인상태유지</label> <input
					type="checkbox" id="remember-me">
			</div>
			<div id="division">
				<hr>
				<span id="division-text">또는</span>
				<hr>
			</div>
			<div>
				<button id="check">비회원 조회</button>
			</div>
		</div>
	</div>

	<div id="consentModal" class="consent-modal-overlay">
		<div class="consent-modal-window">
			<div class="title">
				<h2>약관동의</h2>
			</div>
			<div class="close-areas">X</div>
			<div id="consentbox">
				<div class=allCheck>
					<input type="checkbox" id="allAgreeCheckbox">이용약관,개인정보 수집 및
					이용에 모두 동의합니다.
				</div>
			</div>
			<div id="consentbox">
				<div class="terms">
					<input type="checkbox" id="agreeCheckbox">이용약관 동의
				</div>
			</div>
			<div class="essential">(필수)</div>
			<div class="scrollable-box">

			</div>
			<div id="consentbox">
				<div class="privacy">
					<input type="checkbox" id="agreebox">개인정보 수집 및 이용 동의
				</div>
			</div>
			<div class="essentials">(필수)</div>
			<div class="scrollable-box">

			</div>
			<div class="btn">
				<button id="closeModalbtn" class="agree-button">취소</button>
				<button id="nextModalbtn" class="agree-button">가입하기</button>
			</div>
		</div>
	</div>

	<div id="joinModal" class="join-modal-overlay">
		<div class="join-modal-window">
			<div class="profileImg">
				<img src="resources/img/categorys/profile.png" alt="">
			</div>
			<div class="title">
				<h2>회원가입</h2>
			</div>
			<div class="join-close-area">X</div>
			<form action="/camping/register" method="post">
				<div class="input-name">
					<label>이름</label>
					<div class="input-form-name">
						<input title="이름을(를) 입력하세요" type="text" id="userName"
							name="userName" placeholder="이름을(를) 입력하세요">
					</div>
				</div>
				<div class="join-content">
					<input type="text" id="userId" name="userId" placeholder="아이디">
					<input type="password" id="userPw" name="userPw" placeholder="비밀번호">
					<input type="password" id="passwordCheck" placeholder="비밀번호 확인">
					<span id="passwordMessage" style="color: red;"></span> <span
						id="passwordCheckMessage" style="color: red;"></span>
				</div>
				<button type="submit" id="joinBtn">가입하기</button>
			</form>
		</div>
	</div>

</body>
</html>