<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>result</title>
<link rel="stylesheet" type="text/css" href="Main.css">
<style>
p{
	color: red;
}
</style>
</head>
<body>
	<h2>処理結果</h2>
	<p>${message}</p>
	<br>
	<Input type="button" value="管理ページに戻る" onClick="location.href='ManageServlet'">
</body>
</html>