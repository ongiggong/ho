<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Ho</title>
</head>
<body>
	<h1>Home Page</h1>
 	 <hr>
     <div>
      <sec:authorize access="isAnonymous()">
     	 <a href="/login">로그인</a>
         <a href="/beforeSignUp">회원가입</a>
      </sec:authorize>
       <sec:authorize access="isAuthenticated()">    
       <sec:authentication property="principal" var="principal"/>    
	        <a href="/logout">로그아웃</a> 
	       	<a href="/user/info/${principal.username}">내 정보</a>
	        <a href="/admin">관리자</a>
	       	 <h2>${principal.uName}님 반갑습니다.</h2>
            </sec:authorize>
      
     </div>
     <div>
     		<sec:authorize access="isAuthenticated()">        
              
			<a href="/board">게시판</a>
            </sec:authorize>
	 </div>
</body>
</html>
