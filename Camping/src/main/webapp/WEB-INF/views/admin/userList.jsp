<%-- userList.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <!-- 스타일 및 스크립트 태그들은 생략 -->
</head>
<body>
    <div class="container">
        <h1>회원 목록</h1>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>이름</th>
                    <th>사용자 ID</th>
                    <th>가입일</th>
                    <th>상세보기</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.userId}</td>
                        <td>${user.createdAt}</td>
                        <td><a href="/camping/notices/viewUser?id=${user.id}">상세보기</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
