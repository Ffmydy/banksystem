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
					<tr>
						<td>${entrusted_unit.unit_number }</td>
						<td>${entrusted_unit.unit_name }</td>
						<td>${entrusted_unit.unit_address}</td>
						<td>${entrusted_unit.unit_phonenumber }</td>
						<td><a href="check_current_boss.do?boss_number=${entrusted_unit.boss_number}">${entrusted_unit.boss_number}</a></td>
					</tr>
			</table>
		</div>
	</div>
</body>
</html>
