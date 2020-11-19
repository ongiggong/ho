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
     	 <a href="/login">�α���</a>
         <a href="/beforeSignUp">ȸ������</a>
      </sec:authorize>
       <sec:authorize access="isAuthenticated()">    
       <sec:authentication property="principal" var="principal"/>    
	        <a href="/logout">�α׾ƿ�</a> 
	       	<a href="/user/info/${principal.username}">�� ����</a>
	        <a href="/admin">������</a>
	       	 <h2>${principal.uName}�� �ݰ����ϴ�.</h2>
            </sec:authorize>
      
     </div>
     <div>
     		<sec:authorize access="isAuthenticated()">        
              
			<a href="/board">�Խ���</a>
            </sec:authorize>
	 </div>
</body>
</html>
