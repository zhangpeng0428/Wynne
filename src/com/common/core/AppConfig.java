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
//		me.add("/system",SystemController.class);   // ����������ʡ��ʱĬ�����һ������ֵ��ͬ���ڴ˼�Ϊ "/system"
		me.add("/user",UserController.class);
		me.add("/venue",UserController.class);
		me.add("/message",MessageController.class);
	}

	public void configPlugin(Plugins me) {
		// ����C3p0���ݿ����ӳز��
		C3p0Plugin c3p0Plugin = new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
		me.add(c3p0Plugin);
		
		// ����ActiveRecord���
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		me.add(arp);
		arp.addMapping("user","id", User.class);	// ӳ��sys_user �� Userģ��
		arp.addMapping("venue","id", Venue.class);	// ӳ��venue �� Venueģ��
		arp.addMapping("message","id", Message.class);	// ӳ��message �� Messageģ��
	}

	public void configInterceptor(Interceptors me) {
		//��ӿ��Ʋ�ȫ��������
//		me.addGlobalActionInterceptor(new LoginInterceptor());
	}

	public void configHandler(Handlers me) {
	}
}
