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

<style type="text/css">
.container {
    max-width: 800px;
    margin: 0 auto;
    padding: 20px;
}

.camping-list {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
}

.camping-item {
    border: 1px solid #ddd;
    border-radius: 8px;
    margin: 10px;
    padding: 15px;
    text-align: center;
    background-color: #fff;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.camping-name {
    font-size: 1.2em;
    color: #007BFF;
    margin-bottom: 10px;
}

.camping-price {
    font-weight: bold;
    color: #28a745;
}
</style>

</head>
<body>
    <div class="container">
        <h1>예약 가능한 캠핑장 목록</h1>

        <div class="camping-list">
            <c:forEach items="${products}" var="product">
                <div class="camping-item">
                    <p class="camping-name"><a href="<c:url value='/deepReserve/${product.id}'/>">${product.name}</a></p>
                    <p class="camping-price">${product.price}원</p>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>
