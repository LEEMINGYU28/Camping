
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
<title>이용후기</title>
<link href="resources/styles/board/review.css" rel="stylesheet" />
<link rel="shortcut icon" href="resources/img/boards/favicon.ico"
	type="image/x-icon">
<link rel="icon" href="resources/img/boards/favicon.ico"
	type="image/x-icon">


<script>
	window.onload = function() {
		let currentPage = window.location.href;

		if (currentPage.indexOf("../board/review") !== -1) {
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
		<jsp:include page='../layout/header.jsp'>
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
			<div class="box" id="noticeBox"
				onclick="goToPage('<%=contextPath%>/announcement/1')">공지사항</div>
			<div class="box" id="reviewBox"
				onclick="goToPage('<%=contextPath%>/review')">이용후기</div>
		</div>

		<section class="notice">
			<div class="reviewNotice">
				<div class="container">
					<h3>이용후기</h3>
				</div>
			</div>


			<div class="reviewTextContainer">

				<jsp:include page="./reviewList.jsp" />
			</div>

		</section>

		<footer>
			<jsp:include page='../layout/footer.jsp'>
				<jsp:param name="pageName" value="footer" />
			</jsp:include>
		</footer>
</body>
</html>