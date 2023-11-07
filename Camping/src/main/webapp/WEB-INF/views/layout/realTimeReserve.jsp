<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String contextPath = request.getContextPath();  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link href="<%= contextPath %>/resources/styles/layout/realTimeReserve.css" rel="stylesheet" />
  <script>
    function redirectToReservePage() {
      window.location.href = '<%= contextPath %>/reserve#reserveNotice'; 
    }
  </script>
</head>
<body>
  <div>
    <button onclick="redirectToReservePage()">실시간 예약하기</button>
  </div>
</body>
</html>