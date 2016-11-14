package com.common.core;


import com.common.interceptor.LoginInterceptor;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.mvc.controller.IndexController;
import com.mvc.controller.SystemController;
import com.mvc.model.User;

public class AppConfig extends JFinalConfig {
	
	public void configConstant(Constants me) {
		PropKit.use("config.properties");
		me.setDevMode(true);
		me.setBaseViewPath("/WEB-INF/view");
		me.setViewType(ViewType.JSP); 	
	}

	public void configRoute(Routes me) {
		me.add("/", IndexController.class, "/");
		me.add("/system",SystemController.class);   // 第三个参数省略时默认与第一个参数值相同，在此即为 "/system"	
//		me.add("/Deeds", Deeds.class);
//		me.add("/Message", Message.class);
//		me.add("/Sacrifice", Sacrifice.class);
//		me.add("/Style", Style.class);
//		me.add("/User", User.class);
//		me.add("/Venue", Venue.class);
//		me.add("/VenueSacrifice", VenueSacrifice.class);
	}

	public void configPlugin(Plugins me) {
		// 配置C3p0数据库连接池插件
		C3p0Plugin c3p0Plugin = new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
		me.add(c3p0Plugin);
		
		// 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		me.add(arp);
		arp.addMapping("user","id", User.class);	// 映射sys_user 表到 User模型
//		arp.addMapping("sys_role","id", Role.class);	// 映射sys_role 表到 Role模型
//		arp.addMapping("sys_menu","id", Menu.class);	// 映射sys_menu 表到 Menu模型
//		arp.addMapping("sys_dept","id", Dept.class);	// 映射sys_dept 表到 Dept模型
//		arp.addMapping("sys_user_role","id", UserRole.class);	// 映射sys_user_role 表到 UserRole模型
//		arp.addMapping("sys_role_menu","id", RoleMenu.class);	// 映射sys_role_menu 表到 RoleMenu模型
//		arp.addMapping("sys_log", Log.class); //日志
//		arp.addMapping("sys_dict", "id", Dict.class); //数据字典分类
//		arp.addMapping("sys_dict_detail", "id", DictDetail.class); //数据字典分类选项
//		
//		arp.addMapping("sys_dev", "id", Device.class);//设备表
//		arp.addMapping("sys_proj", "id", Project.class);//工程信息表
//		arp.addMapping("sys_pile", "id", Pile.class);//基桩信息表
//		
//		arp.addMapping("sys_power", "id", Power.class);//权限信息表
//		arp.addMapping("sys_role_power", "id", RolePower.class);
	}

	public void configInterceptor(Interceptors me) {
		//添加控制层全局拦截器
		me.addGlobalActionInterceptor(new LoginInterceptor());
	}

	public void configHandler(Handlers me) {
	}
}
