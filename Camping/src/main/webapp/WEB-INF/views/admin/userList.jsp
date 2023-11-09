
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
  String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
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
                        <td><a href="<%=contextPath %>/viewUser/${user.id}">상세보기</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
         <a href="<%= contextPath %>/notices">관리자페이지</a>
    </div>
</body>
</html>
