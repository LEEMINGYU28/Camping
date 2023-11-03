<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이용후기</title>
<link href="resources/styles/review.css" rel="stylesheet" />


<script>
	window.onload = function() {
		let currentPage = window.location.href;

		if (currentPageURL.indexOf("review") !== -1) {
			document.getElementById("reviewBox").style.backgroundColor = "navy";
			document.getElementById("reviewBox").style.color = "white";
			document.getElementById("noticeBox").style.backgroundColor = "white";
			document.getElementById("noticeBox").style.color = "black";
		}
	}
	function goToPage(pageURL) {
		window.location.href = pageURL;
	}
</script>
</head>
<body>
	<header>
		<jsp:include page='../../layout/header.jsp'>
			<jsp:param name="pageName" value="header" />
		</jsp:include>
	</header>

	<div>
		<div class="reviewImg">
			<div class="text_wrap">
				<h1>/ 이용후기 /</h1>
			</div>
		</div>

		<div class="boxContainer">
			<div class="box" id="noticeBox" onclick="goToPage('./announcement')">공지사항</div>
			<div class="box" id="reviewBox" onclick="goToPage('./review')">이용후기</div>
		</div>


		<div class="reviewNotice">
			<h1>이용후기</h1>
		</div>
		
		<div class="reviewTextContainer">
			이용후기 내용
		</div>
		
	</div>

	<footer>
		<jsp:include page='../../layout/footer.jsp'>
			<jsp:param name="pageName" value="footer" />
		</jsp:include>
	</footer>
</body>
</html>