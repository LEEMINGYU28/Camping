<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
 <% String contextPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CAMP</title>
<link href="<%=contextPath %>/resources/styles/main.css" rel="stylesheet" />

<link rel="shortcut icon" href="<%=contextPath %>/resources/img/boards/favicon.ico" type="image/x-icon">
<link rel="icon" href="<%=contextPath %>/resources/img/boards/favicon.ico" type="image/x-icon">

</head>
<body>
   <h1>Product Details</h1>
   <div>

      <c:forEach items="${products}" var="product">
         <div>
            <p>${product.name}</p>
            <p>${product.price}원</p>
            <p>${product.available}</p>
            <p>${product.date}</p>
         </div>
      </c:forEach>
   </div>
</body>
</html>