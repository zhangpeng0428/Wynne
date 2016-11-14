//获取日期 2015-09-19
function getDate(date){
            var y = date.getFullYear();
            var m = date.getMonth()+1;
            var d = date.getDate();
            return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
        } 
//页面加载  
$(function(){  
	var curr_time = new Date();   
	$("#date_q").datebox("setValue",getDate(curr_time));
	$("#date_z").datebox("setValue",getDate(curr_time));
}); 

function searchLog(){
	$("#dataGrid").datagrid({
		url:"log/list" ,
		method: 'POST',
		loadMsg:'数据加载中请稍后……',  
		onBeforeLoad: function (param) {
			param.username = $("#username").val();
			param.nickname = $("#nickname").val();
			param.request_name = $.trim($("#request_name").val());
			param.date_q = $.trim($("#date_q").datebox('getValue'));
			param.date_z = $.trim($("#date_z").datebox('getValue'));
        }
	});
}
