<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.github.pagehelper.PageInfo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>在线超市系统 </title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/showallcustomer.css">
	<script type="text/javascript">
	function suredelete(){
	alert("sure delete this customer?");
	}
	</script>
  </head>
  <body>
<%@include file="managermain_top.jsp" %>
  <%@include file="managermain_left.jsp" %>
    <div id="container">
    <table border="1">
    <tr>
    <td>顾客编号</td>
    <td>顾客姓名</td>
    <td>顾客手机</td>
    <td id="address">收货地址</td>
    <td>操作</td>
    </tr>
    <c:forEach items="${PageInfo.list }" var="pi">
    <tr>
    <td>${pi.cid }</td>
    <td>${pi.cname}</td>
    <td>${pi.cphonenumber }</td>
    <td>${pi.caddress }</td>
    <td><a href="deletecustomer?cid=${pi.cid }" onclick="suredelete()">删除&nbsp&nbsp&nbsp&nbsp</a><a href="updatecustomer.jsp?cid=${pi.cid }&cname=${pi.cname}">修改</a>
    </tr>
    </c:forEach>
    <tr>
    <td colspan="5">
    <a href="checkcustomer?pageNumber=1&pageSize=5">首页</a>|
            <a href="checkcustomer?pageNumber=${PageInfo.pageNumber-1 }&pageSize=${PageInfo.pageSize }"<c:if test="${PageInfo.pageNumber<=1 }">  onclick="javascript:return false;"</c:if>>上一页</a>
            <a href="checkcustomer?pageNumber=${PageInfo.pageNumber+1 }&pageSize=${PageInfo.pageSize }"<c:if test="${PageInfo.pageNumber>=PageInfo.total}">  onclick="javascript:return false;"</c:if>>下一页</a>
                                第${PageInfo.pageNumber}页/
                                共${PageInfo.total}页
            (${PageInfo.count}共条数据）
    </td>
    </tr>
    </table>
    </div>
  </body>
</html>
