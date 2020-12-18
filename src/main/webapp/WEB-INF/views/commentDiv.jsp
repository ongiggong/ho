<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>

<body>
<div class="commentList">
<span class = "c_id">${vo.c_id}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<span class = "c_comment">${vo.c_comment}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<span class = "c_date">${vo.c_date}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<c:if test="${vo.c_id == sessionId}">
	<a href="#" uri="" class="a-update" c_idx="${vo.c_idx}" id = "reply">수정</a>&nbsp;
	<a href="/commentdel/${vo.c_idx}">삭제</a>
</c:if>

<div style="padding-top: 10px;">
		
</div>
</div>
			

</body>
</html>