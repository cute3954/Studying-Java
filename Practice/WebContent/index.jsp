<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ラブライブ！サンシャイン！</title>
</head>
<body>
<h1>メンバー紹介</h1>
<form action="MemberInfo" method="post">
	<input type="text" name="member_no">
	<input type="submit" value="自己紹介を見よう">
</form>
</body>
</html>