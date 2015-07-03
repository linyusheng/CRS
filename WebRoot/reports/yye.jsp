<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<head>
	    <meta charset="utf-8">
	    <title>本店营业额对比分析</title>
	    <link href="${pageContext.request.contextPath}/js/Metro-UI-CSS-master/docs/css/metro-bootstrap.css" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/js/Metro-UI-CSS-master/docs/css/iconFont.css" rel="stylesheet">
	    <jsp:include page="../include.jsp"></jsp:include>
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
		<center><h1 style="height: 70px;line-height: 70px;">本店营业额对比分析</h1></center>
		<a href="${pageContext.request.contextPath}/index.jsp" style=" position: absolute;right: 30px;top: 20px; border:1px solid #666;padding:5px;">
         	<span class="first-name">返回首页&nbsp;<span class="icon-arrow-right"></span></span>
        </a>
		
		<div style="width:900px;margin:0 auto;">
			<label>开始时间:</label>
			<input id="startTime" type="text" width="130px" class="easyui-datebox" style="width:130px">
			<label>结束时间:</label>
			<input id="endTime" type="text" width="130px" class="easyui-datebox" style="width:130px">
			<label>选择店名:</label>
			<select id="shopName" class="easyui-combobox" name="dept" style="width:200px;">   
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
				//给datebox一个默认值
				$('#startTime').datebox("setValue",'2014-08-10');
				$('#endTime').datebox("setValue",'2014-08-30');
				query();
		  	});
			function query() {
				//获取所有查询参数
		  		var startTime = $('#startTime').datebox("getValue");
		  		var endTime = $('#endTime').datebox("getValue");
		  		var shopName = $('#shopName').combobox("getValue");
				var yye_ary  = [];	//客流量数组
				var day_ary   = [];	//日期数组
				var colors = [ '#ff7f50', '#87cefa', '#da70d6', '#32cd32', '#6495ed','#ff69b4', '#ba55d3', '#cd5c5c', '#ffa500', '#40e0d0','#1e90ff', '#ff6347', '#7b68ee', '#00fa9a', '#ffd700','#6b8e23', '#ff00ff', '#3cb371', '#b8860b', '#30e0e0' ];
				$.ajax({
							type:"POST",
							url:"/CRS/report/yye",
							async: false,
							data: {startTime:startTime,endTime:endTime,shopName:shopName},
							success: function(data) {
								day_ary = data.date_array;
								yye_ary = data.kll_array;
							}
						});
		
				//return;
		
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
							text : '本店营业额对比图',
							subtext : shopName
						},
						color: colors,   //颜色
						tooltip : {
							trigger : 'axis'
						},
						legend : {
							data :  [shopName]  //标题
						},
						toolbox : {
							show : true,
							feature : {
								mark : {
									show : true
								},
								dataView : {
									show : true,
									readOnly : false
								},
								magicType : {
									show : true,
									type : [ 'bar', 'line' ]
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
							data : day_ary
						} ],
						yAxis : [ {
							type : 'value'
						} ],
						series : [
								{
									name : '营业额',
									type : 'line',
									data : yye_ary,
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
