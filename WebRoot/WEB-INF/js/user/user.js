function openAddDialog(){
	$("#dlg").dialog("open").dialog("setTitle","添加用户信息");
	//$("#status").find("option[text='启用']").attr("selected",true);  
	url="user/add";
}
function openEditDialog(){
	var rows=$("#dataGrid").datagrid('getSelections');
	if(rows.length!=1){
		$.messager.alert('系统提示','请选择一个要编辑的用户！');
		return;
	}
	var row=rows[0];
	//$("#id").val(row.id);  
	//$("#dept_id").val(row.dept_id);
	$("#dlg").dialog("open").dialog("setTitle","修改用户信息");
	$("#fm").form("load",row);
	url="user/edit";
}
function openDeleteDialog(){
	var rows=$("#dataGrid").datagrid('getSelections');
	if(rows.length==0){
		$.messager.alert('系统提示','请选择要删除的用户！');
		return false;
	}
	var strIds=[];
	for(var i=0;i<rows.length;i++){
		strIds.push(rows[i].id);
	}
	var ids = strIds.join(",");
	$.messager.confirm("系统提示","您确认要删除这<font color=red>"+rows.length+"</font>个用户吗？",function(r){
		if(r){
			$.messager.progress({title:'系统消息',msg:'数据处理中...'});
			$.post("user/delete",{delIds:ids},function(result){
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
function resetPassword(){
	var rows=$("#dataGrid").datagrid('getSelections');
	if(rows.length!=1){
		$.messager.alert('系统提示','请选择一个要重置密码的用户');
		return;
	}
	var row=rows[0];
	$.messager.confirm('系统消息', '确定要将用户['+row.nickname+']的密码重置吗？', function(r) {
		if(r)
		{
			$.messager.progress({title:'系统消息',msg:'数据处理中...'});
			$.post("user/resetpassword",{id:row.id},function(result){
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



function lock(){
	var rows=$("#dataGrid").datagrid('getSelections');
	if(rows.length!=1){
		$.messager.alert('系统提示','请选择一个要锁定的用户！');
		return;
	}
	var row=rows[0];
	$.messager.confirm('系统消息', '确定要将用户['+row.nickname+']的锁定吗？', function(r) {
		if(r)
		{
			$.messager.progress({title:'系统消息',msg:'数据处理中...'});
			$.post("user/lock",{id:row.id},function(result){
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



function unLock(){
	var rows=$("#dataGrid").datagrid('getSelections');
	if(rows.length!=1){
		$.messager.alert('系统提示','请选择一个要解锁的用户！');
		return;
	}
	var row=rows[0];
	$.messager.confirm('系统消息', '确定要将用户['+row.nickname+']解锁吗？', function(r) {
		if(r)
		{
			$.messager.progress({title:'系统消息',msg:'数据处理中...'});
			$.post("user/unLock",{id:row.id},function(result){
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
function openDeptChooseDialog(){
	$("#dlg1").dialog("open").dialog("setTitle","选择用户["+$("#nickname").val()+"]所在的部门");
	$("#treeGrid1").treegrid('collapseAll');
}
function ChooseDept(){
	var row=$("#treeGrid1").treegrid('getSelected');
	if(row==null){
		$.messager.alert('系统提示','必须选择一个部门！');
		return;
	}
	$("#dept_id").val(row.id);
	$("#dept_name").val(row.name);
	closeDeptChooseDialog();
}
function closeDeptChooseDialog(){
	$("#dlg1").dialog("close");
}
function openRoleChooseDialog(){
	var row=$("#dataGrid").datagrid('getSelected');
	if(row==null){
		$.messager.alert('系统提示','请选择一个要分配的用户！');
		return false;
	}
	$("#dlg2").dialog("open").dialog("setTitle","为用户["+row.nickname+"]分配角色");
	$("#dataGrid2").datagrid({
		url:'user/listRole/'+row.id,
		method:'get',
		fit:true,
		fitColumns:true,
		rownumbers:false,
		remoteSort:false,
		//sortName:'name', //默认排序的字段
	    //sortOrder:'asc', //默认的排序规则 ‘asc’、‘desc’
		columns:[[
		     {field:'id',title:'编号',width:40,align:'right',sortable:true},
		     {field:'cb',checkbox:true,width:20,align:'center'},
		     {field:'name',title:'角色名称',width:100,sortable:true},
		     {field:'description',title:'角色描述',width:200,sortable:true},
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
function ChooseRole(){
	var row=$("#dataGrid").datagrid('getSelected');
	var rows=$("#dataGrid2").datagrid('getChecked');
	if(rows.length==0){
		$.messager.alert('系统提示','请选择一个要分配的角色!');
		return false;
	}
	var strIds=[];
	$.each(rows, function(index,item){
		strIds.push(item.id);
	})
	var ids = strIds.join(",");
	$.messager.progress({title:'系统消息',msg:'数据处理中...'});
	$.post("user/roleAssign",{userId:row.id,roleIds:ids},function(result){
		$.messager.progress('close');
		if(result.flag==true){
			$.messager.alert('系统提示',result.Msg,'info');
		}else{
			$.messager.alert('系统提示',result.Msg);
		}
		closeRoleChooseDialog();
	},"json");
}
function closeRoleChooseDialog(){
	$("#dlg2").dialog("close");
}
function searchUser(){
	$("#dataGrid").datagrid({
		url:"user/list/"+$("#usernames").val(),
		method:'get'
	});
}