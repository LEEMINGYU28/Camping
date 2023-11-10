<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%String contextPath = request.getContextPath(); %>
<html>
<head>
    <title>Add Room</title>
</head>
<body>
    <h2>Add Room</h2>
    <form action="/camping/rooms/add" method="post">
        <label for="roomName">Name:</label>
        <input type="text" id="roomName" name="roomName" required>
        <br>
        <label for="roomDescription">Description:</label>
        <input type="text" id="roomDescription" name="roomDescription">
        <br>
        <label for="roomPrice">Price:</label>
        <input type="text" id="roomPrice" name="roomPrice" required>
        <br>
        <input type="submit" value="Add Room">
    </form>
    <br>
    <a href="<%= contextPath %>/rooms/list">Back to List</a>
</body>
</html>
