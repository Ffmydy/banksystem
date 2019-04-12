<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.haut.beans.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="css/mycss.css" />
<script type="text/javascript">
	function suredelete(){
	if(window.confirm("你确定删除这个水检项目？")){
	window.location="deleteprogram.do?item_number=${pi.item_number}"
	}
	else{
	   window.location="checkprogram.do"
	}
	}
</script>
</head>
<body>
	<jsp:include page="model.jsp" />
	<div class="menu-right">
	<div class="l-tab-links"></div>
		<div class="table">
			<table border="1px" >
				<tr class="head">
					<td>项目编号</td>
					<td>项目名称</td>
					<td>成分浓度</td>
					<td>成分等级</td>
					<td>检测时间</td>
					<td>单位编号</td>
					<td>相关操作</td>
				</tr>
				<c:forEach items="${PageInfo.list}" var="pi">
					<tr>
						<td>${pi.item_number }</td>
						<td>${pi.item_name }</td>
						<td>${pi.item_concentration }</td>
						<td>${pi.water_level }</td>
						<td>${pi.detection_time }</td>
						<td>${pi.unit_number }</td>
						<td><a href="deleteprogram.do?item_number=${pi.item_number}" onclick="suredelete()">删除&nbsp&nbsp&nbsp&nbsp</a><a href="verifyidentity.jsp?item_number=${pi.item_number }&item_name=${pi.item_name}">修改</a>
					</tr>
				</c:forEach>
				<tr>
						<td colspan="7"><a
							href="checkprogram.do?pageNumber=1&pageSize=6">首页</a>| <a
							href="checkprogram.do?pageNumber=${PageInfo.pageNumber-1 }&pageSize=${PageInfo.pageSize }"
							<c:if test="${PageInfo.pageNumber<=1 }">  onclick="javascript:return false;"</c:if>>上一页</a>
							<a
							href="checkprogram.do?pageNumber=${PageInfo.pageNumber+1 }&pageSize=${PageInfo.pageSize }"
							<c:if test="${PageInfo.pageNumber>=PageInfo.total}">  onclick="javascript:return false;"</c:if>>下一页</a>
							第${PageInfo.pageNumber}页/ 共${PageInfo.total}页
							(共${PageInfo.count}条数据）</td>
					</tr>
			</table>
		</div>
	</div>
</body>
</html>
