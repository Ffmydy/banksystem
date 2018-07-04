<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Struts2实现分页显示</title>
    <style type="text/css">  
    .br_TR{  
        background-color:expression(this.rowIndex%2==0?"#CCFFFF":"FFFFCC");  
        corhur:hand;  
    }  
      
    .br_head{  
        backgroun-color:"#CCFFDD";  
    }  
</style>
  </head>
  <body>
  <div align="center">
  <br />
  <h3><font color="blue">用户信息列表</font></h3>(注：每页最多显示五条数据)
  <br /><br />
  <!-- <table width="620">  
            <tr>  
                <td align="right"><a href="addUserPage.jsp">添加新用户</a></td> 
            </tr>  
  </table> -->
  <table border="1" align="center" bordercolor="99CCFF">
    <tr>

	   <th>账号</th>
	   <th>姓名</th>
	   <th>年龄</th>
	   <%-- <th>身份证号</th> --%>
	   
	   <th>电话</th>
	   <th>城市</th>
	   <th>地址</th>
	   <th>性别</th>
	   <th>余额</th>
	   <th>删除</th>
	   <th>修改</th>
	   <th>交易记录</th>
    </tr>
	<s:iterator value="userInfos">
	   <tr>
	      <td><s:property value="userNO"/></td>
	      <td><s:property value="userName"/></td>
	      <td><s:property value="userAge"/></td>
	      <%--<td><s:property value="idCard"/></td> --%>
	      
	      <td><s:property value="tel"/></td>
	      <td><s:property value="city"/></td>
	      <td><s:property value="address"/></td>
	      <td><s:property value="userSex"/></td>
	      <td><s:property value="balance"/></td>
	      <td><a href="deleteUserInfo2.action?userNO=<s:property value='userNO' />">删除</a></td> 
	      <td><a href="updateUserPage.jsp?userNO=<s:property value='userNO' />" >修改</a></td>
	      <td><a href="selectUserTradeInfo.action?userNO=<s:property value='userNO' />">交易记录</a></td>
	   </tr>
	</s:iterator>
	
	<div align="left">
  	
  </div>
  </table>
  <br />
     <s:url id="url_pre" value="show.action">
         <s:param name="pageNow" value="pageNow-1"></s:param>
     </s:url>

     <s:url id="url_next" value="show.action">
         <s:param name="pageNow" value="pageNow+1"></s:param>
     </s:url>  

     <s:a href="%{url_pre}">上一页</s:a>
     
     <s:iterator value="userInfos" status="status">
        <s:url id="url" value="show.action">
            <s:param name="pageNow" value="pageNow"/>
        </s:url>
     </s:iterator>
	 &nbsp;
     <s:a href="%{url_next}">下一页</s:a> 
  </div>
  
  </body>
</html>
