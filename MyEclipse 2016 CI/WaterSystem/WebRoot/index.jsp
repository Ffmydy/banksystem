<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>万佛湖水资源管理系统</title>
<link href="css/login.css" rel="stylesheet" rev="stylesheet"
	type="text/css" media="all" />
<link href="css/demo.css" rel="stylesheet" rev="stylesheet"
	type="text/css" media="all" />
<script type="text/javascript" src="js/jquery.SuperSlide.js"></script>
<script type="text/javascript">
	function register(){
		window.location.href="register.jsp";
	}
	function changecode(){
	    src=document.getElementById('vcode').src="vcode.do?c="+Math.random();
	}
</script>
</head>
<body>
<c:if test="${not empty registersuc}">
	<script type="text/javascript">
		alert("您已经注册成功，快去登录吧！")
	</script>
</c:if>
<jsp:include page="head.jsp" />
	<div class="banner">
		<div class="login-aside">
			<div id="o-box-up"></div>
			<div id="o-box-down" style="table-layout:fixed;">
			<div class="error-box">${error }</div>
				<form class="registerform" action="${pageContext.request.contextPath}/login.do" method="post">
					<div class="fm-item">
						<label for="logonId" class="form-label">系统账号：</label> <input
							type="text" placeholder="请输入账号" maxlength="100" id="username" name="phonenumber"
							class="i-text">
					</div>
					<div class="fm-item">
						<label for="logonId" class="form-label">系统密码：</label> <input
							type="password" value="" maxlength="100" id="password" name="password"
							class="i-text">
						<div class="ui-form-explain"></div>
					</div>

					<div class="fm-item pos-r">
						<label for="logonId" class="form-label">验证码</label> <input
							type="text" name="vcode" placeholder="请输入验证码"  maxlength="100" id="yzm"
							class="i-text yzm">
							<div class="ui-form-explain">
							    <img id="vcode" alt="换一张" class="yzm-img" src="vcode.do" onclick="changecode()"/>
							</div>
					</div>
					<div class="fm-item">
						<label for="logonId" class="form-label"></label> 
						<input type="submit" value="" tabindex="4" id="send-btn" class="btn-login">
						<input type="button" value="" tabindex="4" id="reg-btn" class="btn-reg" onclick="register()"/>
						<div class="ui-form-explain"></div>
					</div>
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

	<jsp:include page="foot.jsp" />
</html>
