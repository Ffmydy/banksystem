<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.haut.beans.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="css/mycss.css" />
</head>
<body>
	<jsp:include page="model.jsp" />
	<div class="menu-right">
	<div class="l-tab-links"></div>
		<div class="table">
			<table border="1px" >
				<tr class="head">
					<td>单位编号</td>
					<td>单位名称</td>
					<td>单位地址</td>
					<td>单位电话</td>
					<td>老板编号</td>
				</tr>
				<c:forEach items="${PageInfo.list}" var="pi">
					<tr>
						<td>${pi.unit_number }</td>
						<td>${pi.unit_name }</td>
						<td>${pi.unit_address}</td>
						<td>${pi.unit_phonenumber }</td>
						<td>${pi.boss_number}</td>
					</tr>
				</c:forEach>
				<tr>
						<td colspan="5"><a
							href="checkunit.do?pageNumber=1&pageSize=3">首页</a>| <a
							href="checkunit.do?pageNumber=${PageInfo.pageNumber-1 }&pageSize=${PageInfo.pageSize }"
							<c:if test="${PageInfo.pageNumber<=1 }">  onclick="javascript:return false;"</c:if>>上一页</a>
							<a
							href="checkunit.do?pageNumber=${PageInfo.pageNumber+1 }&pageSize=${PageInfo.pageSize }"
							<c:if test="${PageInfo.pageNumber>=PageInfo.total}">  onclick="javascript:return false;"</c:if>>下一页</a>
							第${PageInfo.pageNumber}页/ 共${PageInfo.total}页
							(共${PageInfo.count}条数据）</td>
					</tr>
			</table>
		</div>
	</div>
</body>
</html>
