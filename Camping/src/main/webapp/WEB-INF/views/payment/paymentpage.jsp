<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="resources/styles/payment/paymentpage.css" rel="stylesheet" />
<script type="text/javascript" src="resources/script/paymentpage.js"></script>
<title>결제 페이지</title>

<link rel="shortcut icon" href="resources/img/boards/favicon.ico" type="image/x-icon">
<link rel="icon" href="resources/img/boards/favicon.ico" type="image/x-icon">

</head>
<body>
	<div>
		<div class="wrap">
			<div class="payment_wrap">
				<header>
					<jsp:include page='../layout/header.jsp'>
						<jsp:param name="pageName" value="header" />
					</jsp:include>
				</header>
				<div class="title">
					<h1>결제하기</h1>
				</div>
				<div class="product">
					<h6>예약 상품 정보</h6>
					<div class="product_img">
						<img src="">
					</div>
					<div class="product_info">
						<div class="info_text1">예약숙소</div>
						<div class="info_text2">일정</div>
						<div class="info_text3">가격</div>
					</div>
				</div>
				<div class="order_info">
					<h6>예약자 정보</h6>
					<input class="order_name" type="text" placeholder="이름"> <input
						class="order_number" type="number" placeholder="연락처"> <input
						class="order_email" type="text" placeholder="이메일"> <input
						class="order_memo" type="text" placeholder="요청사항">
				</div>
				<div class="plus_order_info">
					<h6>추가정보 입력</h6>
					<div class="text-14" style="font-size: 14px; padding-bottom: 5px;">예약자
						성함</div>
					<input class="plus_order_name" type="text" placeholder="예약자 이름">
					<div class="text-13"
						style="font-size: 13px; padding-top: 20px; padding-bottom: 5px;">연락처</div>
					<input class="plus_order_number" type="number" placeholder="연락처">
				</div>
				<div class="top_off">
					<h6>취소/환불 규정에 대한 동의</h6>
					<table class="table text-14" style="font-size: 14px;">
						<tbody>
							<tr>
								<td class="text-gray-bright">이용 7일 전까지</td>
								<td>취소수수료없음</td>
						</tbody>
					</table>
					<input type="checkbox" class="agree">동의합니다.
				</div>
			</div>
			<div class="payment_method_wrap">
				<div class="payment_method">
					<div class="payment_info">
						<h6>최종 결제금액</h6>
						<div class="info_text1" style="font-size: 14px;">상품가격</div>
						<hr />
						<div class="info_text2" style="font-size: 14px;">총 결제금액</div>
					</div>
					<div class="payment">
						<h6>결제수단</h6>
						<input type="checkbox">무통장입금 <input class="pay_order_name"
							type="text" placeholder="입금자명">
					</div>
					<div class="payment_agree">
						<input type="checkbox">구매조건 확인 및 결제진행에 동의
						<button>결제하기</button>
					</div>
				</div>
			</div>
		</div>
		<footer>
			<jsp:include page='../layout/footer.jsp'>
				<jsp:param name="pageName" value="footer" />
			</jsp:include>
		</footer>
	</div>

</body>
</html>