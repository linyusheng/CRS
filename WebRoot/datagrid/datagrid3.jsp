<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title></title>
    <jsp:include page="../include.jsp"></jsp:include>
    <link href="${pageContext.request.contextPath}/js/Metro-UI-CSS-master/docs/css/metro-bootstrap.css" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/js/Metro-UI-CSS-master/docs/css/iconFont.css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8">
	var datagrid;
	var editRow = undefined;
	$(function() {
		//给datebox一个默认值
		$('#datetime').datebox("setValue",'2014-08-27');
		query();
	});
	function query(){
		var datetime = $('#datetime').datebox("getValue");
  		var shopName = $('#shopName').combobox("getValue");
		datagrid = $("#datagrid").datagrid({
			url : '${pageContext.request.contextPath}/report/workAnalysis',
			title : '',
			iconCls : 'icon-save',
			pagination : true,
			pageSize : 10,
			pageList : [ 10, 20, 30, 40 ],
			fit : true,
			fitColumns : false,
			nowarp : false,
			border : false,
			scrollbarSize : 0,
			idField : 'fmd',
			sortName : 'date',//定义哪些列可以进行排序
			sortOrder : 'desc',		//定义列的排序顺序，只能是'asc'或'desc'
			queryParams : {
				datetime : datetime,
				shopName : shopName
			},
			columns:[[{
		    	field:'fmd',
		        title:'店名',
		        width:100
		    },{
		    	field:'date',
		        title:'时间',
		        width:100,
				formatter: function(value,rowData,rowIndex){
					var str = ['00:00-01:00','01:00-02:00','02:00-03:00','03:00-04:00','04:00-05:00',
							   '05:00-06:00','06:00-07:00','07:00-08:00','08:00-09:00','09:00-10:00',
							   '10:00-11:00','11:00-12:00','12:00-13:00','13:00-14:00','14:00-15:00',
							   '15:00-16:00','16:00-17:00','17:00-18:00','18:00-19:00','19:00-20:00',
							   '20:00-21:00','21:00-22:00','22:00-23:00','23:00-00:00'
					]
					return str[parseInt(value)];
				}
		    },{
		    	field:'saleAmount',
		        title:'进客数',
		        width:100
		    },{
		    	field:'discount',
		        title:'开单数',
		        width:100
		    },{
		    	field:'rewards',
		        title:'结账单数',
		        width:100
		    },{
		    	field:'saleFinal',
		        title:'点单次数',
		        width:100
		    },{
		    	field:'passengerFolw',
		        title:'上钟次数',
		        width:100
		    },{
		    	field:'avgAccount',
		        title:'人均消费',
		        width:100
		    }]],
			onBeforeLoad : function(param) {
				parent.$.messager.progress({
					text : '数据加载中....'
				});
			},
			onLoadSuccess : function(data) {
				console.info(data);
				parent.$.messager.progress('close');
			}
		});	
	}
		
	</script>
  </head>
  <body>
  	<center><h1 style="height: 70px;line-height: 70px;">营业时段分析表(0-23小时)</h1></center>
	<a href="${pageContext.request.contextPath}/index.jsp" style=" position: absolute;right: 30px;top: 20px; border:1px solid #666;padding:5px;">
         	<span class="first-name">返回首页&nbsp;<span class="icon-arrow-right"></span></span>
    </a>
	
	<div style="width:874px;margin:0 auto;">
		<label>选择时间:</label>
		<input id="datetime" type="text" width="130px" class="easyui-datebox" style="width:130px">
		<label>选择店名:</label>
		<select id="shopName" class="easyui-combobox" name="dept" style="width:200px;">   
		    <option value="和毅总店">和毅总店</option>   
		    <option value="和毅体育新城店">和毅体育新城店</option>    
		</select>
		<a href="javascript:void(0)" class="easyui-linkbutton"  style="margin-left: 15px;" onclick="query()">
			<font size="3" color="blue">统计结果</font>
		</a>
		<div style="margin-top:15px;height: 500px;border:1px solid #D4D4D4;"><table id="datagrid"></table></div>
	</div>
	
	
  	
  </body>
</html>
