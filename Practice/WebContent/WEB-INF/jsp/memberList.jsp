<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.Member" %>
<!-- リクエストスコープに保存されたmemberを取得 -->
<% List<Member>memberList = (List)request.getAttribute("memberList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ラブライブ！サンシャイン！</title>
</head>
<body>
<h1>メンバー紹介</h1>
<%
	if (memberList.size() > 0) {
		for (Member member:memberList) {
%>
<form action="MemberInfo" method="post">
	<div>
		<img alt="<%= member.getMember_name() %>" src="<%= member.getMember_image_fileurl() %>"/>
		<input type="hidden" name="member_no" value="<%= member.getMember_no() %>" >
		<input type="submit" value="<%= member.getMember_name() %>">
	</div>
</form>
<%
		}
	}
%>
</body>
</html>