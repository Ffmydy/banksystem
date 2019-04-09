<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>水资源管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function login(){
			window.location.href="index.jsp";
		}
		function register(){
			window.location.href="register.jsp";
		}
	</script>

  </head>
  
  <body>
   <jsp:include page="head.jsp"></jsp:include>
   <div class="banner">
		<div class="login-aside">
			<div id="o-box-up"></div>
			<div id="o-box-down" style="table-layout:fixed;">
			<div class="error-box">${error }</div><label class="form-label">
				<form class="registerform" action="${pageContext.request.contextPath}/register.do" method="post">
					<label class="form-label">您的姓名：<input type="text" name="manage_name" placeholder="请输入姓名"></label>
					<label class="form-label">您的手机：<input type="text" name="manage_phonenumber" value=${param.phone } readonly="readonly"></label>
					<label class="form-label">您的年龄：<input type="text" name="manage_age"></label>
					<label class="form-label">您的密码：<input type="password" name="manage_password"></label>
					<label class="form-label">确认密码：<input type="password" name="manage_apassword"></label>
					<label class="form-label">您的性别: <input type="radio" name="manage_sex" value="男" checked="checked" />男<input type="radio" name="manage_sex" value="女" />女</label>
			        <input type="button" value="上一步" onclick="register()">
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="submit" value="注册">
					</label>
				</form>
			</div>
		</div>
		<div class="bd">
			<ul>
				<li
					style="background:url(themes/theme-pic1.jpg) #CCE1F3 center 0 no-repeat;"></li>
				<li
					style="background:url(themes/theme-pic2.jpg) #BCE0FF center 0 no-repeat;"></li>
			</ul>
		</div>
		<div class="hd">
			<ul></ul>
		</div>
	</div>
	<script type="text/javascript">jQuery(".banner").slide({
			titCell : ".hd ul",
			mainCell : ".bd ul",
			effect : "fold",
			autoPlay : true,
			autoPage : true,
			trigger : "click"
		});
	</script>
	<div class="banner-shadow"></div>
	<jsp:include page="foot.jsp"></jsp:include>
  </body>
</html>
