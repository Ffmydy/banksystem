<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<%@include file="check.jsp"%>
<body>
<center>
<br><br><br>
	<h3>�û�ȡ��</h3>
	<s:form action="fmoneyValidate" validate="true">
	<s:token/>
	<%-- ���ĵ�ǰ���Ϊ��<s:property value="balance" /> --%>
	<s:textfield name="money" label="����ȡ����"/>
	<s:submit value="ȷ��"/>
	<s:reset value="����"/>
	</s:form>
	<br>
	ע�⣺���ʽ��׽������ڣ�1-10000��Ԫ��Χ�ڣ�����С��λΪ1Ԫ����������С����<br>
	�����޷���ɴ�������
</center>
</body>
</html>