<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>회원정보</title>
	<meta charset="UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
	
<body>	
	<form action="/update" id="form-update" method="post">
	<p>아이디    : <input type="text" name="username" value="${list.username}" readonly>
	<p>이름: <input type="text" name="uName" value="${list.uName}" readonly>
	<p>생년월일 : <input type="text" name="uAge" value="${list.uAge}" readonly>
	<p>이메일 : <input type="text" name="uEmail" value="${list.uEmail}">
	<p>전화번호 : <input type="text" name="uPhone1" value="${list.uPhone1}" size="5"> - <input type="text" name="uPhone2" value="${list.uPhone2}" size="5"> - <input type="text" name="uPhone3" value="${list.uPhone3}" size="5"><br/>
	<p><button type="button" id="change-pw">비밀번호 변경하기</button>
	<p><button type="button" id="btn-update">회원정보 수정하기</button> ※ 위의 정보들을 수정 후 클릭
	</form>
		
	
		
	<p><button type="button" id="btn-delete">회원 탈퇴하기</button></p>
		
<script>


	$(document).on('click', '#change-pw', function () {
		location.href = "/changePw/${list.username}";
	});

	$(document).on('click', '#btn-update', function() {
		$('#form-update').attr('action', '/update');
		$('#form-update').submit();
	});


	$(document).on('click', '#btn-delete', function () {
		$('#form-update').attr('action', '/userDelete');
		if(confirm('회원정보를 삭제하고 탈퇴하시겠습니까?')) 
			$('#form-update').submit();
		
	});
	
</script>


	
</body>
</html>