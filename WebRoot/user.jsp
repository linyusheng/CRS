<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title></title>
    <jsp:include page="include.jsp"></jsp:include>
	
    <script type="text/javascript" charset="utf-8">
	var datagrid;
	var editRow = undefined;
	$(function() {
		datagrid = $("#datagrid").datagrid({
			url : '${pageContext.request.contextPath}/user/datagrid',
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
			idField : 'userId',
			sortName : 'createTime',//定义哪些列可以进行排序
			sortOrder : 'desc',		//定义列的排序顺序，只能是'asc'或'desc'
			columns : [ [ {
				title : '序号',
				field : 'userId',
				width : 100,
				sortable : true,
				checkbox : true
			}, {
				title : '帐号',
				field : 'account',
				sortable : true,
				width : 100,
				editor : {
					type : 'validatebox',
					options : {
						required : true
					}
				}
			}, {
				title : '密码',
				field : 'password',
				sortable : true,
				width : 100,
				editor : {
					type : 'validatebox',
					options : {
						required : true
					}
				}
			}, {
				title : '角色名称',
				field : 'roleName',
				width : 120,
				editor : {
					type : 'validatebox',
					options : {
						required : true
					}
				}
			}, {
				title : '用户姓名',
				field : 'userName',
				sortable : true,
				width : 120,
				editor : {
					type : 'validatebox',
					options : {
						required : true
					}
				},
				formatter: function(value,rowData,rowIndex){
					return '<span title="'+value+'">'+value+'</span>';
				}
			}, {
				title : '性别',
				field : 'sex',
				sortable : true,
				width : 100,
				editor : {
					type : 'validatebox',
					options : {
						required : true
					}
				}
			}, {
				title : '电话',
				field : 'tel',
				width : 116,
				editor : {
					type : 'validatebox',
					options : {
						required : true
					}
				}
			}, {
				title : '创建时间',
				field : 'createTime',
				sortable : true,
				width : 130,
				editor : {
					type : 'datetimebox',
					options : {
						required : true
					}
				}
			} ] ],
			toolbar : [
					{
						text : '增加',
						iconCls : 'icon-add',
						handler : function() {
							if (editRow != undefined) {
								datagrid.datagrid('endEdit', editRow);
							}
							if (editRow == undefined) {
								//可以行编辑
								datagrid.datagrid('addEditor',{
									field:'userName',
									editor:{
										type : 'validatebox',
										options : {
											required : true
										}
									} 
								});
								//插入一行数据
								datagrid.datagrid('insertRow', {
									index : 0,
									row : {
										//userId : Math.uuid()
									}
								});
								//创建时间无法编辑								
								datagrid.datagrid('removeEditor','createTime');
								datagrid.datagrid('beginEdit', 0);
								editRow = 0;
							}
						}
					},
					'-',
					{
						text : '删除',
						iconCls : 'icon-remove',
						handler : function() {
							var rows = datagrid.datagrid('getSelections');
							if(rows.length > 0){
								$.messager.confirm('请确认','您确定要删除当前所有选择的项目么？',function(b){
									if(b){
										var ids = [];
										for(var i = 0;i<rows.length;i++){
											ids.push(rows[i].userId);
										}
										$.post('${pageContext.request.contextPath}/user/delete',{"ids":ids.toString()} , function(result) {
											//若后台删除用户成功，则清除选中的行
											datagrid.datagrid('clearSelections');
											datagrid.datagrid('load');
										}, "JSON");
									}
								});
							}else{
								$.messager.alert('提示','请选择要删除的记录！','error');
							}
						}
					},
					'-',
					{
						text : '修改',
						iconCls : 'icon-edit',
						handler : function() {
							var rows = datagrid.datagrid('getSelections');
							if (rows.length == 1) {
								datagrid.datagrid('removeEditor','userName');
								if (editRow != undefined) {
									datagrid.datagrid('endEdit',editRow);
								}
								if (editRow == undefined) {
									var index = datagrid.datagrid('getRowIndex', rows[0]);
									datagrid.datagrid('beginEdit',index);
									editRow = index;
									datagrid.datagrid('unselectAll');
								}
							}
						}
					}, '-', {
						text : '保存',
						iconCls : 'icon-save',
						handler : function() {
							datagrid.datagrid('endEdit', editRow);
						}
					}, '-', {
						text : '取消编辑',
						iconCls : 'icon-redo',
						handler : function() {
							editRow = undefined;
							datagrid.datagrid('rejectChanges');
							datagrid.datagrid('unselectAll');
						}
					} ],
			onAfterEdit : function(rowIndex, rowData, changes) {
				editRow = undefined;
				parent.$.messager.progress({
					text : '数据加载中....'
				});
				console.info(rowData);
				//添加或修改用户的请求
				$.post('${pageContext.request.contextPath}/user/addOrUpdate',rowData , function(result) {
					parent.$.messager.progress('close');
					datagrid.datagrid('load');
					editRow = undefined;
					$.messager.alert('提示',result.msg,'info');
				}, "JSON");
			},
			onDblClickRow : function(rowIndex, rowData) {
				if (editRow != undefined) {
					datagrid.datagrid('endEdit', editRow);
				}
				if (editRow == undefined) {
					datagrid.datagrid('beginEdit', rowIndex);
					editRow = rowIndex;
				}
			},
			onRowContextMenu:function(e, rowIndex, rowData){
				e.preventDefault();
				$(this).datagrid('unselectAll');
				$(this).datagrid('selectRow',rowIndex);
				$('#menu').menu('show', {    
					left: e.pageX,
					top: e.pageY   
				});  
			},
			onBeforeLoad : function(param) {
				parent.$.messager.progress({
					text : '数据加载中....'
				});
			},
			onLoadSuccess : function(data) {
				parent.$.messager.progress('close');
			}
		});	
	});
	</script>
  </head>
  <body>
  	<center><h1 style="height: 70px;line-height: 70px;">用户管理</h1></center>
	<a href="${pageContext.request.contextPath}/index.jsp" style=" position: absolute;right: 30px;top: 20px; border:1px solid #666;padding:5px;text-decoration: none;">
         	<span class="first-name">返回首页&nbsp;<span class="icon-arrow-right"></span></span>
    </a>
	
	<div style="width:823px;margin:0 auto;">
		<div style="margin-top:15px;height: 500px;border:1px solid #D4D4D4;"><table id="datagrid"></table></div>
	</div>
  </body>
</html>
