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

<title>My JSP 'updategoods.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/updategoods.css">
<script type="text/javascript">
function sureupdate(){
alert("Sure update this goods?")
}
</script>
</head>

<body>
<%@include file="managermain_top.jsp" %>
  <%@include file="managermain_left.jsp" %>
	<div id="container">
	    <%
			String error = (String) request.getAttribute("error");
			if (error != null) {
		%>
		<h5>价格或数量不能为空</h5>
		<%
			}
		%>
		<form action="updategoods" method="post">
			<p>
				<input type="hidden" value="<%=request.getParameter("gid")%>"
					name="gid">
			</p>
			<p>
				商品名称<input type="text" value="<%=request.getParameter("gname")%>"
					name="gname" readonly="readonly">
			</p>
			<p>
				商品价格<input type="text" name="gprice" >
			</p>
			<p>
				商品数量<input type="text" name="gnumber" >
			</p>
			<p>
				<input type="submit"  class="upd" value="修改" onclick="sureupdate()">
				<input type="reset" class="res" value="重置">
			</p>
		</form>
	</div>
</body>
</html>
