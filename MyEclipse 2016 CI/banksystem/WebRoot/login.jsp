<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript">   
function changeValidateCode(obj) {   
//获取当前的时间作为参数，无具体意义   
var timenow = new Date().getTime();   
//每次请求需要一个不同的参数，否则可能会返回同样的验证码   
//这和浏览器的缓存机制有关系，也可以把页面设置为不缓存，这样就不用这个参数了。   
obj.src="rand.action?d="+timenow;   
}

function refresh(){
var vcode=document.getElementById('vcode');
var timenow = new Date().getTime();
vcode.src ="rand.action?nocache="+timenow; 
};
//由于传递了不同的参数，浏览器认为img的src发生了改变，因此重新生成了新的验证码。
</script>

<html>
    <title>银行账户管理系统</title>
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
				<s:textfield name="userNO" label="帐号" />
				<s:password name="password" label="密码" />
				<table>
				<tr>
						<td>
						<s:textfield name="rand" label="验证码" size="6" />
						</td>
						<td>
						<img src="rand.action" alt="验证码" title="点击图片刷新验证码" onclick="changeValidateCode(this)"	align="top" />
						</td>
					</tr>
				
				</table>
				
				<table id="RadioButtonList1" border="0">
					<tr>
						<td><input id="RadioButtonList1_0" type="radio" name="RadioButtonList1" value="11" tabindex="4" />
							<label for="RadioButtonList1_0">管理员</label>
						</td>
						<td><input checked="true" id="RadioButtonList1_1" type="radio" name="RadioButtonList1" value="00" tabindex="4" />
							<label for="RadioButtonList1_1">普通用户</label>
						</td>
					</tr>
				</table>
				
				<table id="RadioButtonList1" border="0">
					<tr>
						<td><input type="submit"  value="确定"/>
						</td>
						<td><input type="reset"  value="重置"/>
						</td>
					</tr>
				</table>
			</s:form>
			
			
			<a href="regist.jsp">忘记密码？</a>
			<br />
			<a href="regist2.jsp">注册新帐户</a>
		</center>
	</div>
	</body>
</html>
