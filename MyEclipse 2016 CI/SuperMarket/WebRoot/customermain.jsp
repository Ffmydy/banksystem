<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.alibb.pojo.*"%>
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
			<h1>
				欢迎<a id="name">${sessionScope.customer.getCname() }</a>登录在线超市
			</h1>
		</div>
		<div id="list">
			<ul id="menu">
				<li><a href="lookgoods">浏览商品</a></li>
				<li><a href="#">查找商品</a></li>
				<li><a href="#">个人信息</a></li>
				<li><a href="#">退出登录</a></li>
			</ul>
		</div>
	</div>
</body>
</html>
