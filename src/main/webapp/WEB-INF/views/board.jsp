<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Board List</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>

<body>
	<table width="1000" border="1">
	<h2>자유 게시판</h2>
	<input type="button" value="메인화면으로" id=btn-main><div style="text-align:center"><p><input type="button" value="글쓰기" id=btn-write></p></div>
	
		<%-- <tr>
		<td colspan="3">전체 게시글 수 : ${contentcount }</td> --%>
		<tr>
				<th>글번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>날짜</th>
		</tr>
		<tr>
		<c:forEach var="list" items="${list}"> 
				<th>${list.idx}</th>
				<th>${list.id}</th>
				<th><a href="/JSPBook/content.ho?idx=${list.idx}&page=${pagination.page}">${list.title}</a></th>
				<th>${list.uploadtime}</th>
				
		</tr>
		
		<tr>
		</c:forEach>
		</tr>
		</table>
		
		
<div>
	<ul>
		 <c:choose>

			<c:when test="${ pagination.page > 5}">
				<li>
					<a href="board.ho?page=${pagination.prevPage}">
						◀
					</a>
				</li>
			</c:when>
		</c:choose> 
		<c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">
			
				<c:choose>
					<c:when test="${ pagination.page eq i }">
						
						<li style="background-color:#ededed;">
							<span>${i}</span>
						</li>
					</c:when>
					<c:when test="${ pagination.page ne i }">
						<li>
							<a href="board.ho?page=${i}">${i}</a>
						</li>
					</c:when>
				</c:choose>
		</c:forEach>
		 <c:choose>
			<c:when test="${ pagination.nextPage lt pagination.lastPage }">
				<li style="">
					<a href="board.ho?page=${pagination.nextPage}">▶</a>
				</li>
			</c:when>
		</c:choose> 
		
	</ul>
</div>



	<script>
$(function () {

	$(document).on('click', '#btn-write', function () {
		location.href = "/JSPBook/write.ho";
	});


	$(document).on('click', '#btn-main', function () {
		location.href = "/JSPBook/main.ho";
	});
	
});
</script>

</body>
<style>
	ul {
		width:400px;
		height:50px;
		margin:10px auto;
	}
	li {
		list-style:none;
		width:50px;
		line-height:50px;
		border:1px solid #ededed;
		float:left;
		text-align:center;
		margin:0 5px;
		border-radius:5px;
	}
</style>


</html>