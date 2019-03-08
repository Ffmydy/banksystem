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


<link rel="stylesheet" type="text/css" href="css/addgoods.css">


</head>

<body>
<%String infomation=(String)request.getAttribute("infomation");
if(infomation!=null){%>
<script type="text/javascript">
alert("添加成功");
</script>
<%}
%>
<%String empty=(String)request.getAttribute("empty");
if(empty!=null){%>
<script type="text/javascript">
alert("信息不能为空");
</script>
<%}
%>
 <%@include file="managermain_top.jsp" %>
  <%@include file="managermain_left.jsp" %>
	<div id="container">
	<h2>添加商品</h2>
		<form action="addgoods" method="post">
			<p>
				商品名称：<input type="text" name="gname">
			</p>
			<p>
				商品价格：<input type="text" name="gprice">
			</p>
			<p>
				商品数量：<input type="text" name="gnumber">
			</p>
			<p>
				<input id="submit" type="submit" value="添加">
				<input id="reset" type="reset" value="清空">
			</p>
		</form>
	</div>
</body>
</html>
