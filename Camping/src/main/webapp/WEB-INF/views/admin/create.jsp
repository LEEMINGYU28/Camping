<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>새로운 공지사항 작성</title>
</head>
<body>
    <h1>새로운 공지사항 작성</h1>
 
<form  action="/camping/notices/create" method="post">
    <input type="hidden" name="id" value="1">
    <input type="text" name="title" value="New Title">
    <input type="text" name="content" value="New Content">
    <button type="submit">Create Notice</button>

</form>
  
    <a href="/camping/admin">뒤로 가기</a>
</body>
</html>
