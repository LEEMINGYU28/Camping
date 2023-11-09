<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String contextPath = request.getContextPath();
%>
<script type="text/javascript"
	src="<%=contextPath%>/resources/script/notice.js"></script>
<link
	href="<%=contextPath%>/resources/styles/board/mainAnnouncement.css"
	rel="stylesheet" />

	<div id="board-list">
		<div class="container">
			<table class="board-table">

				<thead>
					<tr>
						<th scope="col" class="th-num">No</th>
						<th scope="col" class="th-title">제목</th>
						<th scope="col"  class="th-write">작성자</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${notices}" var="notice">
						<tr>
							<td> ${notice.id}</td>
							<td><a href="javascript:void(0);"
								onclick="openModal('${notice.title}', '${notice.content}', '${notice.admin.name}', '${notice.createdAt}')">
									${notice.title} </a></td>
									<td>${notice.admin.name}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<c:if test="${currentPage > 1}">
				<a href="<c:url value='/main/${currentPage - 1}' />">이전 페이지</a>
			</c:if>
			<c:if test="${currentPage < totalPages}">
				<a href="<c:url value='/main/${currentPage + 1}' />">다음 페이지</a>
			</c:if>

		</div>
	</div>
<div id="noticeModal" class="modal">
	<div class="modal-content">
		<span class="close" id="modalClose" onclick="closeModal()">&times;</span>
		  <h2 id="modalTitle"></h2>
        <p id="modalContent"></p>
        <p id="modalAuthorDate"></p>
	</div>
</div>