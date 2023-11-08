<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>

<link rel="shortcut icon" href="resources/img/boards/favicon.ico" type="image/x-icon">
<link rel="icon" href="resources/img/boards/favicon.ico" type="image/x-icon">

</head>
<body>
	<h1>Product</h1>
	<div>
		<p>Product ID: ${product.productId}</p>
		<p>Product Name: ${product.productName}</p>
		<p>Available: ${product.available}</p>
		<p>Price: ${product.price}</p>
		<p>Details: ${product.details}</p>
		<p>Image Path: ${product.imgPath}</p>
	</div>
</body>
</html>