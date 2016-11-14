package com.common.interceptor;

import java.util.Date;

import com.common.core.GlobalKey;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.mvc.model.Log;
import com.mvc.model.User;
import com.mvc.service.LogService;
import com.mvc.service.impl.LogServiceImpl;

/**
 * �û���¼��ȫ��������
 */
public class LoginInterceptor implements Interceptor {

	public void intercept(Invocation inv) {
		User user = inv.getController().getSessionAttr(GlobalKey.CurrentUser);
		if (user==null) {
			inv.getController().redirect("/");
		} else {
			inv.invoke(); //����������
			if("/system/loginout".equals(inv.getActionKey())){
			LogService logService = new LogServiceImpl();
			Log log = new Log();
			log.set("username", user.getStr("username"));
			log.set("nickname", user.getStr("nickname"));
			if("0:0:0:0:0:0:0:1".equals(inv.getController().getRequest().getRemoteAddr().toString())){
				log.set("ip_address", "127.0.0.1");
			}else{
				log.set("ip_address", inv.getController().getRequest().getRemoteAddr());
			}
			log.set("request_name", logService.getMethodName(inv.getActionKey()));
			log.set("request_url", inv.getActionKey());
			log.set("url_para", inv.getController().getPara());
			log.set("operation_time", new Date());
			logService.create(log);  //���˳���½��Ϣд����־
			}
		}
		/**
		System.out.println("username:"+JsonKit.toJson(user.getStr("username")));
		System.out.println("�ͻ��������ַ:"+inv.getControllerKey());
		System.out.println("�ͻ��������ַ:"+inv.getActionKey());
		System.out.println("����Ŀ¼:"+inv.getController().getRequest().getContextPath());
		System.out.println("������IP��ַ:"+inv.getController().getRequest().getLocalAddr());
		System.out.println("�ͻ���IP��ַ:"+inv.getController().getRequest().getRemoteAddr());
		System.out.println("UrlPara:"+inv.getController().getPara());
		System.out.println("��ȡָ����GET/POST����:"+inv.getController().getPara("page"));
		System.out.println("Parameter:"+JsonKit.toJson(inv.getController().getParaMap()));
		System.out.println("Parameter:"+JsonKit.toJson(inv.getController().getRequest().getQueryString()));
	    */
	}

}

