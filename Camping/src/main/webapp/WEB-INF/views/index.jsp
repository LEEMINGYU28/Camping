<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%String contextPath = request.getContextPath();  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>너의 아지트가 되어줄게</title>
<link href="<%= contextPath %>/resources/styles/index.css" rel="stylesheet" />

<title>CAMP</title>
<link href="resources/styles/index.css" rel="stylesheet" />

<link rel="shortcut icon" href="resources/img/boards/favicon.ico" type="image/x-icon">
<link rel="icon" href="resources/img/boards/favicon.ico" type="image/x-icon">

</head>
<body>
	<div class="img">
		<div class="text_wrap">
			<div class="first_ment">
				<h1
					style="text-align: center; font-family: 'pretendard-bola'; line-height: 1;">
					<span class="ment" style="font-size: 26px;">23년 너의 어느날에</span>
				</h1>
			</div>
			<div class="main_ment">
				<h1 class="ment_foint">
					<span class="ment_main" style="font_size: 28px !important;">너의
						소중한 추억이 되어줄게</span>
				</h1>
			</div>
			<div class="mainbtn">
				<a type="button" class="btn" onclick="location.href='<%= contextPath %>/main'">입장하기</a>
			</div>
		</div>
	</div>


</body>
</html>