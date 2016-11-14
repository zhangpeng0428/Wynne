function openAddDialog() {
	var row = $("#treeGrid").treegrid('getSelected');
	if (row == null) {
		$.messager.alert('系统提示', '请选择一个父菜单节点！');
		return;
	}
	$("#parent_id").val(row.id);
	$("#dlg").dialog("open").dialog("setTitle", "添加部门信息");
	url = "dept/add";
}
function openEditDialog() {
	var row = $("#treeGrid").treegrid('getSelected');
	if (row == null) {
		$.messager.alert('系统提示', '请选择一个要编辑的部门！');
		return;
	}
	$("#id").val(row.id);
	$("#dlg").dialog("open").dialog("setTitle", "修改部门信息");
	$("#fm").form("load", row);
	url = "dept/edit";
}
// 加锁
function openLockDialog() {
	var row = $("#treeGrid").treegrid('getSelected');
	if (row == null) {
		$.messager.alert('系统提示', '请选择一个要锁定的部门！');
		return false;
	}
	
	$.messager.confirm('系统提示', '您确定要锁定该部门吗？', function(r) {
		if (r) {
			$.messager.progress({
				title : '系统消息',
				msg : '数据处理中...'
			});
			$.post("dept/lock", {
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
// 解锁
function openUnLockDialog() {
	var row = $("#treeGrid").treegrid('getSelected');
	if (row == null) {
		$.messager.alert('系统提示', '请选择一个要解锁的部门！');
		return false;
	}
	
	$.messager.confirm('系统提示', '您确定要解锁该部门吗？', function(r) {
		if (r) {
			$.messager.progress({
				title : '系统消息',
				msg : '数据处理中...'
			});
			$.post("dept/unLock", {
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

function openDeleteDialog() {
	var row = $("#treeGrid").treegrid('getSelected');
	if (row == null) {
		$.messager.alert('系统提示', '请选择一个要删除的部门！');
		return false;
	}
	$.messager.confirm('系统提示', '您确定要删除该部门吗？', function(r) {
		if (r) {
			$.messager.progress({
				title : '系统消息',
				msg : '数据处理中...'
			});
			$.post("dept/delete", {
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

function saveDialog() {
	$('#fm').form({
		url : url,
		onSubmit : function() {
			// return $(this).form("validate");
		},
		success : function(result) {
			var result = eval('(' + result + ')');
			if (!result.flag) {
				$.messager.alert('系统提示', result.Msg);
				return;
			} else {
				$.messager.alert('系统提示', result.Msg);
				closeDialog();
				$("#treeGrid").treegrid("reload");
			}
		}
	});
	$('#fm').submit();
}
function closeDialog() {
	$("#dlg").dialog("close");
	$("#fm").form('clear');
	$("#iconCls").val("icon-item");
}
function openDeptChooseDialog() {
	var row = $("#treeGrid").treegrid('getSelected');
	if (row == null) {
		$.messager.alert('系统提示', '请选择一个要修改的部门！');
		return;
	}
	$("#deptid").val(row.id);
	$("#dlg1").dialog("open").dialog("setTitle",
			"修改部门[" + row.name + "]所属的部门层级");
	$("#treeGrid1").treegrid('collapseAll');
	url = "dept/upparentid/";
}
function saveDeptChooseDialog() {
	var row = $("#treeGrid1").treegrid('getSelected');
	if (row == null) {
		$.messager.alert('系统提示', '必须选择一个部门层级！');
		return;
	}
	$("#parentid").val(row.id);
	$('#fm1').form({
		url : url,
		success : function(result) {
			var result = eval('(' + result + ')');
			if (!result.flag) {
				$.messager.alert('系统提示', "<font color=red>数据保存失败！</font>");
				return;
			} else {
				$.messager.alert('系统提示', '部门层级修改成功。');
				closeDeptChooseDialog();
				$("#treeGrid").treegrid("reload");
			}
		}
	});
	$('#fm1').submit();
}
function closeDeptChooseDialog() {
	$("#dlg1").dialog("close");
	$("#fm1").form('clear');
	$("#iconCls").val("icon-item");
}