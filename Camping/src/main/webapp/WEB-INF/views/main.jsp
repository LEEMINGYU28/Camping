<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>너의 아지트가 되어줄게</title>
<link href="resources/styles/main.css" rel="stylesheet" />

</head>
<body>
	<jsp:include page='../../layout/header.jsp'>
		<jsp:param name="pageName" value="header" />
	</jsp:include>
	<div class="img"></div>
	<jsp:include page='../../layout/footer.jsp'>
		<jsp:param name="pageName" value="footer" />
	</jsp:include>
</body>
</html>