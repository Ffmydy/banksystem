<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.haut.beans.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="css/mycss.css" />
</head>
<body>
	<jsp:include page="model.jsp" />
	<div class="menu-right">
		<div class="l-tab-links"></div>
		<div class="query">
			<div class="accuratequery">
				<font size="4px" color="red">查询某月的具体需水量：</font>
				<form action="check_somemonth_water_requirement.do" method="post">
					年份:<input type="text" name="year" />月份:<select name="month">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
						<option>8</option>
						<option>9</option>
						<option>10</option>
						<option>11</option>
						<option>12</option>
					</select> <input type="submit" value="查询" />
				</form>
			</div>
			<br /> <br />
			<div class="vaguequery">
				<font size="4px" color="red">查询某年各月份的具体需水量：</font>
				<form action="">
					年份:<input type="text" name="year" /> <input type="submit"
						value="查询" />
				</form>
			</div>
			<br /> <br />
			<div class="countrequirement_bymonth">
				<font size="4px" color="red">按月计算需水量</font>
				<form action="count_requirement_bymonth.do" method="get">
					月份:<select name="month">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
						<option>8</option>
						<option>9</option>
						<option>10</option>
						<option>11</option>
						<option>12</option>
					</select> <input type="submit" value="计算" />
				</form>
			</div>
			<br /> <br />
			<div class="countrequirement_byyear">
				<font size="4px" color="red">按年计算需水量</font>
				<form action="count_requirement_byyear.do" method="get">
					年份：<input type="text" name="year" /> <input type="submit"
						value="计算" />
				</form>
			</div>
		</div>

		<div class="table" id="table">
			<table border="1px">
				<tr class="head" id="water_requirement">
					<td>年份</td>
					<td>该年份每月需水量之和</td>
					<td>该年份每月平均需水量</td>
				</tr>
				<tr>
					<td>${count_requirement_byyear.year }</td>
					<td>${count_requirement_byyear.year_water_requirement }</td>
					<td>${count_requirement_byyear.year_average_water_requirement }</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>
