<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<title>�����˻�����ϵͳ </title>
<body>
<center>
<br><br><br>
	<h3>�û����</h3>
	<s:form action="smoneyValidate" validate="true">
	<s:token/>
	<s:textfield name="money" label="��������"/>
	<s:submit value="ȷ��"/>
	<s:reset value="����"/>
	</s:form>
	<br>
	ע�⣺���ʽ��׽������ڣ�1-10000��Ԫ��Χ�ڣ�����С��λΪ1Ԫ����������С����<br>
	�����޷���ɴ�������	
</center>
</body>
</html>