<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<body>
		<center>
			<br>
			<br>
			异常情况表
			<br>
			<br>
			<table border="1">
				<tr>
					<td>
						账号
					</td>
					<td>
						交易类型
					</td>
					<td>
						交易金额
					</td>
					<td>
						交易时间
					</td>
				</tr>
				<s:iterator value="list">
					<tr>

						<td>
							<s:property value="userNO" />
						</td>
						<td>
							<s:property value="trade" />
						</td>
						<td>
							<s:property value="money" />
						</td>
						<td>
					    <s:property value="datatime" />
						</td>
					</tr>
				</s:iterator>
			</table>
		</center>
	</body>
</html>
