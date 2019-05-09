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
		<div class="accuratequery"><font size="4px" color="red">查询某月的具体蒸发量：</font>
			<form action="check_somemonth_water_evaporation.do" method="post">
				年份:<input type="text" name="year"/>月份:<select name="month" >
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
				</select>
				<input type="submit" value="查询"/>
			</form>
		</div>
		<br/>
		<br/>
		<div class="vaguequery"><font size="4px" color="red">查询某年各月份的具体蒸发量：</font>
			<form action="check_someyear_allmonth_evaporation.do">
			年份:<input type="text" name="year"/>
			<input type="submit" value="表格显示"/>
			</form>
			<form action="check_someyear_allmonth_evaporationechart.do">
			年份:<input type="text" name="year"/>
			<input type="submit" value="图表显示"/>
			</form>
		</div>
		<br/>
		<br/>
		<div class="countevaporation_bymonth"><font size="4px" color="red">按月计算蒸发量</font>
			<form action="count_evaporation_bymonth.do" method="get">
			月份:<select name="month" style="width: 135px">
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
				</select>
				<input type="submit" value="计算"/>
			</form>
		</div>
		<br/>
		<br/>
		<div class="countevaporation_byyear"><font size="4px" color="red">按年计算蒸发量</font>
			<form action="count_evaporation_byyear.do" method="get">
			年份：<input type="text" name="year" />
			<input type="submit" value="计算"/>
			</form>
		</div>
		</div>
		<div class="table" id="table">
			<table border="1px">
				<tr class="head" id="water_evaporation">
					<td>需水记录序号</td>
					<td>年份</td>
					<td>月份</td>
					<td>月蒸发量</td>
				</tr>
				<c:forEach items="${lists}" var="pi">
					<tr>
						<td>${pi.water_evaporation_id }</td>
						<td>${pi.year}</td>
						<td>${pi.month}</td>
						<td>${pi.water_evaporation}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
