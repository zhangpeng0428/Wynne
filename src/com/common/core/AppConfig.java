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
		me.add("/system",SystemController.class);   // ����������ʡ��ʱĬ�����һ������ֵ��ͬ���ڴ˼�Ϊ "/system"	
//		me.add("/Deeds", Deeds.class);
//		me.add("/Message", Message.class);
//		me.add("/Sacrifice", Sacrifice.class);
//		me.add("/Style", Style.class);
//		me.add("/User", User.class);
//		me.add("/Venue", Venue.class);
//		me.add("/VenueSacrifice", VenueSacrifice.class);
	}

	public void configPlugin(Plugins me) {
		// ����C3p0���ݿ����ӳز��
		C3p0Plugin c3p0Plugin = new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
		me.add(c3p0Plugin);
		
		// ����ActiveRecord���
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		me.add(arp);
		arp.addMapping("user","id", User.class);	// ӳ��sys_user �� Userģ��
//		arp.addMapping("sys_role","id", Role.class);	// ӳ��sys_role �� Roleģ��
//		arp.addMapping("sys_menu","id", Menu.class);	// ӳ��sys_menu �� Menuģ��
//		arp.addMapping("sys_dept","id", Dept.class);	// ӳ��sys_dept �� Deptģ��
//		arp.addMapping("sys_user_role","id", UserRole.class);	// ӳ��sys_user_role �� UserRoleģ��
//		arp.addMapping("sys_role_menu","id", RoleMenu.class);	// ӳ��sys_role_menu �� RoleMenuģ��
//		arp.addMapping("sys_log", Log.class); //��־
//		arp.addMapping("sys_dict", "id", Dict.class); //�����ֵ����
//		arp.addMapping("sys_dict_detail", "id", DictDetail.class); //�����ֵ����ѡ��
//		
//		arp.addMapping("sys_dev", "id", Device.class);//�豸��
//		arp.addMapping("sys_proj", "id", Project.class);//������Ϣ��
//		arp.addMapping("sys_pile", "id", Pile.class);//��׮��Ϣ��
//		
//		arp.addMapping("sys_power", "id", Power.class);//Ȩ����Ϣ��
//		arp.addMapping("sys_role_power", "id", RolePower.class);
	}

	public void configInterceptor(Interceptors me) {
		//��ӿ��Ʋ�ȫ��������
		me.addGlobalActionInterceptor(new LoginInterceptor());
	}

	public void configHandler(Handlers me) {
	}
}
