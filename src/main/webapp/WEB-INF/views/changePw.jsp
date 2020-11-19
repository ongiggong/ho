<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<meta charset="UTF-8">
	<title>비밀번호 변경</title>
</head>
<body>
   <form method="post" name="frm" action="/pwUpdate">
  <p>새 비밀번호   :  <input type="password" name="password">
  <p>비밀번호 확인:  <input type="password" name="password2">
  <input type="hidden" name="username" value="${list.username}">      
  <p><input type="button" value="변경하기" onclick="change()"> 
   </form>    

<script>   
function change(){
		var frm = document.frm;
		var password = frm.password.value;
		var password2 = frm.password2.value;

		if(password != password2) {
			alert("입력한 두 비밀번호가 일치하지 않습니다.")
		} else{
			frm.submit();
		}
} 
	
		 
</script>   
</body>
</html>
