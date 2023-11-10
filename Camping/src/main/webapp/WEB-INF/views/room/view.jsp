<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%String contextPath = request.getContextPath(); %>
<html>
<head>
    <title>Room Details</title>
</head>
<body>
    <h2>Room Details</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
        </tr>
        <tr>
            <td>${room.id}</td>
            <td>${room.roomName}</td>
            <td>${room.roomDescription}</td>
            <td>${room.roomPrice}</td>
        </tr>
    </table>
    <br>
    <a href="<%= contextPath %>/rooms/list">Back to List</a>
</body>
</html>
