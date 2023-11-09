<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:if test="${currentPage > 1}">
    <a href="<c:url value='/main/${currentPage - 1}' />">이전 페이지</a>
</c:if>
<table>
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
                <td><a href="<c:url value='/main/view/${notice.id}' />">${notice.title}</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<c:if test="${currentPage < totalPages}">
    <a href="<c:url value='/main/${currentPage + 1}' />">다음 페이지</a>
</c:if>


