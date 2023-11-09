<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
 <% String contextPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CAMP</title>
<link href="<%=contextPath %>/resources/styles/main.css" rel="stylesheet" />
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- Fancybox CSS -->
<link rel="stylesheet" type="text/css"
   href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/3.5.7/jquery.fancybox.min.css" />

<!-- Slick CSS -->
<link rel="stylesheet" type="text/css"
   href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.css" />

<link rel="shortcut icon" href="<%=contextPath %>/resources/img/boards/favicon.ico" type="image/x-icon">
<link rel="icon" href="<%=contextPath %>/resources/img/boards/favicon.ico" type="image/x-icon">

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
            <a href="<%=contextPath %>/resources/img/campGallery/campGalleryImg1.jpg"
               data-fancybox="gallery" class="gallery-link"> <img
               src="<%=contextPath %>/resources/img/campGallery/campGalleryImg1.jpg"
               alt="Camp Image" class="gallery-image" style="grid-area: img1;">
            </a> 
            <a href="<%=contextPath %>/resources/img/campGallery/campGalleryImg2.jpg"
               data-fancybox="gallery" class="gallery-link"> <img
               src="<%=contextPath %>/resources/img/campGallery/campGalleryImg2.jpg"
               alt="Camp Image" class="gallery-image" style="grid-area: img2;">
            </a> 
            <a href="<%=contextPath %>/resources/img/campGallery/campGalleryImg3.jpg"
               data-fancybox="gallery" class="gallery-link"> <img
               src="<%=contextPath %>/resources/img/campGallery/campGalleryImg3.jpg"
               alt="Camp Image" class="gallery-image" style="grid-area: img3;">
            </a>
            <a href="<%=contextPath %>/resources/img/campGallery/campGalleryImg4.jpg"
               data-fancybox="gallery" class="gallery-link"> <img
               src="<%=contextPath %>/resources/img/campGallery/campGalleryImg4.jpg"
               alt="Camp Image" class="gallery-image" style="grid-area: img4;">
            </a>
            <a href="<%=contextPath %>/resources/img/campGallery/campGalleryImg5.jpg"
               data-fancybox="gallery" class="gallery-link"> <img
               src="<%=contextPath %>/resources/img/campGallery/campGalleryImg5.jpg"
               alt="Camp Image" class="gallery-image" style="grid-area: img5;">
            </a>
            <a href="<%=contextPath %>/resources/img/campGallery/campGalleryImg6.jpg"
               data-fancybox="gallery" class="gallery-link"> <img
               src="<%=contextPath %>/resources/img/campGallery/campGalleryImg6.jpg"
               alt="Camp Image" class="gallery-image" style="grid-area: img6;">
            </a>
         </div>
         <div class="gap"></div>
         <div class="ImgContainer3Row">
            <a href="<%=contextPath %>/resources/img/campGallery/campGalleryImg7.jpg"
               data-fancybox="gallery" class="gallery-link"> <img
               src="<%=contextPath %>/resources/img/campGallery/campGalleryImg7.jpg"
               alt="Camp Image" class="gallery-image" style="grid-area: img7;">
            </a>
            <a href="<%=contextPath %>/resources/img/campGallery/campGalleryImg8.jpg"
               data-fancybox="gallery" class="gallery-link"> <img
               src="<%=contextPath %>/resources/img/campGallery/campGalleryImg8.jpg"
               alt="Camp Image" class="gallery-image" style="grid-area: img8;">
            </a>
            <a href="<%=contextPath %>/resources/img/campGallery/campGalleryImg9.jpg"
               data-fancybox="gallery" class="gallery-link"> <img
               src="<%=contextPath %>/resources/img/campGallery/campGalleryImg9.jpg"
               alt="Camp Image" class="gallery-image" style="grid-area: img9;">
            </a>
            <a href="<%=contextPath %>/resources/img/campGallery/campGalleryImg10.jpg"
               data-fancybox="gallery" class="gallery-link"> <img
               src="<%=contextPath %>/resources/img/campGallery/campGalleryImg10.jpg"
               alt="Camp Image" class="gallery-image" style="grid-area: img10;">
            </a>
            <a href="<%=contextPath %>/resources/img/campGallery/campGalleryImg11.jpg"
               data-fancybox="gallery" class="gallery-link"> <img
               src="<%=contextPath %>/resources/img/campGallery/campGalleryImg11.jpg"
               alt="Camp Image" class="gallery-image" style="grid-area: img11;">
            </a>
            <a href="<%=contextPath %>/resources/img/campGallery/campGalleryImg12.jpg"
               data-fancybox="gallery" class="gallery-link"> <img
               src="<%=contextPath %>/resources/img/campGallery/campGalleryImg12.jpg"
               alt="Camp Image" class="gallery-image" style="grid-area: img12;">
            </a>
            <a href="<%=contextPath %>/resources/img/campGallery/campGalleryImg13.jpg"
               data-fancybox="gallery" class="gallery-link"> <img
               src="<%=contextPath %>/resources/img/campGallery/campGalleryImg13.jpg"
               alt="Camp Image" class="gallery-image" style="grid-area: img13;">
            </a>
            <a href="<%=contextPath %>/resources/img/campGallery/campGalleryImg14.jpg"
               data-fancybox="gallery" class="gallery-link"> <img
               src="<%=contextPath %>/resources/img/campGallery/campGalleryImg14.jpg"
               alt="Camp Image" class="gallery-image" style="grid-area: img14;">
            </a>
            <a href="<%=contextPath %>/resources/img/campGallery/campGalleryImg15.jpg"
               data-fancybox="gallery" class="gallery-link"> <img
               src="<%=contextPath %>/resources/img/campGallery/campGalleryImg15.jpg"
               alt="Camp Image" class="gallery-image" style="grid-area: img15;">
            </a>
         </div>

      </div>
      <div class="mainAnnouncement">
         <div>
            <p>
               <span>공지사항</span>
            </p>
            <div class="mainAnnouncementTextContainer">
			<jsp:include page="./admin/mainList.jsp" />
		</div>
         </div>
      </div>
   </div>
   <footer>
      <jsp:include page='layout/footer.jsp'>
         <jsp:param name="pageName" value="footer" />
      </jsp:include>
   </footer>

   <!-- Fancybox JS -->
   <script
      src="https://cdnjs.cloudflare.com/ajax/libs/fancybox/3.5.7/jquery.fancybox.min.js"></script>

   <script>
      $(document).ready(function() {
         // Fancybox 설정
         $(".gallery-link").fancybox({
            // 라이트박스 옵션
            loop : true,
         // 다른 옵션들
         });
      });
   </script>

</body>
</html>