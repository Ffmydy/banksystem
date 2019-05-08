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
<c:if test="${not empty Success }">
<script type="text/javascript">
alert('${Success}')
</script>
</c:if>
<c:if test="${not empty Error }">
<script type="text/javascript">
alert('${Error}')
</script>
</c:if>
	<jsp:include page="model.jsp" />
	<div class="menu-right">
		<div class="l-tab-links"></div>
		<div class="showpersonal_information">
			<div class="personal_photo">
			<form action="fileUploadPage.do" method="post" enctype="multipart/form-data">
			  <input type="file" name="photo" id="upload" style="display: none"/>
		      <a onclick="upload.click()"><img src='${manage.manage_photo }' width="100px" height="150px"/></a><br/>
		      <font size="2px" color="blue"><input type="submit" value="上传"/></font>
			</form>
			</div>
			<div class="other_information">
				<font size="5px" color="green"> 姓名：${manage.manage_name}<br />
					账号：${manage.manage_phonenumber }<br /> 年龄：${manage.manage_age }<br />
					性别：${manage.manage_sex }
				</font>
			</div>
		</div>
	</div>

</body>
</html>
