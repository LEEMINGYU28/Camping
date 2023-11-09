
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% String contextPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
    <!-- 스타일 및 스크립트 태그들은 생략 -->
</head>
<body>
    <div class="container">
        <h1>사용자 상세 정보</h1>
        <table>
            <tr>
                <td>ID:</td>
                <td>${user.id}</td>
            </tr>
            <tr>
                <td>이름:</td>
                <td>${user.name}</td>
            </tr>
            <tr>
                <td>사용자 ID:</td>
                <td>${user.userId}</td>
            </tr>
            <tr>
                <td>가입일:</td>
                <td>${user.createdAt}</td>
            </tr>
        </table>
        <a href="<%= contextPath %>/userList">목록으로 돌아가기</a>
        <a href="<%= contextPath %>/notices">관리자페이지</a>
    </div>
</body>
</html>
