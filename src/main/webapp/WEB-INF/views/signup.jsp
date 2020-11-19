<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
    <h1>회원 가입</h1>
        <hr>
		
		<form method="post" action="/signup">
		
		<p>아이디   : <input type="text" name="username">
		<p>비밀번호: <input type="password" name="password">
		<p>이름      : <input type="text" name="uName">
		<p>생년월일: <input type="text" name="uAge">
		<p>이메일   : <input type="text" name="uEmail">
		<p>전화번호: <input type="text" name="uPhone1" size="5"> - <input type="text" name="uPhone2" size="5"> - <input type="text" name="uPhone3" size="5"><br/>
		

		
		
		<p><input type="submit" value="가입하기">	
        <%-- <form action="/signup" method="post">
        <!--  csrf  -->
           <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <input type="text" name="username" placeholder="id 입력">
            <input type="text" name="uName" placeholder="name 입력">
            <input type="password" name="password" placeholder="password 입력">
            <button type="submit">가입하기</button>
        </form> --%>
</body>
</html>
