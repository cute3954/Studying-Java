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
	<%
		if (member.getMember_image_fileurl() != null) {
	%>
		<img alt="<%= member.getMember_name() %>" src="<%= member.getMember_image_fileurl() %>">
	<%
		} else {
		// 画像がない場合
		// 画像をアップロードできるようにし、選択されたファイルをプレビュー表示する
	%>
	<form action="UploadMemberImage" method="post" enctype="multipart/form-data">
		<input type="file" id="_uploadImage" name="member_imagefile"/><br>
		<div id="_previewArea"></div>
		<input type="hidden" name="member_no" value="<%= member.getMember_no() %>"/>
		<input type="submit" value="画像をアップロードする">
	</form>
	<%
		}
	%>	
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
<!-- jsファイル -->
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/member_image_upload.js"></script>
</body>
</html>