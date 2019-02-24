<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<title>银行账户管理系统 </title>
<body>
<center>
<br><br><br>
	<h3>用户存款</h3>
	<s:form action="smoneyValidate" validate="true">
	<s:token/>
	<s:textfield name="money" label="输入存款金额"/>
	<s:submit value="确定"/>
	<s:reset value="重置"/>
	</s:form>
	<br>
	注意：单笔交易金额必须在（1-10000）元范围内，且最小单位为1元，不能输入小数！<br>
	否则无法完成存款操作！	
</center>
</body>
</html>