<%@ page contentType="text/html; charset=GBK" language="java"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><%request.setCharacterEncoding("GBK");%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>银行账户管理系统 </title>
</head>
<%@include file="check.jsp"%>
<body>
<p>&nbsp;</p>
<p><a href="main.jsp" target="mainFrame"><img src="image/leave50.gif" width="158" height="43" border="1"></a></p>
<p><a href="save.jsp" target="mainFrame"><img src="image/deposit.gif" width="158" height="43" border="1"></a></p>
<p><a href="fetch.jsp" target="mainFrame"><img src="image/withdraw.gif" width="158" height="43" border="1"></a></p>
<p><a href="selectBalance.action" target="mainFrame"><img src="image/leave51.gif" width="158" height="43" border="1"></a></p>
<p><a href="selectTradeInfo.action" target="mainFrame"><img src="image/tradeinfo.gif" width="158" height="40" border="1"></a></p>
<p><a href="selectUser.action" target="mainFrame" ><img src="image/userinfo.gif" width="158" height="40" border="1"></a></p>
<p><a href="updateUser.jsp"  target="mainFrame"><img src="image/update.gif" width="158" height="40" border="1"></a></p>
<p><a href="logout.action" target="_parent"><img src="image/leave.gif" width="158" height="40" border="1"></a></p>
<p><a href="deleteUserInfo.jsp" target="mainFrame"><img src="image/destroy.gif" width="158" height="40" border="1"></a></p>
</body>
</html>
