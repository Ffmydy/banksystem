<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.haut.beans.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="css/mycss.css" />
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
<%Manage manage=(Manage)session.getAttribute("manage");
 session.setAttribute("item_number", request.getParameter("item_number"));
 session.setAttribute("item_name", request.getParameter("item_name"));
 %>
	<jsp:include page="model.jsp" />
	<div class="menu-right">
	<div class="l-tab-links"></div>
	<div class="verifyidentity">
		<form action="">
			    <p>
					您的手机号:<input type="text" id="phone" name="manage_phonenumber"  value="<%=manage.getManage_phonenumber()%>" readonly="readonly"/>&nbsp&nbsp&nbsp&nbsp<input type="button" class="btn btn-default" id="btn" name="btn" value="发送验证码" />
				</p>
				<p>
				          输入验证码:<input type="text" id="code" name="code" placeholder="验证码" required/>
				</p>
				<p>
				   <button type="button" class="btn btn-info" id="lo" onclick="javascript:return confirm('确认删除该项目信息？');">删除</button>
				</p>
		</form>	
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
                url:"verifyIdentity.do",
                type:"post",
                data:{"manage_phonenumber":manage_phonenumber},
                success:function(result){
                    sms=result;
                    if(sms=="error_phonenumber"){
                    	alert("手机号非法，请重新输入")
                    	window.location.href="verifyidentity_deleteitem.jsp";
                    }
                    if(sms=="error_not_register"){
                    	alert("您输入的手机号 没有注册，请查证后再输入")
                    	window.location.href="verifyidentity_deleteitem.jsp";
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
                window.location.href="deleteprogram.do";
            }
            else{
                alert("验证码不正确")
            };
        };
    });
    </script>
</body>
</html>
