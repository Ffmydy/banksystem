<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%> 
<html>
  <body>
  <center>
  <br /> <br /> <br />  
    <h3>修改密码</h3>  
    <strong>
    	<font color="red"></font>
    </strong>
      
        <s:form action="changePassValidate" validate="true">  
        	当前账号： &nbsp; &nbsp; &nbsp;  &nbsp;
        	<s:property value="#session.user.userNO" />
            <s:password name="passwd" label="密码" />  
            <s:password name="p2" label="请再次输入密码" />  
            <s:password name="userInfo.newpassword" label="新密码" />  
            <s:password name="np2" label="请再次输入密码" />  
            <s:submit value="修改密码" />  
        </s:form>  
  </center>
  </body>
</html>
