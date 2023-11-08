<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Details</title>

<link rel="shortcut icon" href="resources/img/boards/favicon.ico"
	type="image/x-icon">
<link rel="icon" href="resources/img/boards/favicon.ico"
	type="image/x-icon">

</head>
<body>
	<h1>Product Details</h1>
	<div>

		<c:forEach items="${products}" var="product">
			<div>
				<p>Product ID: ${product.id}</p>
				<p>Product Name: ${product.productName}</p>
				<p>availability: ${product.availability}</p>
				<p>price: ${product.price}</p>
			</div>
		</c:forEach>
	</div>
</body>
</html>