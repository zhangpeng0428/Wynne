function openAddDialog(){
	$("#dlg").dialog("open").dialog("setTitle","添加工程信息");
	//$("#status").find("option[text='启用']").attr("selected",true);  
	url="project/add";
}
function openEditDialog(){
	var rows=$("#treeGrid").treegrid('getSelections');
	if(rows.length!=1){
		$.messager.alert('系统提示','请选择一个要编辑的工程！');
		return;
	}
	var row=rows[0];
	//$("#id").val(row.id);  
	//$("#dept_id").val(row.dept_id);
	$("#dlg").dialog("open").dialog("setTitle","修改工程信息");
	$("#fm").form("load",row);
	url="project/edit";
}
function openDeleteDialog(){
	var row = $("#treeGrid").treegrid('getSelected');
	if(row.length==0){
		$.messager.alert('系统提示','请选择要删除的工程！');
		return false;
	}

	$.messager.confirm('系统提示', '您确定要删除该工程吗？', function(r) {
		if (r) {
			$.messager.progress({
				title : '系统消息',
				msg : '数据处理中...'
			});
			$.post("project/delete", {
				id : $.trim(row.id)
			}, function(result) {
				$.messager.progress('close');
				if (result.flag == true) {
					$.messager.alert('系统提示', result.Msg, 'info');
					$("#treeGrid").treegrid("reload");
				} else {
					$.messager.alert('系统提示', result.Msg);
				}
			}, "json");
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
				$.messager.alert('系统提示',result.Msg);
				return;
			}else{
				$.messager.alert('系统提示',result.Msg);
				$("#treeGrid").treegrid("reload");
				closeDialog();
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
	$("#dlg1").dialog("open").dialog("setTitle","选择设备["+$("#nickname").val()+"]所在的部门");
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

