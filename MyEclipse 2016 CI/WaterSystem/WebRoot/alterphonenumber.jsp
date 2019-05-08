<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>水资源管理系统</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link type="text/css" rel="stylesheet" href="css/mycss.css" />
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<script type="text/javascript">
	var InterValObj; //timer变量，控制时间
	var count = 30; //间隔函数，1秒执行
	var curCount; //当前剩余秒数
	function sendMessage() {
		curCount = count;
		$("#btn").attr("disabled", "true");
		$("#btn").val(curCount + "秒后可重新发送");
		InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一次请求后台发送验证码 TODO
	}
	//timer处理函数
	function SetRemainTime() {
		if (curCount == 0) {
			window.clearInterval(InterValObj); //停止计时器
			$("#btn").removeAttr("disabled"); //启用按钮
			$("#btn").val("重新发送验证码");
		} else {
			curCount--;
			$("#btn").val(curCount + "秒后可重新发送");
		}
	}
</script>
</head>

<body>
	<jsp:include page="model.jsp" />
	<div class="menu-right">
	<div class="l-tab-links"></div>
	<div class="verifyidentity">
		<form action="">
			    <p>
					您的手机号:<input type="text" id="phone" name="manage_phonenumber" />&nbsp&nbsp&nbsp&nbsp<input type="button" class="btn btn-default" id="btn" name="btn" value="发送验证码" />
				</p>
				<p>
				          输入验证码:<input type="text" id="code" name="code" placeholder="验证码" required/>
				</p>
				<p>
				   <button type="button" class="btn btn-info" id="lo" onclick="javascript:return confirm('确认更换手机号？');">更换</button>
				</p>
		</form>	
	</div>
	</div>
	<script type="text/javascript">
		var sms = "";
		var phonenumber = "";
		$("#btn").click(function() {
			var manage_phonenumber = $("#phone").val();
			phonenumber = manage_phonenumber;
			if (manage_phonenumber != "") {
				sendMessage();
				$.ajax({
					url : "sendSMS.do",
					type : "post",
					data : {
						"manage_phonenumber" : manage_phonenumber
					},
					success : function(result) {
						sms = result;
						if (sms == "error_phonenumber") {
							alert("手机号非法，请重新输入")
							window.location.href = "alterphonenumber.jsp";
						}
						if (sms == "error_registered") {
							alert("手机号已注册，不能更换!")
							window.location.href = "alterphonenumber.jsp";
						}
					}
				});
			} else {
				alert("请输入手机号");
				return false;
			}
		});
		$("#lo").click(function() {
			var code = $("#code").val();
			if (code == "") {
				alert("请输入验证码");
			} else {
				if (sms == code) {
					window.location.href ="alterphonenumber.do?manage_phonenumber="+phonenumber;
				} else {
					alert("验证码不正确")
				}
				;
			}
			;
		});
	</script>
</body>
</html>
