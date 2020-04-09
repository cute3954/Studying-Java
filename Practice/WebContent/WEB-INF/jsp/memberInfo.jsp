<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Member" %>
<!-- リクエストスコープに保存されたmemberを取得 -->
<% Member member = (Member) request.getAttribute("member"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ラブライブ！サンシャイン！</title>
</head>
<body>
	<img alt="<%= member.getMember_name() %>" src="<%= member.getMember_image_fileurl() %>">
	<p>
		<%= member.getMember_name() %><br>
		<%= member.getMember_name_hurigana() %><br>
		<%= member.getMember_name_eng() %><br>
		学年：　<%= member.getMember_grade() %>年生<br>
		誕生日：　<%= member.getMember_birthday() %><br>
		血液型：　<%= member.getMember_bloodType() %>型<br>
		身長：　<%= member.getMember_height() %>cm<br>
		趣味：　<%= member.getMember_hobby() %><br>
		特技：　<%= member.getMember_skill() %><br>
	</p>
</body>
</html>