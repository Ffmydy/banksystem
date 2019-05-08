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
		<div class="additemdiv">
			<form action="alterpassword.do" method="post">
				<div class="errormessage">${Error }</div>
				<p class="updateitem">
					输入旧密码:<input type="password"
						name="oldpassword"/>
				</p>
				<p class="updateitem">
					输入新密码:<input type="password" name="newpassword"/>
				</p>
				<p class="updateitem">
					确认新密码:<input type="password" name="anewpassword" />
				</p>
				<p> 
					<input type="submit" value="修改" onclick="javascript:return confirm('确认修改登录密码？');"/>&nbsp&nbsp&nbsp&nbsp<input type="reset" value="重置"/>
				</p>
			</form>
		</div>
	</div>
</body>
</html>
