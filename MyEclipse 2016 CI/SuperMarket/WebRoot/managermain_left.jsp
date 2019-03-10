<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
<head>

<link rel="stylesheet" type="text/css" href="css/managermain.css">
</head>
<script type="text/javascript">
	function sureout(){
	if(window.confirm("Are you sure?")){
	window.location="login.jsp"
	}
	else{
	window.location="managermain.jsp"
	}
	}
</script>
<body>
	<div id="list">
		<ul id="menu">
			<li><a href="managermain.jsp" title="">首页</a></li>
			<li><a href="addgoods.jsp" title="">添加商品</a></li>
			<li><a href="checkgoods" title="">商品信息</a></li>
			<li><a href="checkcustomer" title="">用户信息</a></li>
			<li><a href="showmanager?mid=<%=request.getSession().getAttribute("mid") %>" title="">个人信息</a></li>
			<li><a href="javascript:void(0);" onclick="sureout()">退出登录</a>
		</ul>
	</div>
</body>
</html>
