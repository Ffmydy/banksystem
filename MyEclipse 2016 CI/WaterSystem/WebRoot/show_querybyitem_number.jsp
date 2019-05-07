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
		<div class="querybyitem_number">
			<font size="4px" color="red">根据项目编号查询：</font>
			<form action="querybyitem_number.do" method="get">
				<input type="text" name="item_number"/>
				<input type="submit" value="查询"/>
			</form>
		</div>
		<p><br/></p>
		<p><br/></p>
		<div class="querybydetecction_time">
			<font size="4px" color="red">根据检测时间查询：</font>
			<form action="querybydetection_time.do" method="get">
				<input type="date" name="detecction_time"/>
				<input type="submit" value="查询"/>
			</form>
		</div>
	</div>
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
					<tr>
						<td>${water_test_report.item_number}</td>
						<td>${water_test_report.item_name }</td>
						<td>${water_test_report.item_concentration }</td>
						<td>${water_test_report.water_level }</td>
						<td>${water_test_report.detection_time }</td>
						<td>${water_test_report.unit_number }</td>
						<td><a href="verifyidentity_deleteitem.jsp?item_number=${water_test_report.item_number}&item_name=${water_test_report.item_name }">删除&nbsp&nbsp&nbsp&nbsp</a><a href="verifyidentity_modifyitem.jsp?item_number=${water_test_report.item_number}&item_name=${water_test_report.item_name }">修改</a></td>
					</tr>
			</table>
		</div>
	</div>
</body>
</html>
