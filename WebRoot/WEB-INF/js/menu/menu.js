function openAddDialog(){
	var row=$("#treeGrid").treegrid('getSelected');
	if(row==null){
		$.messager.alert('系统提示','请选择一个父菜单节点！');
		return;
	}
	$("#parent_id").val(row.id);
	$("#dlg").dialog("open").dialog("setTitle","添加菜单信息");
	url="menu/add";
}
function openEditDialog(){
	var row=$("#treeGrid").treegrid('getSelected');
	if(row==null){
		$.messager.alert('系统提示','请选择一个要编辑的菜单！');
		return;
	}
	$("#id").val(row.id);
	$("#dlg").dialog("open").dialog("setTitle","修改菜单信息");
	$("#fm").form("load",row);
	url="menu/edit";
}
function openDeleteDialog(){
	var row=$("#treeGrid").treegrid('getSelected');
	if(row==null){
		$.messager.alert('系统提示','请选择一个要删除的菜单！');
		return false;
	}
	$.messager.confirm('系统提示','您确定要删除该菜单吗？',function(r){
		if(r){
			$.messager.progress({title:'系统消息',msg:'数据处理中...'});
			$.post("menu/delete",{id:$.trim(row.id)},function(result){
				$.messager.progress('close');
				if(result.flag == true){
					$.messager.alert('系统提示',result.Msg,'info');
					$("#treeGrid").treegrid("reload");
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
				$("#treeGrid").treegrid("reload");
			}   
	    }    
	});   
	$('#fm').submit();  
}
function closeDialog(){
	$("#dlg").dialog("close");
	$("#fm").form('clear');
	$("#iconCls").val("icon-hamburg-old-versions");
}
function openMenuChooseDialog(){
	var row=$("#treeGrid").treegrid('getSelected');
	if(row==null){
		$.messager.alert('系统提示','请选择一个要修改的菜单！');
		return;
	}
	$("#menuid").val(row.id);
	$("#dlg1").dialog("open").dialog("setTitle","修改菜单["+row.name+"]所属的菜单层级");
	$("#treeGrid1").treegrid('collapseAll');
	url="menu/upparentid/";
}
function saveMenuChooseDialog(){
	var row=$("#treeGrid1").treegrid('getSelected');
	if(row==null){
		$.messager.alert('系统提示','必须选择一个菜单层级！');
		return;
	}
	$("#parentid").val(row.id);
	$('#fm1').form({    
	    url:url,   
	    success:function(result){    
			var result=eval('('+result+')');
			if(!result.flag){
				$.messager.alert('系统提示',"<font color=red>数据保存失败！</font>");
				return;
			}else{
				$.messager.alert('系统提示','菜单层级修改成功。');
				closeMenuChooseDialog();
				$("#treeGrid").treegrid("reload");
			}   
	    }    
	});   
	$('#fm1').submit();  
}
function closeMenuChooseDialog(){
	$("#dlg1").dialog("close");
	$("#fm1").form('clear');
	$("#iconCls").val("icon-hamburg-old-versions");
}