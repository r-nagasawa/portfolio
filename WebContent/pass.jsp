<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>editPass</title>
<link rel="stylesheet" type="text/css" href="Main.css">
<script src="Check.js" type="text/javascript" charset="UTF-8"></script>
</head>
<body>
	<h2>パスワード変更</h2>
	<form action="UpdatePassServlet" method="post" name="edit">
		<table border="1">
			<tr>
				<th>PassWord</th><td><input type="text" name="pass" value=""></td>
			</tr>
		</table>
		<p>パスワードを変更します</p>
		<p>よろしいですか？</p>
		<button name="btn" value="yes" onClick="return editCheck()">はい</button>
		<button name="btn" value="no">いいえ</button>
		<input type="hidden" name="code" value="${user.id}">
	</form>
</body>
</html>