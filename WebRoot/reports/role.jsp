<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<head>
	    <meta charset="utf-8">
	    <title></title>
	    <jsp:include page="../include.jsp"></jsp:include>
	    <link href="../js/Metro-UI-CSS-master/docs/css/metro-bootstrap.css" rel="stylesheet">
	    <link href="../js/Metro-UI-CSS-master/docs/css/iconFont.css" rel="stylesheet">
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
		<a href="${pageContext.request.contextPath}/index.jsp" style=" position: absolute;right: 30px;top: 20px; border:1px solid #666;padding:5px;">
         	<span class="first-name">返回首页&nbsp;<span class="icon-arrow-right"></span></span>
        </a>
		
		<div id="main" style="width:900px;height:500px;margin:40px auto;"></div>
		
		<script type="text/javascript">
			$(function() {
				query();
		  	});
			function query() {
				var roleNames,data;
				$.ajax({
					type:"POST",
					url:"/CRS/report/analysisRole",
					async: false,
					data: {},
					success: function(result) {
						roleNames = result.roleNames;
						data = result.data;
					}
				});
		
				require(	[
						 'echarts', 
						 'echarts/chart/pie', // 使用柱状图就加载bar模块，按需加载
						 'echarts/chart/funnel'
					], 
					function(ec)  {
						//  初始化echarts图表
						var myChart = ec.init(document.getElementById('main'));
						option = {
						    title : {
						        text: '系统用户角色分布统计',
						        subtext: '',
						        x:'center'
						    },
						    tooltip : {
						        trigger: 'item',
						        formatter: "{a} <br/>{b} : {c} ({d}%)"
						    },
						    legend: {
						        orient : 'vertical',
						        x : 'left',
						        data: roleNames
						    },
						    toolbox: {
						        show : true,
						        feature : {
						            mark : {show: true},
						            dataView : {show: true, readOnly: false},
						            magicType : {
						                show: true, 
						                type: ['pie', 'funnel'],
						                option: {
						                    funnel: {
						                        x: '25%',
						                        width: '50%',
						                        funnelAlign: 'left',
						                        max: 1548
						                    }
						                }
						            },
						            restore : {show: true},
						            saveAsImage : {show: true}
						        }
						    },
						    calculable : true,
						    series : [
						        {
						            name:'面积模式',
						            type:'pie',
						            radius : '55%',
						            center: ['50%', '60%'],
						            roseType : 'area',
						            x: '50%',               // for funnel
						            max: 40,                // for funnel
						            sort : 'ascending',     // for funnel
						            data:data
						        }
						    ]
						};
                    
		
					// 为echarts对象加载数据 
					myChart.setOption(option);
				});

			}
		</script>
	
	</body>
</html>
