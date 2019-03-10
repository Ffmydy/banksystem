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
    
    <title>在线超市</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/showallgood.css">

  </head>
  
  <body>
<%@include file="customermain_top.jsp" %>
  <%@include file="customermain_left.jsp" %>
   <c:if test="${not empty emptyinfomation }">
  <script type="text/javascript">
  alert("请输入购买数量")
  </script>
  </c:if>
    <div id="container">
    <form action="buygoods" method="post">
    <p><input type="hidden" name="gid" value="${param.gid }"></p>
    <p>商品名称<input type="text" name="gname" value="${param.gname }" readonly="readonly"></p>
    <p>商品价格<input type="text" name="gprice" value="${param.gprice }" readonly="readonly"><p>
    <p>购买数量<input type="text" name="bgnumber"></p>
    <p><input type="submit" value="购买">&nbsp&nbsp&nbsp&nbsp&nbsp<input type="reset" value="重置"><p>
    </form> 
    </div>
  </body>
</html>
