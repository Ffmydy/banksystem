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
			<table>
				<tr>
					<td>
						�û��˺ţ�
					</td>
					<td>
						<s:property value="#session.user.userNO" />
					</td>
				</tr>
			</table>
			�޸���Ϣ�ɹ��������������£�
			<table>
				<%-- <tr>
					<td>
						���룺
					</td>
					<td>
						<s:property value="userInfo.password" />
					</td>
				</tr> --%>
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
