<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>너의 아지트가 되어줄게</title>
<link href="resources/styles/main.css" rel="stylesheet" />

</head>
<body>
	<header>
		<jsp:include page='../../layout/header.jsp'>
			<jsp:param name="pageName" value="header" />
		</jsp:include>
	</header>
	<div>
		<div class="bannerImg">
			<h1>
				어제 우리가 찾은 것은 모험의 흔적<br /> 잃은 것은 일상의 속박<br /> 남은 것은 추억과 자유의 바람
			</h1>
			<div class="bannerSeparator"></div>
			<h2>어제 오늘 그리고... Camp</h2>
			<div class="bannerSeparator"></div>
			<div class="bannerSeparator"></div>
			<jsp:include page='../../layout/realTimeReserve.jsp'>
				<jsp:param name="pageName" value="reserve" />
			</jsp:include>
		</div>
		<div class="gallery">
			<div>
				<p>
					<span>CAMP 갤러리</span>
				</p>
			</div>
			<div class="image-list">
				<c:forEach var="image" items="${imageList}">
					<img src="<c:out value="${image}" />" alt="Camp Image"
						class="gallery-image">
				</c:forEach>
			</div>
		</div>
		<div class="mainAnnouncement">
			<div>
				<p>
					<span>공지사항</span>
				</p>
			</div>
		</div>
	</div>
	<footer>
		<jsp:include page='../../layout/footer.jsp'>
			<jsp:param name="pageName" value="footer" />
		</jsp:include>
	</footer>
</body>
</html>