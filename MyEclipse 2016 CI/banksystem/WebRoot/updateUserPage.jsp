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
				�û��ʺ�:<% out.print(userNO);  %>
				<%-- <s:hidden name="userInfo.userNO" value="%{#userInfo.userNO}" />
				�û��ʺ�:<s:property value="userInfo.userNO" /> --%>
				
				<%--<s:textfield name="userInfo.userNO" label="�û��˺�" /> --%>
				<%-- <s:password name="userInfo.password" label="�û�����" /> --%>
				<s:textfield name="userInfo.tel" label="��ϵ�绰" />
				<s:textfield name="userInfo.city" label="��ס����" />
				<s:textfield name="userInfo.address" label="��ϸ��ַ" />
				<s:submit value="ȷ��" />
				<s:reset value="����" />

			</s:form>
		</center>
	</body>
</html>
