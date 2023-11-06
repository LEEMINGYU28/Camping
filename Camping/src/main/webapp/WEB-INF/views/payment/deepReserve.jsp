<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약</title>
<link href="resources/styles/payment/deepReserve.css" rel="stylesheet" />

</head>
<body>
	<header>
		<jsp:include page='../layout/header.jsp'>
			<jsp:param name="pageName" value="header" />
		</jsp:include>
	</header>

	<div>
		<div class="deepContainer">

			<div class="deepImgContainer">
				<div class="deepImg"></div>
			</div>



			<div class="calendarContainer">
				<jsp:include page='../layout/calendar.jsp'>
					<jsp:param name="pageName" value="calendar" />
				</jsp:include>
				<div class="price">
					<h4>가격등 내용80,000</h4>
				</div>
			</div>

		</div>

		<div class="detail">
			<div>
				<button onclick="goToSuccessReserve()">결제창으로 이동</button>
			</div>
		</div>


	</div>
	<footer>
		<jsp:include page='../layout/footer.jsp'>
			<jsp:param name="pageName" value="footer" />
		</jsp:include>
	</footer>

	<script>
		function goToSuccessReserve() {
			window.location.href = 'successReserve';
		}
	</script>

</body>


</html>