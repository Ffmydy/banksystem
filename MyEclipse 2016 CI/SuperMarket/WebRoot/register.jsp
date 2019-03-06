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
<link rel="stylesheet" type="text/css" href="css/register.css">

</head>

<body>
	<div>
		<h3>顾客注册</h3>
		<form action="registerservlet" method="post">
			<p>
				姓名: <input type="text" name="cname" palceholder="姓名">
			</p>
			          密码: <input type="password" name="cpassword" palceholder="密码">
			<p>
				手机: <input type="text" name="cphonenumber" palceholder="手机">
			</p>
			<p>
				地址: <input type="text" name="caddress" palceholder="地址">
			</p>
			<p>
				余额: <input type="text" value="10000" name="cmoney" readonly>
			</p>
			<p id="sr">
				<input class="reg" type="submit" value="注册">
				<input class="res" type="reset" value="重置">
			</p>

		</form>
	</div>
</body>
</html>
