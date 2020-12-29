<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication property="principal.username" var="sessionId"/>
<sec:authentication property="principal.authorities" var="auth"/>
<c:forEach var="vo" items="${list}"> 
		<div class="commentList" style="margin-bottom: 10px">
			
			<span class = "c_id" style="margin-right: 50px; font-weight: bold">${vo.c_id}</span>
			<span class = "c_comment" style="margin-right: 50px; color: green">${vo.c_comment}</span>
			<span class = "c_date" style="margin-right: 15px; font-size: 10pt">${vo.c_date}</span>
			
		
			<c:if test="${vo.c_id == sessionId}">
				<a href="#" uri="" class="a-update" c_idx="${vo.c_idx}" id = "reply" style="font-size: 9pt; font-weight: bold" >수정</a>
				<a href="/commentDel/${vo.c_idx}" style="font-size: 9pt; font-weight: bold" >삭제</a>
			</c:if>
		</div>			
	</c:forEach>