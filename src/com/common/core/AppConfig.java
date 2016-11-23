package com.common.core;

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
import com.mvc.controller.MessageController;
import com.mvc.controller.SystemController;
import com.mvc.controller.UserController;
import com.mvc.model.Message;
import com.mvc.model.User;
import com.mvc.model.Venue;

public class AppConfig extends JFinalConfig {
	
	public void configConstant(Constants me) {
		PropKit.use("config.properties");
		me.setDevMode(true);
//		me.setBaseViewPath("/WEB-INF/view");
//		me.setViewType(ViewType.JSP); 	
	}

	public void configRoute(Routes me) {
//		me.add("/", IndexController.class, "/");
//		me.add("/system",SystemController.class);   // 第三个参数省略时默认与第一个参数值相同，在此即为 "/system"
		me.add("/user",UserController.class);
		me.add("/venue",UserController.class);
		me.add("/message",MessageController.class);
	}

	public void configPlugin(Plugins me) {
		// 配置C3p0数据库连接池插件
		C3p0Plugin c3p0Plugin = new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
		me.add(c3p0Plugin);
		
		// 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		me.add(arp);
		arp.addMapping("user","id", User.class);	// 映射sys_user 表到 User模型
		arp.addMapping("venue","id", Venue.class);	// 映射venue 表到 Venue模型
		arp.addMapping("message","id", Message.class);	// 映射message 表到 Message模型
	}

	public void configInterceptor(Interceptors me) {
		//添加控制层全局拦截器
//		me.addGlobalActionInterceptor(new LoginInterceptor());
	}

	public void configHandler(Handlers me) {
	}
}
