<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>공지사항 목록</title>
</head>
<body>
    <h1>공지사항 목록</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>제목</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${notices}" var="notice">
                <tr>
                    <td>${notice.id}</td>
                    <td><a href="notices/${notice.id}">${notice.title}</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="notices/create">새로운 공지사항 작성</a>
</body>
</html>
