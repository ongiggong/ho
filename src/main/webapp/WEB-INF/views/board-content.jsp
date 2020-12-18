<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/function" prefix="c"%> --%>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
	
<title>${content.title}</title>		
<table width="1000">

<h1>${content.title}&nbsp;&nbsp;&nbsp;&nbsp;<font size="2">작성자: ${content.id}&nbsp;&nbsp;&nbsp;날짜: ${content.uploadtime}</font>
	<input type="button" value="목록으로" id="btn-list">&nbsp;&nbsp;&nbsp;&nbsp;

	<br><br><br>
	
	<font size="2">${content.text}</font>
		
	<br><br><br>
	<br><br><br>
	<br><br><br>
<sec:authentication property="principal.username" var="sessionId"/>
<sec:authentication property="principal.authorities" var="auth"/>
<c:if test= "${content.id == sessionId || auth == '[ROLE_운영자, ROLE_회원]'}">
	<input type="button" value="수정하기" id="btn-update">
	<input type="button" value="삭제하기" id="btn-delete">
</c:if>




<form method="post" action="/comment/${content.idx}">
	<input type="hidden" name="c_id" value="${sessionId}">
	<input type="hidden" name="c_ref" value="${content.idx}">
	<font size="2">댓글:&nbsp;&nbsp;<textarea name="c_comment" rows="2" cols="50"> 
</textarea>
	
<input type="submit" value="등록">
</form>
<br><br>									

<c:forEach var="vo" items="${list}"> 
<div class="commentList" id="CL">
	<%-- <jsp:include page="commentDiv.jsp"/> --%>
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
			
</c:forEach>
	
</table>

<form action="/aj-update-comment" id="frm-cmt" method="POST">
	<input type="hidden" name="c_idx">
	<input type="hidden" name="c_comment">
</form>
			
<script>


$(function () {
	$(document).on('click', '#btn-update', function () {
		location.href = "/contentedit/${content.idx}";
		
	});

	$(document).on('click', '#btn-delete', function () {
		location.href = "/contentDel/${content.idx}";
	});

	$(document).on('click', '#btn-list', function () {
		location.href = "/board/${page}"
	});


	$(document).on('click', '.a-update', function () {
		let aUpdate = $(this).parent().find('.a-update');
		let uri = aUpdate.attr('uri');
		let comment = $(this).parent().find('.c_comment');
		let form = $('#frm-cmt');
		let idx = aUpdate.attr('c_idx'); 
				
		if (uri == '') {	// 수정
			let cmtText = $(this).parent().find('.c_comment').text();	// 기존 댓글 뽑아내기
			comment.html('<input type="text" name="cmtContent" value="'+cmtText+'">'); //뽑아낸 댓글로 채워져있기
			aUpdate.text('등록'); // 버튼 이름 변경하기
			aUpdate.attr('uri', '/aj-update-comment'); // 버튼에 새로운 경로 지정해주기
			form.find('input[name="c_idx"]').val(idx);
		} else {	// 등록
			let commentValue = comment.find('input[name="cmtContent"]').val(); 
			form.find('input[name="c_comment"]').val(commentValue);

			$.ajax({
				method: "POST",
				url: "/aj-update-comment",
				dataType: "text",
				data: { c_idx: idx, c_comment: commentValue }
			})
			.done(function( data ) {

			 	$("#CL").html(data);
				comment.find('input[name="cmtContent"]').remove();
				comment.append(commentValue);
				
				comment.parent().find('.c_date').text(data);
				 
				
				
			})
			.fail(function(e) {
				console.dir(e);
				
			})
						
			//location.href = uri;
		}
		
	});
});
</script>
</body>
</html>