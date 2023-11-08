<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>insert</title>
<link rel="stylesheet" type="text/css" href="Style.css">
<script src="Check.js" type="text/javascript" charset="UTF-8"></script>

</head>
<body>
	<h2>新規ユーザー登録</h2>
	<form action="UserServlet" method="post" name="user">
		<table border="1">
			<tr>
				<th>USER NAME</th><td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>PASSWORD</th><td><input type="text" name="password"></td>
			</tr>
		</table>
		<h6>PASSWORDに使用できるのは数字のみです。</h6>
		<br>
		<button onclick="return userCheck()">登録</button>
	</form>
	<br>
	<br>
	<a href="http://localhost:8080/webExam2/LoginServlet">ログインページに戻る</a>
</body>
</html>