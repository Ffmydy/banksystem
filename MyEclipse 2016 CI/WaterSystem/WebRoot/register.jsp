<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

  </head>
  
  <body>
   <jsp:include page="head.jsp"></jsp:include>
   <div class="banner">
		<div class="login-aside">
			<div id="o-box-up"></div>
			<div id="o-box-down" style="table-layout:fixed;">
			<div class="error-box">${error }</div>
				<form class="registerform" action="${pageContext.request.contextPath}/register.do" method="post">
					<label class="form-label">姓名：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="name" placeholder="请输入姓名"></label>
					<label class="form-label">手机：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="phonenumber" placeholder="请输入手机号"></label>
					<label class="form-label">年龄: &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="age"></label>
					<label class="form-label">密码：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="password" name="password"></label>
					<label class="form-label">确认密码：<input type="password" name="apassword"></label>
					<label class="form-label">性别: &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="radio" name="sex" value="男" checked="checked" />男<input type="radio" name="sex" value="女" />女</label>
					<label class="form-label">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="submit" value="注册">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="reset" value="取消"></label>
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
