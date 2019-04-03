<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>万佛湖水资源管理系统</title>
<link href="css/login.css" rel="stylesheet" rev="stylesheet"
	type="text/css" media="all" />
<link href="css/demo.css" rel="stylesheet" rev="stylesheet"
	type="text/css" media="all" />
<script type="text/javascript" src="js/jquery1.42.min.js"></script>
<script type="text/javascript" src="js/jquery.SuperSlide.js"></script>
<script type="text/javascript" src="js/Validform_v5.3.2_min.js"></script>
</head>
<body>
	<div class="header">
		<h1 class="headerLogo">
			<font color="red" size="20px">万佛湖水资源管理系统</font>
		</h1>
		<div class="headerNav">
			<a target="_blank" href="http://www.wanfohu.com.cn/">万佛湖官网</a> <a
				target="_blank"
				href="https://baike.baidu.com/item/%E4%B8%87%E4%BD%9B%E6%B9%96/625627">万佛湖百科</a>
		</div>
	</div>
	<div class="banner">
		<div class="login-aside">
			<div id="o-box-up"></div>
			<div id="o-box-down" style="table-layout:fixed;">
				<form class="registerform" action="${pageContext.request.contextPath}/font/login.do" method="post">
					<div class="fm-item">
						<label for="logonId" class="form-label">系统账号：</label> <input
							type="text" placeholder="请输入账号" maxlength="100" id="username" name="phonenumber"
							class="i-text">
					</div>
					<div class="fm-item">
						<label for="logonId" class="form-label">系统密码：</label> <input
							type="password" value="" maxlength="100" id="password" name="password"
							class="i-text">
						<div class="ui-form-explain"></div>
					</div>

					<div class="fm-item pos-r">
						<label for="logonId" class="form-label">验证码</label> <input
							type="text" value="输入验证码" maxlength="100" id="yzm"
							class="i-text yzm">
							<div class="ui-form-explain">
								<img src="images/yzm.jpg" class="yzm-img" />
							</div>
					</div>
					<div class="fm-item">
						<label for="logonId" class="form-label"></label> <input
							type="submit" value="" tabindex="4" id="send-btn"
							class="btn-login"> <input type="button" value=""
							tabindex="4" id="reg-btn" class="btn-reg" />
						<div class="ui-form-explain"></div>
					</div>
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

	<div class="footer">
		<p>杜玉的毕业设计 ，翻版必究！2019/4/3开始写代码！</p>
	</div>
	<div style="display:none">
		<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540'
			language='JavaScript' charset='gb2312'></script>
	</div>
</body>
</html>
