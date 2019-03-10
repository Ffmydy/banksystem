<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
	<link rel="stylesheet" type="text/css" href="css/managermain.css">
	
  </head>
  
  <body>
    <div id="header">
			<h1>
				欢迎<a id="name">${sessionScope.customer.getCname() }</a>登录在线超市
			</h1>
		</div>
  </body>
</html>
