<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.haut.beans.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>万佛湖水资源管理系统</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<link type="text/css" rel="stylesheet" href="css/main.css" />
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/menu.js"></script>
<script type="text/javascript">
	window.setInterval("showtime()", 1000);
	function showtime() {
		var date = new Date();
		var year = date.getFullYear();
		var month = date.getMonth() + 1;
		var day = date.getDate();
		var hh = date.getHours();
		var mi = date.getMinutes();
		var ss = date.getSeconds();
		var wk = "星期" + "日一二三四五六".charAt(date.getDay());
		document.getElementById("show_time").innerHTML = year + "-" + month + "-" + day + " " + hh + ":" + mi + ":" + ss + " " + wk;
	}
</script>
</head>
<body>
	<%
		Manage manage = (Manage) request.getAttribute("manage");
	%>
	<div class="container">
		<div class="cont-top">
			<div class="companyname">万佛湖水资源管理系统</div>
			<div class="cont-top-rg">
				<ul class="advanced-menu">
					<li class="default" style="position:relative;"><span
						id="show_time" />
						<div class="drop-down-wrap"
							style="width:180px;left:15px;display:none">
							<div class="drop-down">
								<span class="triangle-border"></span> <span class="triangle-bg"></span>
							</div>
						</div></li>
				</ul>
			</div>
		</div>
		<div class="left-menu" style="height:949px;">
			<div class="menu-list">
				<ul>
					<li class="menu-list-01"><a href="main.jsp">
							<p class="fumenu">首页</p> <img class="xiala"
							src="images/xiala.png" />
					</a></li>
					<li class="menu-list-02"><a href="#">
							<p class="fumenu">水检管理</p> <img class="xiala"
							src="images/xiala.png" />
					</a>
						<div class="list-p">
							<p class="zcd" id="zcd5">
								<a href="checkprogram.do">水检项目表</a>
							</p>
							<p class="zcd">
								<a href="checkunqualified_program.do">不合格项目表</a>
							</p>
							<p class="zcd">
								<a href="checkoperation.do">管理操作表</a>
							</p>
							<p class="zcd" id="zcd6">
								<a href="checkunit.do">水检单位表</a>
							</p>
							<p class="zcd" id="zcd7">
								<a href="checkboss.do">水检负责人</a>
							</p>
						</div></li>
					<li class="menu-list-01"><a href="#">
							<p class="fumenu">水需管理</p> <img class="xiala"
							src="images/xiala.png" />
					</a>
						<div class="list-p">
							<p class="zcd" id="zcd8">
								<a href="checkwater_requirement.do">各月份水需求量</a>
							</p>
							<p class="zcd" id="zcd9">所属员工</p>
							<p class="zcd" id="zcd10">订单成本</p>
							<p class="zcd" id="zcd1">订单成本费用</p>
							<p class="zcd" id="zcd12">订单总支付金额</p>
							<p class="zcd" id="zcd3">订单商品</p>
							<p class="zcd" id="zcd14">手动增加订单</p>
						</div></li>

					<li class="menu-list-02"><a href="#">
							<p class="fumenu">财务管理</p> <img class="xiala"
							src="images/xiala.png" />
					</a>
						<div class="list-p">
							<p class="zcd" id="zcd15">记录出款和入款</p>
							<p class="zcd" id="zcd16">计算一段时间的利润</p>
						</div></li>

					<li class="menu-list-01"><a href="#">
							<p class="fumenu">客户管理</p> <img class="xiala"
							src="images/xiala.png" />
					</a>
						<div class="list-p">
							<p class="zcd" id="zcd17">客户基本信息</p>
							<p class="zcd" id="zcd18">客户VIP登记管理</p>
							<p class="zcd" id="zcd19">客户信息管理</p>
							<p class="zcd" id="zcd20">客户订单管理</p>
							<p class="zcd" id="zcd21">转移客户</p>
						</div></li>
					<li class="menu-list-02"><a href="#">
							<p class="fumenu">员工管理</p> <img class="xiala"
							src="images/xiala.png" />
					</a>
						<div class="list-p">
							<p class="zcd" id="zcd22">员工基本信息</p>
							<p class="zcd" id="zcd23">员工权限</p>
							<p class="zcd" id="zcd24">开通新客户</p>
							<p class="zcd" id="zcd25">销售额管理</p>
						</div></li>
				</ul>
			</div>
		</div>
</body>
</html>