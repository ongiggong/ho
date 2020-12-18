<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>글쓰기</title>
</head>
<body>
	
	<form method="post" action="/post">
		<input type="hidden" name="id" value="${session.username}">
		<p><h3>제목:&nbsp;&nbsp;<input type="text" name="title"></p>
		<p>내용:</p> 
		<p><textarea name="text" rows="50" cols="50"></textarea></p>
		
		<input type="submit" value="등록">
	</form>
</body>
</html>
