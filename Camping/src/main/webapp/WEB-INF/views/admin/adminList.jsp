<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>공지사항 목록</h1>
<table>

  <c:if test="${currentPage > 1}">
    <a href="<c:url value='/notices/adminList/${currentPage - 1}' />">이전 페이지</a>
  </c:if>
  <thead>
    <tr>
      <th>글쓴이</th>
      <th>제목</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${notices}" var="notice">
      <tr>
        <td>${notice.admin.name}</td>
        <td><a href="<c:url value='/notices/${notice.id}' />">${notice.title}</a></td>
      </tr>
    </c:forEach>
  </tbody>
</table>
<c:if test="${currentPage < totalPages}">
  <a href="<c:url value='/notices/adminList/${currentPage + 1}' />">다음 페이지</a>
</c:if>
