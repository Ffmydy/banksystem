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
			管理员修改信息成功，具体内容如下：
			<table>
				<tr>
					<td>
					</td>
				</tr>
				<tr>
					<td>
						联系电话：
					</td>
					<td>
						<s:property value="userInfo.tel" />
					</td>
				</tr>
				<tr>
					<td>
						居住城市：
					</td>
					<td>
						<s:property value="userInfo.city" />
					</td>
				</tr>
				<tr>
					<td>
						详细地址：
					</td>
					<td>
						<s:property value="userInfo.address" />
					</td>
				</tr>
			</table>
		</center>
	</body>
</html>
