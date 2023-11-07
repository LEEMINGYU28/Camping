<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<table>
				<thead>
					<tr>
						<th>글쓴이</th>
						<th>제목</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${review}" var="notice">
						<tr>
							<td>${review.user.name}</td>
							<td><a href="notices/${review.id}">${review.title}</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="reviewCreate">글쓰기</a>

</body>
</html>