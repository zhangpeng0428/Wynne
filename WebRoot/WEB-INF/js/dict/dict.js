function openAddDialog(){
	$("#dlg").dialog("open").dialog("setTitle","添加数据字典信息");
	//$("#status").find("option[text='启用']").attr("selected",true);  
	url="dict/add";
}
function openEditDialog(){
	var rows=$("#dataGrid").datagrid('getSelections');
	if(rows.length!=1){
		$.messager.alert('系统提示','请选择一条要编辑的数据字典！');
		return;
	}
	var row=rows[0];
	$("#dlg").dialog("open").dialog("setTitle","修改数据字典信息");
	$("#fm").form("load",row);
	url="dict/edit";
}
function openDeleteDialog(){
	var row=$("#dataGrid").datagrid('getSelected');
	if(row==null){
		$.messager.alert('系统提示','请选择一条要删除的数据字典！');
		return false;
	}
	$.messager.confirm("系统提示","您确认要删除<font color=red>["+row.text+"]</font>这个字典吗？",function(r){
		if(r){
			$.messager.progress({title:'系统消息',msg:'数据处理中...'});
			$.post("dict/delete",{id:row.id},function(result){
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
function searchDict(){
	$("#dataGrid").datagrid({
		url:"dict/list/",
		method:'POST',
		loadMsg:'数据加载中请稍后……',  
		onBeforeLoad: function(param){
			param.text = $("#zdbmmc").val();
		}
	});
}

function openDetailDialog(){
	var row=$('#dataGrid').datagrid('getSelected'); 
	if(row==null){
		$.messager.alert('系统提示','请选择一行数据！');
		return false;
	}
	url="dict/detailList/"+row.id;
	$("#dataGrid1").datagrid({
		url:url,
		title:'为['+row.text+']分配选项'
	});
}

function openDetailAddDialog(){
	$("#dlg1").dialog("open").dialog("setTitle","添加数据字典选项信息");
	//获取数据字典大类的ID，通过url传递
	var row=$("#dataGrid").datagrid('getSelected');
	url1="dict/detailAdd/"+row.id;
}
function openDetailEditDialog(){
	var rows=$("#dataGrid1").datagrid('getSelections');
	if(rows.length!=1){
		$.messager.alert('系统提示','请选择一条要编辑的数据字典！');
		return;
	}
	var row=rows[0];
	$("#dlg1").dialog("open").dialog("setTitle","修改数据字典选项信息");
	$("#fm1").form("load",row);
	//获取数据字典大类的ID，通过url传递
	var row1=$("#dataGrid").datagrid('getSelected');
	url1="dict/detailEdit/"+row1.id;
}
function openDetailDeleteDialog(){
	var row=$("#dataGrid1").datagrid('getSelected');
	if(row==null){
		$.messager.alert('系统提示','请选择一条要删除的数据字典选项！');
		return false;
	}
	$.messager.confirm("系统提示","确认要删除<font color=red>["+row.text+"]</font>这个数据字典选项吗？",function(r){
		if(r){
			$.messager.progress({title:'系统消息',msg:'数据处理中...'});
			$.post("dict/detailDelete",{id:row.id},function(result){
				$.messager.progress('close');
				if(result.flag == true){
					$.messager.alert('系统提示',result.Msg,'info');
					$("#dataGrid1").datagrid("reload");
				}else{
					$.messager.alert('系统提示',result.Msg);
				}
			},"json");
		}
	});
}
function saveDetailDialog(){
	$('#fm1').form({    
	    url:url1,    
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
				closeDetailDialog();
				$("#dataGrid1").datagrid("reload");
			}   
	    }    
	});   
	$('#fm1').submit();  
}
function closeDetailDialog(){
	$("#dlg1").dialog("close");
	$("#fm1").form('clear');
}