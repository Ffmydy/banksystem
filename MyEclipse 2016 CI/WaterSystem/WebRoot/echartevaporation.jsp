<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.haut.beans.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <link type="text/css" rel="stylesheet" href="css/mycss.css" />
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/echarts-all.js"></script>
  
    <base href="<%=basePath%>">
    
    <title>万佛湖水资源管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  
  <body>
   <jsp:include page="model.jsp" />
	<div class="menu-right">
		<div class="l-tab-links"></div>
		<div class="vaguequery">
		<font size="4px" color="red">输入年份：</font>
		    <form id="tf">
			年份:<input type="text" name="year" id="year"/>
			<input type="button" value="图表显示" onclick="getdate(document.getElementById('year').value)"/>
			</form>
		</div>
		<div class="table" id="table">	  
              <!-- 柱状图bar -->
			 <div id="main" style="width: 600px;height:400px;"></div>
		</div>
	</div>
	<script type="text/javascript">
        var myChart;//定义一个全局的图表变量，供后面动态加载时使用
		function getdate(year){
            var months=[];//用来盛放X轴坐标值：月份
            var evapCapacitys=[];//用来盛放Y坐标值：蒸发量
			 $.ajax({
                type: "post",
                async: true, //异步请求
                url:"check_someyear_allmonth_evaporationechart.do",
                data:{"year":year},
                dataType:"JSON",
                success:function(result){
                    if (result.status) {
                        var list = result.list;
                        for(var i=0;i<list.length;i++){
                            months.push(list[i].month);    //遍历月份并填入数组
                        }
                        for(var i=0;i<list.length;i++){
                            evapCapacitys.push(list[i].evapCapacity);    //遍历蒸发量并填入数组
                        }
                        myChart.setOption({        //加载数据图表
                            tooltip : {
                                trigger: 'axis'
                            },
                            legend: {
                                data:['蒸发量']
                            },
                            toolbox: {
                                show : true,
                                feature : {
                                    mark : {show: true},
                                    dataView : {show: true, readOnly: false},
                                    magicType : {show: true, type: ['line', 'bar']},
                                    restore : {show: true},
                                    saveAsImage : {show: true}
                                }
                            },
                            calculable : true,
                            xAxis: {
                                data: months
                            },
                            yAxis:{},//注意一定不能丢了这个，不然图表Y轴不显示
                            series: [{
                                // 根据名字对应到相应的系列，并且要注明type
                                name: '蒸发量',
                                type:'bar',
                                data: evapCapacitys
                            }]
                        });
 
                    }
                },
                error : function(errorMsg) {
                    //请求失败时执行该函数
                    alert(errorMsg);
                    alert("图表请求数据失败!");
                }
            });
        }
    </script>
  </body>
</html>
