<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.alibb.pojo.Manager" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showmanager.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/showallgood.css">

  </head>

  <body>
    <%Manager manager=(Manager)request.getAttribute("manager");
   %>
  <%@include file="managermain_top.jsp" %>
  <%@include file="managermain_left.jsp" %>
	<div id="container">
	<table border="1px">
	<tr>
	<td>姓名</td>
	<td>密码</td>
	<td>账号</td>
	<td>操作</td>
	</tr>
	<td><%=manager.getMname() %></td>
	<td><%=manager.getMpassword() %></td>
	<td><%=manager.getMphonenumber() %></td>
	<td><a href="updatemanager.jsp?mid=<%=manager.getMid() %>">修改</a></td>
	</table>
	</div>
  </body>
</html>
