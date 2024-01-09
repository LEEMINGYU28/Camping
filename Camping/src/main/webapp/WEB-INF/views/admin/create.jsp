<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>새로운 공지사항 작성</title>
</head>
<body>
    <h1>새로운 공지사항 작성</h1>
 
    <form action="/notices/create" method="post">
    	<input type="hidden" name="id" value="${notice.id }">
        <input type="text" name="title" placeholder="제목">
        <textarea name="content" placeholder="내용"></textarea>
        <button type="submit">Create Notice</button>
    </form>
  
    <a href="/admin">뒤로 가기</a>
</body>
</html>
