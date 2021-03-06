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
		<div class="query">
			<div class="queryoperationbyoperation_managename">
				<font size="4px" color="red">根据管理员姓名查询：</font>
				<form action="queryoperationbyoperation_managename.do">
					<input type="text" name="operation_managename" /> <input
						type="submit" value="查询" />
				</form>
			</div>
			<p>
				<br />
			</p>
			<p>
				<br />
			</p>
			<div class="queryoperationbyoperation_time">
				<font size="4px" color="red">根据操作时间查询：</font>
				<form action="queryoperationbyoperation_time.do">
					<input type="date" name="operation_time" /> <input type="submit"
						value="查询" />
				</form>
			</div>
			<p>
				<br />
			</p>
			<p>
				<br />
			</p>
			<div class="queryoperationbyoperation_name">
				<font size="4px" color="red">根据操作名称查询：</font>
				<form action="queryoperationbyoperation_name.do">
				<select
					name="operation_name" style="width: 135px">
					<option>添加</option>
					<option>删除</option>
					<option>修改</option>
				</select>
				<input type="submit" value="查询"/>
				</form>
			</div>
		</div>
		<div class="table">
			<table border="1px">
				<tr class="head">
					<td>操作序号</td>
					<td>管理员姓名</td>
					<td>操作项目编号</td>
					<td>操作项目名称</td>
					<td>操作时间</td>
					<td>操作名称</td>
				</tr>
				<c:forEach items="${PageInfo.list}" var="pi">
					<tr>
						<td>${pi.operation_id }</td>
						<td>${pi.operation_managename }</td>
						<td>${pi.operation_itemnumber}</td>
						<td>${pi.operation_itemname }</td>
						<td>${pi.operation_time}</td>
						<td>${pi.operation_name}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="6"><a
						href="queryoperationbyoperation_time.do?pageNumber=1&pageSize=6&operation_time=${operation_time }">首页</a>| <a
						href="queryoperationbyoperation_time.do?pageNumber=${PageInfo.pageNumber-1 }&pageSize=${PageInfo.pageSize }&operation_time=${operation_time }"
						<c:if test="${PageInfo.pageNumber<=1 }">  onclick="javascript:return false;"</c:if>>上一页</a>
						<a
						href="queryoperationbyoperation_time.do?pageNumber=${PageInfo.pageNumber+1 }&pageSize=${PageInfo.pageSize }&operation_time=${operation_time }"
						<c:if test="${PageInfo.pageNumber>=PageInfo.total}">  onclick="javascript:return false;"</c:if>>下一页</a>
						第${PageInfo.pageNumber}页/ 共${PageInfo.total}页
						(共${PageInfo.count}条数据）</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>
