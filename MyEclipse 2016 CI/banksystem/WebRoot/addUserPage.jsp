<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>�����˻�����ϵͳ</title>
		<style type="text/css">
		body {
			background-image: url(image/1212.jpg);
		}
		</style>
	</head>
  <body>
  	<center>
  			<br /><br /><br />
  			<h3>����û����棡</h3>
  			<br />
			<%-- ����regValidate���Action�����д�����������ִ�пͻ���У��--%>
			<s:form action="regValidate2" validate="true" method="post">
				<%--����token��ǩ�������ظ��ύ--%>
				<%-- <s:token /> --%>
				<%--�ı����ǩ������name����ָ����ֵ������label����ָ�����ı����ǩ��--%>
				<s:textfield name="userInfo.userName" label="����" />
				<s:password name="userInfo.password" label="����" />
				<s:textfield name="userInfo.userAge" label="����" />
				<s:textfield name="userInfo.idCard" label="���֤" />
				<s:textfield name="userInfo.userSex" label="�Ա�" />
				<s:textfield name="userInfo.tel" label="�绰" />
				<s:textfield name="userInfo.city" label="����" />
				<s:textfield name="userInfo.address" label="��ַ" />
				<s:submit value="ȷ��" />
				<s:reset value="����" />
			</s:form>
		</center>
  </body>
</html>
