<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<body>
		<br>
		<br>
		<br>
		<center>
			<h3>������Ϣ����</h3>
			<br>
			<s:form action="updateUserValidate" validate="true">
				<s:token />
				�û��ʺ�:<s:property value="#session.user.userNO" /><br>
				�û�����<s:property value="#session.user.userName" />
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