<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<head>
	    <meta charset="utf-8">
	    <title>本店客流量对比表</title>
	    <jsp:include page="../include.jsp"></jsp:include>
	    <link href="${pageContext.request.contextPath}/js/Metro-UI-CSS-master/docs/css/metro-bootstrap.css" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/js/Metro-UI-CSS-master/docs/css/iconFont.css" rel="stylesheet">
	    <script type="text/javascript" src="../js/dist/echarts.js"></script>
	    <script type="text/javascript">
			require.config({
				paths : {
					echarts : '/CRS/js/dist'
				}
			});
		</script>
	</head>
	<body>
		<center><h1 style="height: 70px;line-height: 70px;">本店客流量对比统计</h1></center>
		<a href="${pageContext.request.contextPath}/index.jsp" style=" position: absolute;right: 30px;top: 20px; border:1px solid #666;padding:5px;">
         	<span class="first-name">返回首页&nbsp;<span class="icon-arrow-right"></span></span>
        </a>
		
		<div style="width:700px;margin:0 auto;">
			<label>选择日期:</label>
			<input id="datetime" type="text" width="130px" class="easyui-datebox" style="width:130px">
			<label>选择店名:</label>
			<select id="shopName" class="easyui-combobox" style="width:200px;">   
			    <option value="和毅总店">和毅总店</option>   
			    <option value="和毅体育新城店">和毅体育新城店</option>      
			</select> 

			<a href="javascript:void(0)" class="easyui-linkbutton"  style="margin-left: 15px;" onclick="query()">
				<font size="3" color="blue">统计结果</font>
			</a>
		</div>
		
		<div id="main" style="height:500px"></div>
		
		<script type="text/javascript">
			$(function() {
				$('#datetime').datebox("setValue",'2014-08-27');
				query();
		  	});
			function query() {
				//获取所有查询参数
		  		var datetime = $('#datetime').datebox("getValue");
		  		var shopName = $('#shopName').val();
				var data_ary = [];
				$.ajax({
							type:"POST",
							url:"/CRS/report/hourkll",
							async: false,
							data: {datetime:datetime,shopName:shopName},
							success: function(data) {
								data_ary = data;
							}
						});
		
		
				require(	[
						 'echarts', 
						 'echarts/chart/bar', // 使用柱状图就加载bar模块，按需加载
						 'echarts/chart/line'
					], 
					function(ec)  {
						//  初始化echarts图表
						var myChart = ec.init(document.getElementById('main'));
		
					option = {
						title : {
							text : '本店每天24小时客流量对比',
							subtext :  shopName
						},
						color:['#32cd32'],  
						tooltip : {
							trigger : 'axis'
						},
						legend : {
							data : [ "进客数" ]
						},
						toolbox : {
							show : true,
							feature : {
								mark : {
									show : true
								},
								dataView : {
									show : true,
									readOnly : true
								},
								magicType : {
									show : true,
									type : [ 'line', 'bar' ]
								},
								restore : {
									show : true
								},
								saveAsImage : {
									show : true
								}
							}
						},
						calculable : true,
						xAxis : [ {
							type : 'category',
							data : [ '0时','1时', '2时', '3时', '4时', '5时', '6时', '7时', '8时','9时', '10时', '11时', '12时', '13时', '14时', '15时', '16时', '17时', '18时', '19时', '20时','21时', '22时', '23时']
						} ],
						yAxis : [ {
							type : 'value'
						} ],
						series : [
								{
									name : '进客数',
									type : 'line',
									data : data_ary,
									markPoint : {
										data : [ {
											type : 'max',
											name : '最大值'
										}, {
											type : 'min',
											name : '最小值'
										} ]
									},
									markLine : {
										data : [ {
											type : 'average',
											name : '平均值'
										} ]
									}
								} ]
					};
		
					// 为echarts对象加载数据 
					myChart.setOption(option);
				});
			}
		</script>
	
	</body>
</html>
