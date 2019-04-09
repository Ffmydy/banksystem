<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.haut.beans.*" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>首页</title>
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
	<%Manage manage=(Manage)request.getAttribute("manage"); %>
	<div class="container">
		<div class="cont-top">
			<div class="companyname">万佛湖水资源管理系统</div>
			<div class="cont-top-rg">
				<ul class="advanced-menu">
					<li class="default" style="position:relative;">
						<div class="touxiang">
							<span class="user"><img src="images/user.png"></span> 
								<a class="special"><%=manage.getManage_name()%></a> <span id="show_time" />
						</div>
						<div class="drop-down-wrap"
							style="width:180px;left:15px;display:none">
							<div class="drop-down">
								<span class="triangle-border"></span> <span class="triangle-bg"></span>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
		<div class="left-menu" style="height:949px;">
			<div class="menu-list">
				<ul>
					<li class="menu-list-01"><a href="ck-kffp.html">
							<p class="fumenu">库房管理</p> <img class="xiala"
							src="images/xiala.png" />
					</a>
						<div class="list-p">
							<p class="zcd" id="zcd5">入库单</p>
							<p class="zcd" id="zcd6">出库单</p>
							<p class="zcd" id="zcd7">库存余额表</p>
						</div></li>

					<li class="menu-list-02"><a href="ckgl.html">
							<p class="fumenu">产品管理</p> <img class="xiala"
							src="images/xiala.png" />
					</a>
						<div class="list-p">
							<p class="zcd" id="zcd5">产品库存</p>
							<p class="zcd" id="zcd6">产品成本</p>
							<p class="zcd" id="zcd7">产品属性管理</p>
						</div></li>

					<li class="menu-list-01"><a href="dd-ddgl.html">
							<p class="fumenu">订单管理</p> <img class="xiala"
							src="images/xiala.png" />
					</a>
						<div class="list-p">
							<p class="zcd" id="zcd8">下单账户</p>
							<p class="zcd" id="zcd9">所属员工</p>
							<p class="zcd" id="zcd10">订单成本</p>
							<p class="zcd" id="zcd1">订单成本费用</p>
							<p class="zcd" id="zcd12">订单总支付金额</p>
							<p class="zcd" id="zcd3">订单商品</p>
							<p class="zcd" id="zcd14">手动增加订单</p>
						</div></li>

					<li class="menu-list-02"><a href="cj-ckd.html">
							<p class="fumenu">财务管理</p> <img class="xiala"
							src="images/xiala.png" />
					</a>
						<div class="list-p">
							<p class="zcd" id="zcd15">记录出款和入款</p>
							<p class="zcd" id="zcd16">计算一段时间的利润</p>
						</div></li>

					<li class="menu-list-01"><a href="kh-khgl.html">
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

					<li class="menu-list-02"><a href="yg-jbxx.html">
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
		<div class="right-menu">
			<div class="main-hd">
				<div class="page-teb" style="height:887px;">
					<div class="l-tab-links">
						<ul style="left:0;">
							<li class="l-select"><a href="#" style="padding:0 25px;">首页</a>
							</li>
						</ul>
					</div>
					<div class="l-tab-content" style="height:851px;">
						<div class="tab-content-item">
							<div class="home">
								<!--成交金额-->
								<div class="space-style">
									<div class="col-xs">
										<a href="#" class="title-button bg-deep">
											<div class="carousel">
												<div class="left-img">
													<i><img src="images/left-img1.png"></i>
													<p>成交金额</p>
												</div>
												<div class="right-info">4536.25元</div>
											</div>
										</a>
									</div>

									<div class="col-xs">
										<a href="#" class="title-button bg-red">
											<div class="carousel">
												<div class="left-img bg-color-red">
													<i><img src="images/left-img2.png"></i>
													<p>订单</p>
												</div>
												<div class="right-info">4589笔</div>
											</div>
										</a>
									</div>

									<div class="col-xs">
										<a href="#" class="title-button bg-green">
											<div class="carousel">
												<div class="left-img bg-color-green">
													<i><img src="images/left-img3.png"></i>
													<p>通知</p>
												</div>
												<div class="right-info">125条</div>
											</div>
										</a>
									</div>

									<div class="col-xs">
										<a href="#" class="title-button bg-orange">
											<div class="carousel">
												<div class="left-img bg-color-orange">
													<i><img src="images/left-img4.png"></i>
													<p>待处理</p>
												</div>
												<div class="right-info">10条</div>
											</div>
										</a>
									</div>

									<div class="col-xs">
										<a href="#" class="title-button bg-purple">
											<div class="carousel">
												<div class="left-img bg-color-purple">
													<i><img src="images/left-img5.png"></i>
													<p>留言</p>
												</div>
												<div class="right-info">48条</div>
											</div>
										</a>
									</div>

									<div class="col-xs">
										<a href="#" class="title-button bg-yellow">
											<div class="carousel">
												<div class="left-img bg-color-yellow">
													<i><img src="images/left-img6.png"></i>
													<p>紧急通知</p>
												</div>
												<div class="right-info">2条</div>
											</div>
										</a>
									</div>
								</div>

								<!--折线图-->
								<div class="home-goods panel">
									<div class="home-mychart" style="height:400px;overflow:hidden;">
										<p>销售对比分析</p>
										<img src="images/chart.png">
									</div>
								</div>

								<!--销售情况-->
								<div class="order-form">
									<div class="col-xs-3 col-lg-7">
										<div class="admin-info">
											<div class="title-name">
												<i></i> 登录记录 <a href="#">+更多</a>
											</div>
											<table class="record-list">
												<tbody>
													<tr>
														<td>管理员</td>
														<td>2017-05-26</td>
													</tr>

													<tr>
														<td>管理员</td>
														<td>2017-05-26</td>
													</tr>

													<tr>
														<td>管理员</td>
														<td>2017-05-26</td>
													</tr>

													<tr>
														<td>管理员</td>
														<td>2017-05-26</td>
													</tr>

													<tr>
														<td>管理员</td>
														<td>2017-05-26</td>
													</tr>

													<tr>
														<td>管理员</td>
														<td>2017-05-26</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>

									<div class="col-xs-6 ranking-style">
										<div class="frame">
											<div class="title-name">
												<i></i> 商品销售排行 <a href="#">+更多</a>
											</div>
											<table class="table table-list">
												<thead>
													<tr>
														<th width="50">排名</th>
														<th>商品编号</th>
														<th>商品名称</th>
														<th width="80">销售数量</th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td><em>1</em></td>
														<td>2355456</td>
														<td><a href="#">景观灯系列</a></td>
														<td>26</td>
													</tr>

													<tr>
														<td><em>1</em></td>
														<td>2355456</td>
														<td><a href="#">景观灯系列</a></td>
														<td>26</td>
													</tr>

													<tr>
														<td><em>1</em></td>
														<td>2355456</td>
														<td><a href="#">景观灯系列</a></td>
														<td>26</td>
													</tr>

													<tr>
														<td><em>1</em></td>
														<td>2355456</td>
														<td><a href="#">景观灯系列</a></td>
														<td>26</td>
													</tr>

													<tr>
														<td><em>1</em></td>
														<td>2355456</td>
														<td><a href="#">景观灯系列</a></td>
														<td>26</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
