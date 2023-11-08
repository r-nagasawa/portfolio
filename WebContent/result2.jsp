<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>User result</title>
<link rel="stylesheet" type="text/css" href="Style.css">
<style>
p{
	color: red;
}
</style>
</head>
<body>
	<h2>処理結果</h2>
	<p>${message}</p>
	<p>${message2}</p>
	<a href="http://localhost:8080/webExam2/LoginServlet">ログインページに戻る</a>
	<br>
	<br>
	<a href="http://localhost:8080/webExam2/UserServlet">新規ユーザー登録に戻る</a>
</body>
</html>