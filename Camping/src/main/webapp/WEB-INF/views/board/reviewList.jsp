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
		<div id="board-list">
					<div class="container">
						<table class="board-table">
							<thead>
								<tr>
									<th scope="col" class="th-num">번호</th>
									<th scope="col" class="th-title">제목</th>

								</tr>
							</thead>
							<tbody>
									<c:forEach items="${reviews}" var="review">
								<tr>
									<td>${review.id}</td>
									<th>
									<a href="#!">${review.title}</a>
									</th>
								  <td>
                                <img src="file:///C:/Users/KGA/git/img/${review.imageFilename}" alt="${review.title} 이미지">
                            </td>
								</tr>	
								</c:forEach>
							</tbody>
						</table>
						<a href="reviewCreate">글쓰기</a>
						<%-- <jsp:include page="./reviewList.jsp"/> --%>
					</div>
				</div>

</body>
</html>