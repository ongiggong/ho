<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<meta charset="EUC-KR">
<title>회원 관리</title>
</head>
<body>
	<h1>관리자 페이지</h1>
	<style>
	table {
		border-collapse:collapse;
	}
	table tr th {
		font-weight:700;
	}
	table tr td, table tr th {
		border:1px solid #818181;
		width:200px;
		text-align:center;
	}
</style>
<body>

	<h1>회원 목록</h1>
	<table>
		<tr>
			<td colspan="3">전체 회원 수 : ${usercount}
		</td>

		
		<tr>
			<th>ID</th>
			<th>권한</th>
			<th>권한 부여</th>
		</tr>

	<c:forEach var="user" items="${list}">
	   	<tr>
      		<td><a href="/userDetail/${user.username}">${user.username}</a></td>
      		<td>${user.uAuth}</td>
      		<td><input type="button" class="A" value="운영자 권한부여" username="${user.username}"></td>
       	</tr>
    </c:forEach>
	</table>
<form method="post" name="frm" id="frm" action="/setAuth">
	<input type="hidden" name="username" id="username" value="">
</form>
<script>
$(document).on('click', '.A', function() {
	if(confirm('이 회원에게 운영자 권한을 부여하시겠습니까?')) {
	let username = $(this).attr('username');
	$('#username').val(username);
	$('#frm').submit();
	}
	
	/* console.log($(this).attr('username'));
	alert($(this).attr('username'));
	
	$(this).attr('auth');
	 */
	
})
</script>
</body>
</html>
	