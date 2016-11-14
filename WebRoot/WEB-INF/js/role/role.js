function openAddDialog(){
	$("#dlg").dialog("open").dialog("setTitle","添加角色信息");
	//$("#status").find("option[text='启用']").attr("selected",true);  
	url="role/add";
}
function openEditDialog(){
	var row=$("#dataGrid").datagrid('getSelected');
	if(row==null){
		$.messager.alert('系统提示','请选择一个要编辑的角色！');
		return;
	}
	$("#dlg").dialog("open").dialog("setTitle","修改角色信息");
	$("#fm").form("load",row);
	url="role/edit";
}
function openDeleteDialog(){
	var row=$("#dataGrid").datagrid('getSelected');
	if(row==null){
		$.messager.alert('系统提示','请选择要删除的角色！');
		return false;
	}
	$.messager.confirm("系统提示","您确认要删除<font color=red>["+row.name+"]</font>这个角色吗？",function(r){
		if(r){
			$.messager.progress({title:'系统消息',msg:'数据处理中...'});
			$.post("role/delete",{id:row.id},function(result){
				$.messager.progress('close');
				if(result.flag == true){
					$.messager.alert('系统提示',result.Msg,'info');
					$("#dataGrid").datagrid("reload");
				}else{
					$.messager.alert('系统提示',result.Msg);
				}
			},"json");
		}
	});
}
function saveDialog(){
	$('#fm').form({    
	    url:url,    
	    onSubmit: function(){    
	    	//return $(this).form("validate");    
	    },    
	    success:function(result){    
			var result=eval('('+result+')');
			if(!result.flag){
				$.messager.alert('系统提示',"<font color=red>数据保存失败！</font>");
				return;
			}else{
				$.messager.alert('系统提示','数据保存成功。');
				closeDialog();
				$("#dataGrid").datagrid("reload");
			}   
	    }    
	});   
	$('#fm').submit();  
}
function closeDialog(){
	$("#dlg").dialog("close");
	$("#fm").form('clear');
}
function openMenuChooseDialog(){
	var row=$("#dataGrid").datagrid('getSelected');
	if(row==null){
		$.messager.alert('系统提示','请选择一个要分配的角色！');
		return false;
	}
	$("#dlg1").dialog("open").dialog("setTitle","为角色["+row.name+"]分配菜单");
	url="menu/tree/"+row.id;
	$("#tree").tree({
		lines:true,
		url:url,
		checkbox:true,
		cascadeCheck:true,//定义是否层叠选中状态。
		onLoadSuccess:function(){
			$("#tree").tree('expandAll');
		}
	});
}

function openPowerChooseDialog(){
	var row=$("#dataGrid").datagrid('getSelected');
	if(row==null){
		$.messager.alert('系统提示','请选择一个要分配的角色！');
		return false;
	}
	$("#dlg5").dialog("open").dialog("setTitle","为角色["+row.name+"]分配权限");
	url="power/tree/"+row.id;
	$("#tree1").tree({
		lines:true,
		url:url,
		checkbox:true,
		cascadeCheck:true,//定义是否层叠选中状态。
		onLoadSuccess:function(){
			$("#tree1").tree('expandAll');
		}
	});
}


function ChoosePower(){
	var row=$("#dataGrid").datagrid('getSelected');//获取角色
	var nodes=$('#tree1').tree("getChecked"); //获取选择到的菜单行数据
	var strIds=[];
	for(var i=0;i<nodes.length;i++){
		strIds.push(nodes[i].id);
	}
	var ids = strIds.join(",");
	$.messager.progress({title:'系统消息',msg:'数据处理中...'});
	$.post("role/powerAssign",{roleId:row.id,powerIds:ids},function(result){
		$.messager.progress('close');
		if(result.flag==true){
			$.messager.alert('系统提示',result.Msg,'info');
			$("#dataGrid").datagrid("reload");
		}else{
			$.messager.alert('系统提示',result.Msg);
		}
		closePowerChooseDialog();
	},"json");
	
}
function closePowerChooseDialog(){
	$("#dlg5").dialog("close");
}
function ChooseMenu(){
	var row=$("#dataGrid").datagrid('getSelected');//获取角色
	var nodes=$('#tree').tree("getChecked"); //获取选择到的菜单行数据
	var strIds=[];
	for(var i=0;i<nodes.length;i++){
		strIds.push(nodes[i].id);
	}
	var ids = strIds.join(",");
	$.messager.progress({title:'系统消息',msg:'数据处理中...'});
	$.post("role/menuAssign",{roleId:row.id,menuIds:ids},function(result){
		$.messager.progress('close');
		if(result.flag==true){
			$.messager.alert('系统提示',result.Msg,'info');
			$("#dataGrid").datagrid("reload");
		}else{
			$.messager.alert('系统提示',result.Msg);
		}
		closeMenuChooseDialog();
	},"json");
	
}
function closeMenuChooseDialog(){
	$("#dlg1").dialog("close");
}
function openUserChooseDialog(){
	var row=$("#dataGrid").datagrid('getSelected');
	if(row==null){
		$.messager.alert('系统提示','请选择一个要分配的角色！');
		return false;
	}
	$("#dlg2").dialog("open").dialog("setTitle","为角色["+row.name+"]分配用户");
	$("#dataGrid2").datagrid({
		url:'role/listUser/'+row.id, 
	    method:'get',
	    fit:true,
	    fitColumns:true,
	    rownumbers:false,
	    remoteSort:false, //本地排序
	    //sortName:'name', //默认排序的字段
	    //sortOrder:'asc', //默认的排序规则 ‘asc’、‘desc’
	    columns:[[ 
			 {field:'id',title:'编号',width:40,align:'right',sortable:true},
	   		 {field:'cb', checkbox:true,width:20,align:'center'},    
	         {field:'username',title:'登陆账号',width:80,sortable:true},    
	         {field:'nickname',title:'用户名',width:80,sortable:true},  
	         {field:'dept_name',title:'所在部门',width:300,sortable:true}
	    ]],
	    singleSelect: false,
	    checkOnSelect: true,
	    selectOnCheck: true,
	    onLoadSuccess:function(data){
	    	if(data){
	    		$.each(data.rows,function(index,row){
	    			if(row.checked){
	    				$("#dataGrid2").datagrid('checkRow',index);
	    			}
	    		})
	    	}
	    }
	});
}
function ChooseUser(){
	var row=$("#dataGrid").datagrid('getSelected');//获取角色
	//var rows=$('#dataGrid2').datagrid("getSelections"); //获取选择到的用户数据行
	var rows=$('#dataGrid2').datagrid("getChecked"); //获取选择到的用户数据行
	if(rows.length==0){
		$.messager.alert('系统提示','请选择一个要分配的角色！');
		return false;
	}
	var strIds=[];
	$.each(rows, function(index, item){
		strIds.push(item.id);
	})
	var ids = strIds.join(",");
	$.messager.progress({title:'系统消息',msg:'数据处理中...'});
	$.post("role/userAssign",{roleId:row.id,userIds:ids},function(result){
		$.messager.progress('close');
		if(result.flag==true){
			$.messager.alert('系统提示',result.Msg,'info');
			//$("#dataGrid").datagrid("reload"); 没有更新角色表，不需要重载数据了
		}else{
			$.messager.alert('系统提示',result.Msg);
		}
		closeUserChooseDialog();
	},"json");
	
}
function closeUserChooseDialog(){
	$("#dlg2").dialog("close");
}


function refreshPowerDialog(){
	
	$('#dataGrid').datagrid({
		toolbar: '#tb'
			
	});
	$('#dataGrid').hide();
	/*$('#dataGrid').datagrid({  	
		  toolbar:[{
		    	text:'添加',
		    	iconCls:'icon-add',
		    	handler:function(){openAddDialog()}
		    },'-',{
		    	text:'修改',
		    	iconCls:'icon-edit',
		    	handler:function(){openEditDialog()}
		    },'-',{
		    	text:'删除',
		    	iconCls:'icon-remove',
		    	handler:function(){openDeleteDialog()}
		    },'-',{
		    	text:'为角色分配菜单',
		    	iconCls:'icon-advancedsettings',
		    	handler:function(){openMenuChooseDialog()}
		    },'-',{
		    	text:'为角色分配用户',
		    	iconCls:'icon-advancedsettings',
		    	handler:function(){openUserChooseDialog()}
		    },'-',{
		    	text:'为角色分配权限',
		    	iconCls:'icon-advancedsettings',
		    	handler:function(){openPowerChooseDialog()}
		    }] 
		    <div id="tb">
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-edit',plain:true"></a> 
			
			<a href="#"
			class="easyui-linkbutton"
			data-options="iconCls:'icon-help',plain:true"></a>
	</div> 
	
	});*/
}

