<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<body>
		<%  
            String userNO=request.getParameter("userNO");  
			userNO = new String(userNO.getBytes("iso-8859-1"),"gb2312");  
  			request.setAttribute("userNO", userNO);
        %>  
		<br>
		<br>
		<br>
		<br>
		<br>
		<center>
			<s:form action="updateUserValidate2" validate="true">
				<s:token />
				用户帐号:<% out.print(userNO);  %>
				<%-- <s:hidden name="userInfo.userNO" value="%{#userInfo.userNO}" />
				用户帐号:<s:property value="userInfo.userNO" /> --%>
				
				<s:textfield name="userInfo.userNO" label="用户账号" />
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
