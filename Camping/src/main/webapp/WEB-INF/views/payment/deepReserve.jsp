<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약날짜 선택 및 결제</title>
<link href="<%=contextPath%>/resources/styles/payment/deepReserve.css"
	rel="stylesheet" />

<link rel="shortcut icon"
	href="<%=contextPath%>/resources/img/boards/favicon.ico"
	type="image/x-icon">
<link rel="icon"
	href="<%=contextPath%>/resources/img/boards/favicon.ico"
	type="image/x-icon">

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
				<c:if test="${not empty selectedProduct}">
					<div>
						<h3>Name: ${selectedProduct.name}</h3>
						<h4>캠핑장 상세정보</h4>
						<p>${selectedProduct.detail}</p>
						<p>가격: ${selectedProduct.price}원</p>
						<!-- Add more details as needed -->
					</div>
				</c:if>
			</div>

		</div>

		<div class="detail">
			<div>
				<button onclick="goToSuccessReserve()">예약하기</button>
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
			window.location.href = '/camping/paymentpage';
		}
	</script>

</body>


</html>