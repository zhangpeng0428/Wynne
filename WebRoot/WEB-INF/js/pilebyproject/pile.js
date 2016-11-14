
function openDeleteDialog(){
	var row = $("#treeGrid").treegrid('getSelected');
	if(row.length==0){
		$.messager.alert('系统提示','请选择要删除的数据！');
		return false;
	}

	$.messager.confirm('系统提示', '您确定要删除该数据吗？', function(r) {
		if (r) {
			$.messager.progress({
				title : '系统消息',
				msg : '数据处理中...'
			});
			$.post("pilebyproject/delete", {
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


function openDeleteDialog(){
	var row = $("#treeGrid").treegrid('getSelected');
	if(row.length==0){
		$.messager.alert('系统提示','请选择要删除的数据！');
		return false;
	}

	$.messager.confirm('系统提示', '您确定要删除该数据吗？', function(r) {
		if (r) {
			$.messager.progress({
				title : '系统消息',
				msg : '数据处理中...'
			});
			$.post("pilebyproject/delete", {
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

//Ajax 文件下载
jQuery.download = function(url, data, method){    // 获得url和data
if( url && data ){ 
    // data 是 string 或者 array/object
    data = typeof data == 'string' ? data : jQuery.param(data);        // 把参数组装成 form的  input
    var inputs = '';
    jQuery.each(data.split('&'), function(){ 
        
        inputs+='<input  id="'+ data +'" />'; 
    });        // request发送请求
    jQuery('<form action="'+ url +'" method="'+ 'post' +'">'+inputs+'</form>')
    .appendTo('body').submit().remove();
};
};


jQuery.downloads = function (options) {
    var config = $.extend(true, { method: 'post' }, options);
    var $iframe = $('<iframe id="down-file-iframe" />');
    var $form = $('<form target="down-file-iframe" method="' + config.method + '" />');
    $form.attr('action', config.url);
    for (var key in config.data) {
        $form.append('<input type="hidden" name="' + key + '" value="' + config.data[key] + '" />');
    }
    $iframe.append($form);
    $(document.body).append($iframe);
    $form[0].submit();
    $iframe.remove();
}

function openDownloadDialog(){
	var row = $("#treeGrid").treegrid('getSelected');
	if(row.length==0){
		$.messager.alert('系统提示','请选择要下载的数据！');
		return false;
	}
	
	/*$.post("pile/download", {
		id : $.trim(row.id)
	});*/
	//$.download('pile/download',$.trim(row.id),'post' );
	
	$.downloads({

		url:'pilebyproject/download', //请求的url

		data:{id:$.trim(row.id)}//要发送的数据
	   

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
				
				$("#treeGrid").datagrid("reload");
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


function openEditDialog(){
	var rows=$("#treeGrid").treegrid('getSelections');
	if(rows.length!=1){
		$.messager.alert('系统提示','请选择一个要分类的工程！');
		return;
	}
	var row=rows[0];
	//$("#id").val(row.id);  
	//$("#dept_id").val(row.dept_id);
	$("#dlg").dialog("open").dialog("setTitle","修改工程分类");
	$("#fm").form("load",row);
	url="pilebyproject/edit";
}



