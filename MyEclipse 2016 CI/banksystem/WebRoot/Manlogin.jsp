<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript">   
function changeValidateCode(obj) {   
//��ȡ��ǰ��ʱ����Ϊ�������޾�������   
var timenow = new Date().getTime();   
//ÿ��������Ҫһ����ͬ�Ĳ�����������ܻ᷵��ͬ������֤��   
//���������Ļ�������й�ϵ��Ҳ���԰�ҳ������Ϊ�����棬�����Ͳ�����������ˡ�   
obj.src="rand.action?d="+timenow;   
}

function refresh(){
var vcode=document.getElementById('vcode');
var timenow = new Date().getTime();
vcode.src ="rand.action?nocache="+timenow; 
};
//���ڴ����˲�ͬ�Ĳ������������Ϊimg��src�����˸ı䣬��������������µ���֤�롣
</script>

<html>
    <title>�����˻�����ϵͳ</title>
	<body>
	<div align="center">
    <p>&nbsp;</p>
    <p><img src="image/bar_ebanking.jpg" width="744" height="70"></p>
    <p>&nbsp;</p>
    <p><img src="image/welcome.gif" width="337" height="45"></p>
    <p>&nbsp;</p>
    <p><img src="image/perlog1.gif" width="488" height="26"></p>
    <p>&nbsp;</p>
    </div>
	<div>
		<center>
			<s:form action="loginValidate" method="post">
				<s:textfield name="userNO" label="�ʺ�" />
				<s:password name="password" label="����" />
				<table>
				<tr>
						<td>
						<s:textfield name="rand" label="��֤��" size="6" />
						</td>
						<td>
						<img src="rand.action" alt="��֤��" title="���ͼƬˢ����֤��" onclick="changeValidateCode(this)"	align="top" />
						</td>
					</tr>
				
				</table>
				
				<table id="RadioButtonList1" border="0">
					<tr>
						<td><input id="RadioButtonList1_0" type="radio" name="RadioButtonList1" value="11" tabindex="4" />
							<label for="RadioButtonList1_0">����Ա</label>
						</td>
						<td><input checked="true" id="RadioButtonList1_1" type="radio" name="RadioButtonList1" value="00" tabindex="4" />
							<label for="RadioButtonList1_1">��ͨ�û�</label>
						</td>
					</tr>
				</table>
				
				<table id="RadioButtonList1" border="0">
					<tr>
						<td><input type="submit"  value="ȷ��"/>
						</td>
						<td><input type="reset"  value="����"/>
						</td>
					</tr>
				</table>
			</s:form>
			
			
			<a href="regist.jsp">�������룿</a>
			<br />
			<a href="regist2.jsp">ע�����ʻ�</a>
		</center>
	</div>
	</body>
</html>
