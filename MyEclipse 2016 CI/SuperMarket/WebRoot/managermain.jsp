<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>在线超市系统</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/managermain.css">
</head>

<body>
	<div id="container">
		<div id="header">
			<h1>欢迎管理员登录在线超市系统</h1>
		</div>
		<div id="list">
			<ul id="menu">
				<li><a href="managermain.jsp" title="">首页</a></li>
				<li><a href="addgoods.jsp" title="">添加商品</a></li>
				<li><a href="checkgoods" title="">商品信息</a></li>
				<li><a href="#" title="">用户信息</a></li>
				<li><a href="#" title="">个人信息</a></li>
				<li><a href="login.jsp" title="">退出登录</a></li>
			</ul>
		</div>
	</div>
</body>
</html>
