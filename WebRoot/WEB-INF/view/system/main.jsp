<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%--公用页面 --%>
<%@ include file="/common/headhome.jsp"%>
</head>
<body class="easyui-layout">
    <!-- 头部 -->
   <div class="wu-header" data-options="region:'north',border:false,split:true">
   	   	<div class="wu-header-left">
       		<h1>铭创管理系统</h1>
       	</div>
      	<div class="wu-header-right">
       		<p><strong class="easyui-tooltip" >${CurrentUser.nickname}</strong>，欢迎您！</p>
         	<p><a href="#">网站首页</a>|
         	<a href="#" onclick="openPasswordDialog();">修改密码</a>|
         	<a href="#" onclick="loginout();">安全退出</a></p>
       	</div>
    </div>
   <!-- 头部  结束 -->
   <!-- 左侧导航 -->
   <div data-options="region:'west',split:true,iconCls:'icon-house',title:'导航菜单'" style="width:200px;padding:0px;">
		<div class="easyui-accordion" data-options="fit:true,border:false">
			<c:forEach items="${parentListMenu}" var="item">
				<div title="${item.name}" data-options="iconCls:'${item.iconCls}'" style="padding:5px;">
					<ul class="easyui-tree wu-side-tree" data-options="url:'../system/tree/${item.id}'">
					</ul>
				</div>
			</c:forEach>
		</div>
	</div>
	<!-- 左侧导航  结束 -->
	<!--中部-->
    <div class="wu-main" data-options="region:'center'">
        <div id="wu-tabs" class="easyui-tabs" data-options="border:false,fit:true">  
            <div title="首页" style="margin-left:10px;">
				<div class="cs-首页-remark">
					<h1>铭创管理系统</h1> <br>
					欢迎使用铭创管理系统
				</div>
			</div>
        </div>
    </div>
	<!--中部  结束-->
	<!--尾部-->
	<div class="wu-footer" data-options="region:'south',border:true,split:true">
    	&copy;  All Rights Reserved
    </div>
	<!--尾部  结束-->
	<!--右键菜单  -->
	<div id="mm" class="easyui-menu cs-tab-menu">
		<div id="mm-tabupdate">刷新</div>
		<div class="menu-sep"></div>
		<div id="mm-tabclose">关闭当前窗口</div>
		<div id="mm-tabcloseother">关闭其他窗口</div>
		<div id="mm-tabcloseall">关闭全部窗口</div>
		<div id="mm-exit">退出</div>
	</div>
	<!--右键菜单  结束-->
	<!--密码修改对话框  -->
	<div id="dlg" class="easyui-dialog" title="密码修改对话框"
	style="width: 420px;height: 220px;padding: 10px 20px" 
	buttons="#dlg-buttons" data-options="iconCls:'icon-cologne-lock',closed:true">
	 <form id="fm" method="post">
	 	<table cellspacing="4px;">
	 		<tr>
	 			<td>用户名：</td>
	 			<td>
	 			<input type="hidden" name="id" id="id" value="${CurrentUser.id}">
	 			<input type="text" name="nickname" id="nickname" readonly="readonly" value="${CurrentUser.nickname}" style="width: 200px;" /></td>
	 		</tr>
	 		<tr>
	 			<td>原密码：</td>
	 			<td><input type="password" class="easyui-validatebox" name="oldPassword" id="oldPassword" style="width: 200px;" required="true" /></td>
	 		</tr>
	 		<tr>
	 			<td>新密码：</td>
	 			<td><input type="password" class="easyui-validatebox" name="newPassword" id="newPassword" style="width: 200px;" required="true"  /></td>
	 		</tr>
	 		<tr>
	 			<td>确认新密码：</td>
	 			<td><input type="password" class="easyui-validatebox" name="newPassword2" id="newPassword2" style="width: 200px;" required="true" /></td>
	 		</tr>
	 	</table>
	 </form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:modifyPassword()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
	</div>
	<!--密码修改对话框  结束-->
<script type="text/javascript">
function openPasswordDialog(){
	$("#dlg").dialog("open").dialog("setTitle","密码修改对话框");
}
function loginout(){
	$.messager.confirm('系统提示','您确定要退出系统吗？',function(r){
	if(r){
		window.location.href="loginout";
	}
	})
}
function modifyPassword(){
	$('#fm').form('submit',{
	url:'pwdUp',
	onSubmit:function(){
		var oldPassword=$("#oldPassword").val();
		var newPassword=$("#newPassword").val();
		var newPassword2=$("#newPassword2").val();
		if(newPassword!=newPassword2){
			$.messager.alert('系统提示','新密码输入错误！');
			return false;
		}
		return true;
	},
	success:function(result){
		var result=eval('('+result+')');
		if(result.flag){
			$.messager.alert('系统提示','密码修改成功，下一次登录生效！');
			closePasswordModifyDialog();
		}else{
			$.messager.alert('系统提示',result.errorMsg);
			return;
		}
	}
	});
}

function closePasswordModifyDialog(){
	$("#oldPassword").val("");
	$("#newPassword").val("");
	$("#newPassword2").val("");
	//$('#fm').form('clear');
	$("#dlg").dialog("close");
	//var tab = $('#tabs').tabs('getSelected');
	//var index = $('#tabs').tabs('getTabIndex',tab);
	//$('#tabs').tabs('close',index);
}
</script>
</body>
</html>