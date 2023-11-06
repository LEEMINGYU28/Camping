<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약</title>
<link href="resources/styles/payment/reserve.css" rel="stylesheet" />

</head>
<body>
	<header>
		<jsp:include page='../layout/header.jsp'>
			<jsp:param name="pageName" value="header" />
		</jsp:include>
	</header>

	<div>
		<div class="reserveImg">
			<div class="text_wrap">
				<h1>/ 캠핑장예약 /</h1>
			</div>
		</div>

		<div class="CampImgContainer">
			<h1>캠핑장 배치도</h1>
			<div class="campImg"></div>
		</div>

		<div class="campExamContainer">
			<div class="campExam">
				<p>캠핑장 배치도 보는법</p>
				<p>(예)A1-1파쇄석</p>
				<p>A1(단지번호)1(1번자리)파쇄석이란뜻 입니다</p>
				<p>실시간예약에서 다음달 보기는 버튼을 누른후 5초정도 기다려주세여 이미지가 많아 사이트반응이 느립니다</p>
			</div>
		</div>

		<div id="reserveNotice">
			<h1>실시간예약</h1>
		</div>

		

		<div>
			<jsp:include page='../layout/calendar.jsp'>
				<jsp:param name="pageName" value="calendar" />
			</jsp:include>
		</div>
	</div>
	<div>
        <button onclick="goToDeepReserve()">심층 예약으로 이동</button>
    </div>

	<footer>
		<jsp:include page='../layout/footer.jsp'>
			<jsp:param name="pageName" value="footer" />
		</jsp:include>
	</footer>


	<script>
		window.onload = function() {
			var urlParams = new URLSearchParams(window.location.search);
			var scrollToReserve = urlParams.get('scrollToReserve');

			if (scrollToReserve === 'true') {
				var reserveNotice = document.getElementById('reserveNotice');
				if (reserveNotice) {
					reserveNotice.scrollIntoView();
				}
			}
		};
		
		
		 function goToDeepReserve() {
		        window.location.href = 'deepReserve'; // 실제 deepReserve.jsp 파일의 경로
		    }
	</script>
</body>


</html>