package com.mvc.interceptor;

import java.util.Date;

import com.common.core.GlobalKey;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.mvc.model.Log;
import com.mvc.model.User;
import com.mvc.service.LogService;
import com.mvc.service.impl.LogServiceImpl;

public class LoginLogInterceptor implements Interceptor{

	@Override
	public void intercept(Invocation inv) {
		inv.invoke(); //先放行，如果登陆成功了，再将登陆信息写入日志
		User user = inv.getController().getSessionAttr(GlobalKey.CurrentUser);
		if (user==null) {
			inv.getController().redirect("/");
		} else {
			if("/system/checklogin".equals(inv.getActionKey())){
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
			logService.create(log);  //将退出登陆信息写入日志
			}
		}
	}
}
