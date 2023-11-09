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
<link href="<%= contextPath %>/resources/styles/layout/footer.css" rel="stylesheet"/> 
<link href="./resources/styles/layout/footer.css" rel="stylesheet"/> 
</head>
<body>
<footer class="camping-footer">
    <div class="container">
        <div class="footer-content">
            <img src="<%= contextPath %>/resources/img/categorys/campingLogo3.jpg" alt="Campfire Icon">
            <p>Contact us: contact@campingsite.com</p>
            <ul>
                <li><a href="/about">About us</a></li>
                <li><a href="/terms">Terms of Service</a></li>
                <!-- 다른 링크들 추가 -->
            </ul>
        </div>
    </div>
</footer>
	<!-- <div class="footerContainer">
		<p>campingKPL</p>
		<p>예약대표번호 : 010-1234-5678 휴대전화 010-1234-5678</p>
		<p>Copyright © 플랜디자인. All Rights Reserved 이메일주소
			asdasdasd@naver.com 입금계좌 우리은행 123-123213-12321</p>
	</div> -->
</body>
</html>