<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>タイムライン</title>
</head>
<body>
<jsp:include page="header.jsp" />

<h1>タイムライン</h1>

<div class="posts-container">
    <c:forEach var="post" items="${posts}">
        <div class="post-item">
            <p><strong><c:out value="${post.user.email}" /></strong></p>
            <p><c:out value="${post.content}" /></p>
            <p class="timestamp"><c:out value="${post.createdAt}" /></p>
        </div>
        <hr>
    </c:forEach>
</div>
</body>
</html>