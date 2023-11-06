<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 완료</title>
<link href="resources/styles/successReserve.css" rel="stylesheet" />

</head>
<body>

	<header>
		<jsp:include page='../../layout/header.jsp'>
			<jsp:param name="pageName" value="header" />
		</jsp:include>
	</header>


		<div class="successContainer">
			<h1>예약 확인</h1>
			<div class="reservation-info">
				<p>
					<strong>입금계좌 안내:</strong> 농협 3553131939373
				</p>
				<p>
					<strong>입금 예정 금액:</strong> 70,000원
				</p>
				<p>
					<strong>예약번호:</strong> 202311034421216
				</p>
				<p>
					<strong>입금 기간:</strong> 2023-11-03 22:53까지
				</p>
			</div>
			<div class="reservation-details">
				<h2>예약신청 정보</h2>
				<img src="resources/img/successReserve.jpg" alt="예약 상품 이미지">
				<table>
					<tr>
						<th>예약 기간</th>
						<td>2023-11-21 ~ 2023-11-22</td>
					</tr>
					<tr>
						<th>합계</th>
						<td>70,000원</td>
					</tr>
				</table>
			</div>
			 <a href="./main" class="homeButton">홈으로</a>
		</div>
	


	<footer>
		<jsp:include page='../../layout/footer.jsp'>
			<jsp:param name="pageName" value="footer" />
		</jsp:include>
	</footer>

</body>
</html>