$(function(){
	tabCloseEven();
	$('.easyui-tree').bind("click",function(){
		var $this = $(this);
		var row  = $this.tree('getSelected');
		var title = row.text;
		var href = '..'+row.url;
		var iconCls = row.iconCls;
		var iframe = true;
		addTab(title,href,iconCls,iframe);
	});	
})

/**
* Name 绑定右键菜单事件 
*/
function tabCloseEven() {
	//刷新
	$('#mm-tabupdate').click(function(){
		var currTab = $('#wu-tabs').tabs('getSelected');
		var url = $(currTab.panel('options').content).attr('src');
		if(url != undefined && currTab.panel('options').title != '首页') {
			$('#wu-tabs').tabs('update',{
				tab:currTab,
				options:{
					content:'<iframe scrolling="auto" frameborder="0"  src="'+ url +'" style="width:100%;height:100%;"></iframe>'
				}
			})
		}
	})
	//关闭当前
	$('#mm-tabclose').click(function(){
		var currtab_title = $('#mm').data("currtab");
		$('#wu-tabs').tabs('close',currtab_title);
	})
	//全部关闭
	$('#mm-tabcloseall').click(function(){
		$('.tabs-inner span').each(function(i,n){
			var t = $(n).text();
			if(t != '首页') {
				$('#wu-tabs').tabs('close',t);
			}
		});
	});
	//关闭除当前之外的TAB
	$('#mm-tabcloseother').click(function(){
		var prevall = $('.tabs-selected').prevAll();
		var nextall = $('.tabs-selected').nextAll();		
		if(prevall.length>0){
			prevall.each(function(i,n){
				var t=$('a:eq(0) span',$(n)).text();
				if(t != '首页') {
					$('#wu-tabs').tabs('close',t);
				}
			});
		}
		if(nextall.length>0) {
			nextall.each(function(i,n){
				var t=$('a:eq(0) span',$(n)).text();
				if(t != '首页') {
					$('#wu-tabs').tabs('close',t);
				}
			});
		}
		return false;
	});
	//关闭当前右侧的TAB
	$('#mm-tabcloseright').click(function(){
		var nextall = $('.tabs-selected').nextAll();
		if(nextall.length==0){
			//msgShow('系统提示','后边没有啦~~','error');
			alert('后边没有啦~~');
			return false;
		}
		nextall.each(function(i,n){
			var t=$('a:eq(0) span',$(n)).text();
			$('#wu-tabs').tabs('close',t);
		});
		return false;
	});
	//关闭当前左侧的TAB
	$('#mm-tabcloseleft').click(function(){
		var prevall = $('.tabs-selected').prevAll();
		if(prevall.length==0){
			alert('到头了，前边没有啦~~');
			return false;
		}
		prevall.each(function(i,n){
			var t=$('a:eq(0) span',$(n)).text();
			$('#wu-tabs').tabs('close',t);
		});
		return false;
	});

	//退出
	$("#mm-exit").click(function(){
		$('#mm').menu('hide');
	})
}
/**
* Name 载入树形菜单 
*/
$('#wu-side-tree').tree({
	url:'temp/menu.php',
	cache:false,
	onClick:function(node){
		var url = node.attributes['url'];
		if(url==null || url == ""){
			return false;
		}
		else{
			addTab(node.text, url, '', node.attributes['iframe']);
		}
	}
});

/**
* Name 选项卡初始化
*/
$('#wu-tabs').tabs({
	tools:[{
		iconCls:'icon-reload',
		border:false,
		handler:function(){
			$('#wu-datagrid').datagrid('reload');
		}
	}]
});
	
/**
* Name 添加菜单选项
* Param title 名称
* Param href 链接
* Param iconCls 图标样式
* Param iframe 链接跳转方式（true为iframe，false为href）
*/	
function addTab(title, href, iconCls, iframe){
	var tabPanel = $('#wu-tabs');
	if(!tabPanel.tabs('exists',title)){
		var content = '<iframe scrolling="auto" frameborder="0"  src="'+ href +'" style="width:100%;height:99%;margin-top:1.5px;"></iframe>';
		if(iframe){
			tabPanel.tabs('add',{
				title:title,
				content:content,
				iconCls:iconCls,
				fit:true,
				cls:'pd3',
				closable:true
			});
		}
		else{
			tabPanel.tabs('add',{
				title:title,
				href:href,
				iconCls:iconCls,
				fit:true,
				cls:'pd3',
				closable:true
			});
		}
	}
	else
	{
		tabPanel.tabs('select',title);
	}
	tabClose();
}
function tabClose() {
	/*双击关闭TAB选项卡*/
	$(".tabs-inner").dblclick(function(){
		var subtitle = $(this).children(".tabs-closable").text();
		$('#wu-tabs').tabs('close',subtitle);
	})
	/*为选项卡绑定右键*/
	$(".tabs-inner").bind('contextmenu',function(e){
		$('#mm').menu('show', {
			left: e.pageX,
			top: e.pageY
		});

		var subtitle =$(this).children(".tabs-closable").text();

		$('#mm').data("currtab",subtitle);
		$('#wu-tabs').tabs('select',subtitle);
		return false;
	});
}
/**
* Name 移除菜单选项
*/
function removeTab(){
	var tabPanel = $('#wu-tabs');
	var tab = tabPanel.tabs('getSelected');
	if (tab){
		var index = tabPanel.tabs('getTabIndex', tab);
		tabPanel.tabs('close', index);
	}
}