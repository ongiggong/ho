<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원 상세</title>
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
	a {
		text-decoration:none;
		color:#000;
		font-weight:700;
	}
</style>
<body>
<table> 
		<tr>
			<td>회원 ID</td>
			<td>${list.username}</td>		
		</tr>
		<tr>
			<td>회원 이름</td>
			<td>${list.uName}</td>		
		</tr>
		<tr>
			<td>생년월일</td>
			<td>${list.uAge}</td>		
		</tr>
		<tr>
			<td>이메일</td>
			<td>${list.uEmail}</td>		
		</tr>
		<tr>
			<td>전화번호</td>
			<td>${list.uPhone1}-${list.uPhone2}-${list.uPhone3}</td>
		</tr>
</table>
</body>
</html>
