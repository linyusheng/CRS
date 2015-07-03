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
			url : '${pageContext.request.contextPath}/report/monthAnalysis',
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
		        title:'月份',
		        width:100
		    },{
		    	field:'saleAmount',
		        title:'销售额',
		        width:100
		    },{
		    	field:'discount',
		        title:'折扣',
		        width:100
		    },{
		    	field:'rewards',
		        title:'赠送',
		        width:100
		    },{
		    	field:'saleFinal',
		        title:'销售实收',
		        width:100
		    },{
		    	field:'passengerFolw',
		        title:'客流量',
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
  	<center><h1 style="height: 70px;line-height: 70px;">分店营业月对比表(按月份)</h1></center>
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
