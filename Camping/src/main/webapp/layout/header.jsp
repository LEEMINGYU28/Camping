<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

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
<link href="./resources/styles/header.css" rel="stylesheet" />
</head>
<body>

	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<img src="./resources/img/campingLogo3.jpg" alt="Campfire Icon">
		<a class="navbar-brand" href="./index">Camp</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExample03" aria-controls="navbarsExample03"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarsExample03">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="#">LOGIN</a></li>
				<li class="nav-item separator"></li>
				<li class="nav-item"><a class="nav-link" href="#">MYPAGE</a></li>
				<li class="nav-item"><a class="nav-link" href="./main">HOME</a></li>
				<li class="nav-item dropdown" onmouseover="showDropdown()"
					onmouseout="hideDropdown()"><a class="nav-link"
					href="./announcement" id="dropdownMenuButton" aria-haspopup="true"
					aria-expanded="false">캠핑장소식</a>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton"
						id="dropdownMenu">
						<a class="dropdown-item" href="./announcement">공지사항</a> <a
							class="dropdown-item" href="./review">이용후기</a>
					</div></li>
				<li class="nav-item"><a class="nav-link" href="./fee">이용요금</a></li>
				<li class="nav-item"><a class="nav-link" href="./reserve">캠핑장예약</a></li>
				
				<li class="nav-item right-aligned"><jsp:include
						page='realTimeReserve.jsp'>
						<jsp:param name="pageName" value="reserve" />
					</jsp:include></li>
			</ul>

		</div>
	</nav>

</body>
</html>