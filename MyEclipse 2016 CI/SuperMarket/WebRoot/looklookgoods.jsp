<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.github.pagehelper.PageInfo" %>
<%@ page import="com.alibb.pojo.Goods" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>在线超市系统 starting page</title>
    
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
  <c:if test="${not empty success }">
  <script type="text/javascript">
  alert("You buy this goods successfully!")
  </script>
  </c:if>
    <div id="container">
    <table border="1">
    <tr>
    <td>商品编号</td>
    <td>商品名称</td>
    <td>商品价格（斤/元）</td>
    <td>商品数量（斤）</td>
    <td>操作</td>
    </tr>
    <c:forEach items="${PageInfo.list }" var="pi">
    <tr>
    <td>${pi.gid }</td>
    <td>${pi.gname}</td>
    <td>${pi.gprice }</td>
    <td>${pi.gnumber }</td>
    <td><a href="buygoods.jsp?gid=${pi.gid }&gname=${pi.gname }&gprice=${pi.gprice}">购买</a>
    </tr>
    </c:forEach>
    <tr>
    <td colspan="6">
    <a href="lookgoods?pageNumber=1&pageSize=5">首页</a>|
            <a href="lookgoods?pageNumber=${PageInfo.pageNumber-1 }&pageSize=${PageInfo.pageSize }"<c:if test="${PageInfo.pageNumber<=1 }">  onclick="javascript:return false;"</c:if>>上一页</a>
            <a href="lookgoods?pageNumber=${PageInfo.pageNumber+1 }&pageSize=${PageInfo.pageSize }"<c:if test="${PageInfo.pageNumber>=PageInfo.total}">  onclick="javascript:return false;"</c:if>>下一页</a>
                                第${PageInfo.pageNumber}页/
                                共${PageInfo.total}页
            (共${PageInfo.count}条数据）
    </td>
    </tr>
    </table>
    </div>
  </body>
</html>
