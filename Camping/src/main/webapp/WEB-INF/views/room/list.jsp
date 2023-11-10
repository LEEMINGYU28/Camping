<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%String contextPath = request.getContextPath(); %>
<html>
<head>
    <title>Room List</title>
</head>
<body>
    <h2>Room List</h2>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="room" items="${rooms}">
                <tr>
                
                    <td> ${room.id}</td>
                    <td><a href="<%= contextPath %>/rooms/${room.id}">${room.roomName}</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
    <a href="<%= contextPath %>/rooms/add">Add Room</a>
</body>
</html>
