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
<link rel="stylesheet" type="text/css" href="css/login.css">
<body>
	<script type="text/javascript">
		function register() {
			window.location.href = "register.jsp";
		}
	</script>
	<h1>在线超市系统</h1>

	<div>
		<%
			String msg = (String) request.getAttribute("msg");
			if (msg != null) {
		%>
		<h5>验证码输入错误</h5>
		<%
			}
		%>
		<%
			String error = (String) request.getAttribute("User_Password_Error");
			if (error != null) {
		%>
		<h5>用户名或密码错误，请重新输入</h5>
		<%
			}
		%>
		<form action="login" method="post">
			<p>
				账号： <input type="text" name="phonenumber" placeholder="账号">
			</p>
			<p>
				密码： <input type="password" name="password" placeholder="密码">
			</p>
			<p>
				<input type="radio" name="grade" value="0" checked="checked">顾客
				<input type="radio" name="grade" value="1">管理员
			</p>
			<p>
				验证码：<input type="text" name="verifyCode" size="5" /> <img
					src="verifycode" />
			</p>
			<p id="lset">
				<input type="submit" value="登录"> <input type="reset"
					value="重置"> <input type="button" value="注册"
					onclick=javascript:register()>
			</p>

		</form>
	</div>
</body>
</html>
