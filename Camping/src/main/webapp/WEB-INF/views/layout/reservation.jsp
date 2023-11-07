<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
    <h1>캠핑장 예약 달력</h1>
    <table border="1">
        <tr>
            <th>날짜</th>
            <th>캠핑장</th>
            <th>가용성</th>
            <th>가격</th>
        </tr>
        <c:forEach items="${reservations}" var="reservation">
            <tr>
                <td>${reservation.date}</td>
                <td>${reservation.campground}</td>
                <td>${reservation.availability}</td>
                <td>${reservation.price}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>