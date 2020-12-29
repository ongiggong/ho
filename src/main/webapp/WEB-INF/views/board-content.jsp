<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/function" prefix="c"%> --%>
<html>
<head>
	<title>${content.title}</title>	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
	
<div>
	<h1>
		${content.title} 
		<span style="margin-left: 50px; font-size: 10pt;">
			작성자: ${content.id} 날짜: ${content.uploadtime}
		</span>
		<span style="margin-left: 20px;">
			<input type="button" value="목록으로" id="btn-list">
		</span>
	</h1>
</div>
<div style="margin-top: 100px; margin-bottom:300px;">
	${content.text}
</div>
	
<sec:authentication property="principal.username" var="sessionId"/>
<sec:authentication property="principal.authorities" var="auth"/>
<c:if test= "${content.id == sessionId || auth == '[ROLE_운영자, ROLE_회원]'}">
	<div>
		<input type="button" value="수정하기" id="btn-update">
		<input type="button" value="삭제하기" id="btn-delete">
	</div>
</c:if>

<form method="post" action="/comment/${content.idx}">
<div>
	<input type="hidden" name="c_id" value="${sessionId}">
	<input type="hidden" name="c_ref" value="${content.idx}">
</div>
<div style ="margin-top: 40px; margin-bottom: 40px">
	<span style="font-size: 13pt">댓글:</span>
	<textarea name="c_comment" rows="2" cols="50"></textarea>
	<input type="submit" value="등록">
</div>
</form>

<div id="CL">
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
</div>


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
				data: { c_idx: idx, c_comment: commentValue, c_ref: "${content.idx}" }
			})
			.done(function( data ) {
				
			 	$("#CL").html(data);
				
				 
				
				
			})
			.fail(function(e) {
				console.dir(e);
				
			})
						
		
		}
		
	});
});
</script>
</body>
</html>