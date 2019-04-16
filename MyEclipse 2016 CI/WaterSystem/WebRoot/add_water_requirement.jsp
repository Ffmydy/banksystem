<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.haut.beans.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="css/mycss.css" />
</head>
<body>
<c:if test="${not empty error }">
	<script type="text/javascript">
	alert('${error}')
	</script>
</c:if>
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
		</div>

		<div class="table" id="table">
			<table border="1px">
				<tr class="head" id="water_requirement">
					<td>年份</td>
					<td>月份</td>
					<td>月需水量</td>
					<td>操作</td>
				</tr>
			<form action="add_water_requirement.do" method="post">
			     <tr>
					<td><input type="text" name="year"/></td>
					<td><select name="month">
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
				    </select></td>
					<td><input type="text" name="water_requirement"/></td>
					<td><input type="submit" value="添加" /></td>
				</tr>
			</form>
			</table>
		</div>
	</div>
</body>
</html>
