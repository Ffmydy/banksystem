<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>银行账户管理系统</title>
		<style type="text/css">
		body {
			background-image: url(image/1212.jpg);
		}
		</style>
	</head>
  <body>
  	<center>
  			<br /><br /><br />
  			<h3>添加用户界面！</h3>
  			<br />
			<%-- 请求regValidate这个Action来进行处理，并且设置执行客户端校验--%>
			<s:form action="regValidate2" validate="true" method="post">
				<%--加入token标签，避免重复提交--%>
				<%-- <s:token /> --%>
				<%--文本框标签，其中name属性指定传值参数，label属性指定该文本框标签名--%>
				<s:textfield name="userInfo.userName" label="姓名" />
				<s:password name="userInfo.password" label="密码" />
				<s:textfield name="userInfo.userAge" label="年龄" />
				<s:textfield name="userInfo.idCard" label="身份证" />
				<s:textfield name="userInfo.userSex" label="性别" />
				<s:textfield name="userInfo.tel" label="电话" />
				<s:textfield name="userInfo.city" label="城市" />
				<s:textfield name="userInfo.address" label="地址" />
				<s:submit value="确定" />
				<s:reset value="重置" />
			</s:form>
		</center>
  </body>
</html>
