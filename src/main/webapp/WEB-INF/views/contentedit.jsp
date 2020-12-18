<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
	<title>글 수정</title>
	<meta charset="UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>

		<form method="post" action="/contentUp">
		<input type="hidden" name="idx" value="${content.idx}">
		<sec:authentication property="principal.username" var="sessionId"/>
		<input type="hidden" name="id" value="${sessionId}">
		<p><h3>제목:&nbsp;&nbsp;<input type="text" name="title" value="${content.title}"></p>
		<p>내용:</p> 
		<p><textarea name="text" rows="50" cols="50">${content.text}</textarea></p>
		
		<input type="submit" value="등록">
		</form>
</body>
</html>