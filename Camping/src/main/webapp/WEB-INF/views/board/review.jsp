
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이용후기</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript"
	src="<%=contextPath%>/resources/script/review.js"></script>
<link href="<%=contextPath%>/resources/styles/board/review.css"
	rel="stylesheet" />
<link rel="shortcut icon" href="resources/img/boards/favicon.ico"
	type="image/x-icon">
<link rel="icon" href="resources/img/boards/favicon.ico"
	type="image/x-icon">

<script>
	window.onload = function() {
		let currentPage = window.location.href;

		if (currentPage.indexOf("../board/review") !== -1) {
			document.getElementById("reviewBox").style.backgroundColor = "navy";
			document.getElementById("reviewBox").style.color = "white";
			document.getElementById("noticeBox").style.backgroundColor = "white";
			document.getElementById("noticeBox").style.color = "black";
		}
	}
	function goToPage(pageURL) {
		window.location.href = pageURL;
	}
	
</script>
</head>
<body>
	<header>
		<jsp:include page='../layout/header.jsp'>
			<jsp:param name="pageName" value="header" />
		</jsp:include>
	</header>

	<div>
		<div class="reviewImg">
			<div class="text_wrap">
				<h1>/ 이용후기 /</h1>
			</div>
		</div>

		<div class="boxContainer">
			<div class="box" id="noticeBox"
				onclick="goToPage('<%=contextPath%>/announcement/1')">공지사항</div>
			<div class="box" id="reviewBox"
				onclick="goToPage('<%=contextPath%>/review')">이용후기</div>
		</div>

		<section class="notice">
			<div class="reviewNotice">
				<div class="container">
					<h3>이용후기</h3>
				</div>
			</div>

			<div class="reviewTextContainer">
				<div id="board-list">
					<div class="container">
						<table class="board-table">
							<c:if test="${currentPage > 1}">
								<a href="<c:url value='/review/${currentPage - 1}' />"><span
									class="arrow-prev"> </span></a>
							</c:if>
							<thead>
								<tr>
									<th scope="col" class="th-num">번호</th>
									<th scope="col" class="th-title">제목</th>
									<th scope="col" class="th-name">작성일</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${reviews}" var="review">
									<tr>
										<td>${review.id}</td>
										<td><a href="javascript:void(0);"
											onclick="openModal (
											'${review.title}',
											'${review.content}',
											'${pageContext.request.contextPath}/resources/uploadimg/${review.imageFilename}',
											${review.id})"
											data-review-id="${review.id}"> ${review.title} </a></td>
										<td>${review.createdAt}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<a class="create_btn" type="button"
							href="<%=contextPath%>/reviewCreate">글쓰기</a>
						<c:if test="${currentPage < totalPages}">
							<a href="<c:url value='/review/${currentPage + 1}' />"><span
								class="arrow-next" /></span></a>
						</c:if>
					</div>
				</div>
			</div>
		</section>

	</div>

	<footer>
		<jsp:include page='../layout/footer.jsp'>
			<jsp:param name="pageName" value="footer" />
		</jsp:include>
	</footer>
	<script>
    var contextPath = "<%=request.getContextPath()%>";
    
    
</script>
	<div id="reviewModal" class="modal" style="display: none;">
		<div class="modal-content">
			<span class="close" id="modalClose" onclick="closeModal()">&times;</span>
			<h2 id="modalTitle"></h2>
			<p id="modalContent"></p>

			<img id="modalImage" src="" onclick=""> <a
				href="<%=contextPath%>/reviewedit/${review.id}" id="editLink"
				onclick="openEditModal()">수정</a> <a href="#" id="delete"
				onclick="deleteReview()" data-review-id="">삭제</a>
		</div>
	</div>

</body>
</html>