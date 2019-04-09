<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
          function login(){
			window.location.href="index.jsp";
		}
    </script>
    
	<script type="text/javascript">
    var InterValObj; //timer变量，控制时间
    var count = 30; //间隔函数，1秒执行
    var curCount;//当前剩余秒数
    function sendMessage(){
        curCount = count;
        $("#btn").attr("disabled", "true");
        $("#btn").val(curCount + "秒后可重新发送");
        InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一次请求后台发送验证码 TODO
    }
    //timer处理函数
    function SetRemainTime() {
        if (curCount == 0) {
            window.clearInterval(InterValObj);//停止计时器
            $("#btn").removeAttr("disabled");//启用按钮
            $("#btn").val("重新发送验证码");
        }
        else {
            curCount--;
            $("#btn").val(curCount + "秒后可重新发送");
        }
    }
	</script>
  </head>
  
  <body>
   <jsp:include page="head.jsp"></jsp:include>
   <div class="banner">
		<div class="login-aside">
			<div id="o-box-up"></div>
			<div id="o-box-down" style="table-layout:fixed;">
			<div class="error-box">${error }</div>
				<form class="registerform1" role="form">
					<label class="form-label">手机号：
					<input type="text" id="phone" name="manage_phonenumber" placeholder="请输入您的手机号"  required autofocus ></label>
				    <label class="form-label">验证码：     
					<input type="text" id="code" name="code" placeholder="验证码" required></label>
					<label class="form-label"><input type="button" class="btn btn-default" id="btn" name="btn" value="发送验证码" /></label>
					<button type="button" onclick="login()">上一步</button>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<button type="button" class="btn btn-info" id="lo">下一步</button>
				</form>
			</div>
		</div>
		<div class="bd">
			<ul>
				<li
					style="background:url(themes/theme-pic1.jpg) #CCE1F3 center 0 no-repeat;"></li>
				<li
					style="background:url(themes/theme-pic2.jpg) #BCE0FF center 0 no-repeat;"></li>
			</ul>
		</div>
		<div class="hd">
			<ul></ul>
		</div>
	</div>
	<script type="text/javascript">
    var sms="";
    var phonenumber="";
    $("#btn").click(function(){
        var manage_phonenumber=$("#phone").val();
        phonenumber=manage_phonenumber;
        if(manage_phonenumber!="")
        {	sendMessage();
            $.ajax({
                url:"sendSMS.do",
                type:"post",
                data:{"manage_phonenumber":manage_phonenumber},
                success:function(result){
                    sms=result;
                    if(sms=="error_phonenumber"){
                    	alert("手机号非法，请重新输入")
                    	window.location.href="register.jsp";
                    }
                    if(sms=="error_registered"){
                        alert("手机号已注册，请直接去登录")
                    }
                }
            });
        }else{
                alert("请输入手机号");
                return false;
        }
    });
    $("#lo").click(function(){
        var code=$("#code").val();
        if(code==""){
            alert("请输入验证码");
        }else{
            if(sms==code){
                window.location.href="nextRegister.jsp?phone="+phonenumber;
            }
            else{
                alert("验证码不正确")
            };
        };
    });
</script>
	<script type="text/javascript">jQuery(".banner").slide({
			titCell : ".hd ul",
			mainCell : ".bd ul",
			effect : "fold",
			autoPlay : true,
			autoPage : true,
			trigger : "click"
		});
	</script>


	<div class="banner-shadow"></div>
	<jsp:include page="foot.jsp"></jsp:include>
  </body>
</html>
