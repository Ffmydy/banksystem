<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<body>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<center>
			����Ա�޸���Ϣ�ɹ��������������£�
			<table>
				<tr>
					<td>
					</td>
				</tr>
				<tr>
					<td>
						��ϵ�绰��
					</td>
					<td>
						<s:property value="userInfo.tel" />
					</td>
				</tr>
				<tr>
					<td>
						��ס���У�
					</td>
					<td>
						<s:property value="userInfo.city" />
					</td>
				</tr>
				<tr>
					<td>
						��ϸ��ַ��
					</td>
					<td>
						<s:property value="userInfo.address" />
					</td>
				</tr>
			</table>
		</center>
	</body>
</html>
