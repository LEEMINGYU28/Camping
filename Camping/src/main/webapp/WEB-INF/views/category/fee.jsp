<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이용요금</title>
<link href="resources/styles/category/fee.css" rel="stylesheet" />

<link rel="shortcut icon" href="resources/img/boards/favicon.ico" type="image/x-icon">
<link rel="icon" href="resources/img/boards/favicon.ico" type="image/x-icon">

</head>
<body>
	<header>
		<jsp:include page='../layout/header.jsp'>
			<jsp:param name="pageName" value="header" />
		</jsp:include>
	</header>
	<div class="container">
		<div class="feeImg"></div>
	</div>
	<footer>
		<jsp:include page='../layout/footer.jsp'>
			<jsp:param name="pageName" value="footer" />
		</jsp:include>
	</footer>
</body>
</html>