<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Profile</title>
<link rel="stylesheet" type="text/css" href="Main.css">
</head>
<body>
<h2>ユーザー情報</h2>

<table border=1>
 <tr>
 	<th>USER NAME</th><td> ${name} </td>
 </tr>
 <tr>
 	<th>PASSWORD</th>
</table>
<br>
<input type="button" value="PASSWORDを変更" onClick="location.href='ManageServlet'">
<br>
<br>
<a href="http://localhost:8080/webExam2/ManageServlet">商品管理ページに戻る</a>
</body>
</html>