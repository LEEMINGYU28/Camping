<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<link href="resources/styles/board/announcement.css" rel="stylesheet" />

<script>
	window.onload = function() {
		let currentPage = window.location.href; // 현재 페이지 URL로 설정

		if (currentPage.indexOf("./../board/announcement") !== -1) {
			document.getElementById("noticeBox").style.backgroundColor = "navy";
			document.getElementById("noticeBox").style.color = "white";
			document.getElementById("reviewBox").style.backgroundColor = "white";
			document.getElementById("reviewBox").style.color = "black";
		}
	}
	function goToPage(pageURL) {
		window.location.href = pageURL;
	}
</script>
</head>
<body>
	<header>
		<jsp:include page='../layout/header.jsp'>
			<jsp:param name="pageName" value="header" />
		</jsp:include>
	</header>

	<div>
		<div class="announcementImg">
			<div class="text_wrap">
				<h1>/ 캠핑장공지 /</h1>

			</div>
		</div>

		<div class="boxContainer">
			<div class="box" id="noticeBox" onclick="goToPage('announcement')">공지사항</div>
			<div class="box" id="reviewBox" onclick="goToPage('review')">이용후기</div>
		</div>


		<div class="announcementNotice">
			<h1>공지사항</h1>
		</div>
		<div class="anouncementTextContainer">
			공지사항 내용
		</div>
		
	</div>

	<footer>
		<jsp:include page='../layout/footer.jsp'>
			<jsp:param name="pageName" value="footer" />
		</jsp:include>
	</footer>
</body>
</html>