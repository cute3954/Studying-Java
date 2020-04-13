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
<section id="team" class="pb-5">
    <div class="container">
        <h5 class="section-title h1">メンバー紹介</h5>
        <div class="row">	
		<%
			if (memberList.size() > 0) {
				for (Member member:memberList) {
		%>
            <!-- member -->
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="image-flip" ontouchstart="this.classList.toggle('hover');">
	                <form action="MemberInfo" method="post">
	                    <div class="mainflip">
	                        <div class="frontside">
	                            <div class="card">
	                                <div class="card-body text-center">
		                                    <p><img class=" img-fluid" src="${pageContext.request.contextPath}/resources/img/<%= member.getMember_image_fileurl() %>" alt="<%= member.getMember_name() %>"></p>
		                                    <input type="submit" value="<%= member.getMember_name() %>">
		                                    <input type="hidden" name="member_no" value="<%= member.getMember_no() %>" >
		                                    <p class="card-text">This is basic card with image on top, title, description and button.</p>
		                                    <a href="#" class="btn btn-primary btn-sm"><i class="fa fa-plus"></i></a>
	                                </div>
	                            </div>
	                        </div>
	                        <div class="backside">
	                            <div class="card">
	                                <div class="card-body text-center mt-4">
	                                    <input type="submit" value="<%= member.getMember_name() %>">
	                                    <p class="card-text">This is basic card with image on top, title, description and button.This is basic card with image on top, title, description and button.This is basic card with image on top, title, description and button.</p>
	                                    <ul class="list-inline">
	                                        <li class="list-inline-item">
	                                            <a class="social-icon text-xs-center" target="_blank" href="#">
	                                                <i class="fa fa-facebook"></i>
	                                            </a>
	                                        </li>
	                                        <li class="list-inline-item">
	                                            <a class="social-icon text-xs-center" target="_blank" href="#">
	                                                <i class="fa fa-twitter"></i>
	                                            </a>
	                                        </li>
	                                        <li class="list-inline-item">
	                                            <a class="social-icon text-xs-center" target="_blank" href="#">
	                                                <i class="fa fa-skype"></i>
	                                            </a>
	                                        </li>
	                                        <li class="list-inline-item">
	                                            <a class="social-icon text-xs-center" target="_blank" href="#">
	                                                <i class="fa fa-google"></i>
	                                            </a>
	                                        </li>
	                                    </ul>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </form>
                </div>
            </div>
            <!-- ./member -->        
		<%
				}
			}
		%>
		</div>
    </div>
</section>
<!-- css、jsファイル -->
<link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet"/>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"/>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>

