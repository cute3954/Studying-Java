<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ラブライブ！サンシャイン！</title>
</head>
<body>
	<h1>メンバー紹介</h1>
	<form action="/Practice/MemberInfo" method="post">
		<input type="text" name="name">
		<input type="text" name="groupName">
		<input type="submit" value="自己紹介を見よう">
	</form>
</body>
</html>