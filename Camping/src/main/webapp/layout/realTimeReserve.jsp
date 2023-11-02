<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="./resources/styles/realTimeReserve.css" rel="stylesheet" />
<script>
  function redirectToReservePage() {
    window.location.href = './reserve'; // reserve 페이지의 URL로 변경해야 합니다.
  }
</script>
</head>
<body>
	<div>
		<button onclick="redirectToReservePage()">실시간 예약하기</button>
	</div>
</body>
</html>