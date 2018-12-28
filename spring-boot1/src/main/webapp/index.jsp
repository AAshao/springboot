<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%String path=request.getContextPath(); 
String bathPath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<title>登陆页面</title>
</head>
<script type="text/javascript" src="<%=bathPath%>common/js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="<%out.print(bathPath);%>common/js/jquery.validate.js"></script>
<script type="text/javascript" src="<%=bathPath%>common/js/login.js"></script>
<body>
<h3>欢迎来到登陆页面</h3>
<form action="<%=bathPath%>toLogin/login" method="post" id="loginForm">
	<img alt="" src="<%=bathPath%>common/image/car.jpg">
	<span style="color: red">${notLogin}</span>
	<p>用户名：<input type="text" name="username"/ id="username_id"> <span style="color: red">${errorUserName}</span> </p>
	<p>密码：<input type="password" name="password"/> <span  style="color: red">${errorPassword }</span>  </p>
	<p><input type="submit" value="登陆"> </p>
</form>
</body>
</html>