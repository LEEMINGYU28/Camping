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
		<jsp:include page='layout/header.jsp'>
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
			<jsp:include page='layout/realTimeReserve.jsp'>
				<jsp:param name="pageName" value="reserve" />
			</jsp:include>
		</div>
		<div class="gallery">
			<div>
				<p>
					<span>CAMP 갤러리</span>
				</p>
			</div>
			<div class="ImgContainer2Row">
				<img src="resources/img/campGallery/campGalleryImg1.jpg"
					alt="Camp Image" class="gallery-image" style="grid-area: img1;">
				<img src="resources/img/campGallery/campGalleryImg2.jpg"
					alt="Camp Image" class="gallery-image" style="grid-area: img2;">
				<img src="resources/img/campGallery/campGalleryImg3.jpg"
					alt="Camp Image" class="gallery-image" style="grid-area: img3;">
				<img src="resources/img/campGallery/campGalleryImg4.jpg"
					alt="Camp Image" class="gallery-image" style="grid-area: img4;">
				<img src="resources/img/campGallery/campGalleryImg5.jpg"
					alt="Camp Image" class="gallery-image" style="grid-area: img5;">
				<img src="resources/img/campGallery/campGalleryImg6.jpg"
					alt="Camp Image" class="gallery-image" style="grid-area: img6;">
			</div>
			<div class="gap"></div>
			<div class="ImgContainer3Row">
				<img src="resources/img/campGallery/campGalleryImg7.jpg"
					alt="Camp Image" class="gallery-image" style="grid-area: img7;">
				<img src="resources/img/campGallery/campGalleryImg8.jpg"
					alt="Camp Image" class="gallery-image" style="grid-area: img8;">
				<img src="resources/img/campGallery/campGalleryImg9.jpg"
					alt="Camp Image" class="gallery-image" style="grid-area: img9;">
				<img src="resources/img/campGallery/campGalleryImg10.jpg"
					alt="Camp Image" class="gallery-image" style="grid-area: img10;">
				<img src="resources/img/campGallery/campGalleryImg11.jpg"
					alt="Camp Image" class="gallery-image" style="grid-area: img11;">
				<img src="resources/img/campGallery/campGalleryImg12.jpg"
					alt="Camp Image" class="gallery-image" style="grid-area: img12;">
				<img src="resources/img/campGallery/campGalleryImg13.jpg"
					alt="Camp Image" class="gallery-image" style="grid-area: img13;">
				<img src="resources/img/campGallery/campGalleryImg14.jpg"
					alt="Camp Image" class="gallery-image" style="grid-area: img14;">
				<img src="resources/img/campGallery/campGalleryImg15.jpg"
					alt="Camp Image" class="gallery-image" style="grid-area: img15;">
			</div>

			<%-- <div class="image-list">
				<c:forEach var="image" items="${imageList}">
					<img src="<c:out value="${image}" />" alt="Camp Image"
						class="gallery-image">
				</c:forEach>
			</div>
			<div class="image-list2">
				<c:forEach var="image" items="${imageList}">
					<img src="<c:out value="${image}" />" alt="Camp Image"
						class="gallery-image">
				</c:forEach>
			</div> --%>

		</div>
		<div class="mainAnnouncement">
			<div>
				<p>
					<span>공지사항</span>
				</p>
				<div class="mainAnnouncementTextContainer">공지사항 내용</div>
			</div>
		</div>
	</div>
	<footer>
		<jsp:include page='layout/footer.jsp'>
			<jsp:param name="pageName" value="footer" />
		</jsp:include>
	</footer>
</body>
</html>