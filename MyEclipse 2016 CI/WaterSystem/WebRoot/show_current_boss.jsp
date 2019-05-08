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
					<td>负责人编号</td>
					<td>负责人姓名</td>
					<td>负责人年龄</td>
					<td>负责人性别</td>
					<td>负责人电话</td>
					<td>负责人邮箱</td>
				</tr>
					<tr>
						<td>${boss.boss_number }</td>
						<td>${boss.boss_name }</td>
						<td>${boss.boss_age}</td>
						<td>${boss.boss_sex }</td>
						<td>${boss.boss_phonenumber}</td>
						<td>${boss.boss_email }</td>
					</tr>
			</table>
		</div>
	</div>
</body>
</html>
