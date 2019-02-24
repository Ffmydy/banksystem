<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<body>
		<br>
		<br>
		<br>
		<center>
			<h3>更改信息界面</h3>
			<br>
			<s:form action="updateUserValidate" validate="true">
				<s:token />
				用户帐号:<s:property value="#session.user.userNO" /><br>
				用户名：<s:property value="#session.user.userName" />
				<%-- <s:password name="userInfo.password" label="用户密码" /> --%>
				<s:textfield name="userInfo.tel" label="联系电话" />
				<s:textfield name="userInfo.city" label="居住城市" />
				<s:textfield name="userInfo.address" label="详细地址" />
				<s:submit value="确定" />
				<s:reset value="重置" />

			</s:form>
		</center>
	</body>
</html>
