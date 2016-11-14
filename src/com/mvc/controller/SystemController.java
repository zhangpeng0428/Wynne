package com.mvc.controller;

import java.util.HashMap;
import java.util.Map;

import com.common.core.GlobalKey;
import com.common.utils.MD5Util;
import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import com.mvc.interceptor.LoginLogInterceptor;
import com.mvc.model.User;

public class SystemController extends Controller {
//	MenuService menuService = new MenuServiceImpl();
//	UserService userService = new UserServiceImpl();
	
	@Clear
	public void login(){
		if("error".equals(getPara(0))){
			setAttr("errorMsg","�û������������");
		}
		render("login.jsp");
	}
	
	@Clear
	@Before(LoginLogInterceptor.class)
	public void checklogin() {
		User loginUser = getModel(User.class);
		String username = loginUser.getStr("name");
		String password = MD5Util.md5(loginUser.getStr("pwd"));
		User user = User.dao.findLoginUser(username, password);
		System.out.println(password);
		if (user != null) {
			setSessionAttr(GlobalKey.CurrentUser,user);
			redirect("/system/main");
		} else {
			redirect("/system/login/error");
		}
	}
	
	//ע����½
	public void loginout(){
		removeSessionAttr(GlobalKey.CurrentUser);
		redirect("/");
	}
	
	//�޸�����
	public void pwdUp() {
		boolean flag = true;
		String errorMsg = "";
		User user = User.dao.findById(getPara("id"));
		String oldPassword = MD5Util.md5(getPara("oldPassword"));
		String newPassword = MD5Util.md5(getPara("newPassword"));
		if(user.get("password").equals(oldPassword)){
			user.set("password", newPassword);
			if (!user.update()){
				flag = false;
				errorMsg = "�����޸�ʧ�ܣ�";
			}
		}else{
			flag = false;
			errorMsg = "ԭ�������벻��ȷ��";
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("flag", flag);
		result.put("errorMsg", errorMsg);
		renderJson(JsonKit.toJson(result));
	}
}