<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.haut.beans.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="css/mycss.css" />

</head>
<body>

	<jsp:include page="model.jsp" />
	<div class="menu-right">
		<div class="l-tab-links"></div>
		<div class="updateitemdiv">
			<form action="">
				<p class="updateitem">
					项目编号:<input type="text"
						value="<%=session.getAttribute("item_number")%>"
						name="item_number" readonly="readonly" />
				</p>
				<p class="updateitem">
					项目名称:<input type="text"
						value="<%=session.getAttribute("item_name")%>" name="itme_name"
						readonly="readonly" />
				</p>
				<p class="updateitem">
					成分浓度:<input type="text" name="item_concentration" />
				</p>
				<p class="updateitem">
					成分等级:<input type="text" name="water_level" />
				</p>
				<p class="updateitem">
					检测时间:<input type="date" name="time" />
				</p>
				<p class="updateitem">
					单位编号:<input type="text" name="unit_number" />
				</p>
			</form>
		</div>

	</div>
	
</body>
</html>
