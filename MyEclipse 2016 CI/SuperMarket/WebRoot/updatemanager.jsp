<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	<link rel="stylesheet" type="text/css" href="css/showallgood.css">
	
 <script type="text/javascript">
     function sureupdate(){
     alert("Sure update this goods?")
}
</script>
  </head>
  <body>
  <%@include file="managermain_top.jsp" %>
  <%@include file="managermain_left.jsp" %>
	<c:if test="${not empty emptyinfomation }">
	<script type="text/javascript">
	alert("The modified infomation can not be empty!")
	</script>
	</c:if>
  <div id="container">
  	<form action="updatemanager" method="post">
  		<p><input type="hidden" name="mid" value="${mid }"></p>
  		<p>姓名<input type="text" name="mname"></p>
  		<p>账号<input type="text" name="mphonenumber"></p>
  		<p>密码<input type="password" name="mpassword"></p>
  		<input type="submit"  class="upd" value="修改" onclick="sureupdate()">
		<input type="reset" class="res" value="重置">
  	</form>
  </div>
  </body>
</html>
