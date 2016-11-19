package com.mvc.controller;

import java.util.HashMap;
import java.util.Map;

import com.common.core.BaseController;
import com.jfinal.kit.JsonKit;
import com.mvc.model.User;
import com.mvc.request.Req_Login;
import com.mvc.service.UserService;
import com.mvc.service.impl.UserServiceImpl;

/**  
 * <一句话简述本类作用> 
 * @author 张鹏   
 * @version 创建时间：2016年11月15日 下午8:48:21  
 */
public class UserController extends BaseController {

	UserService userService = new UserServiceImpl();
	
	/**
	 * 用户注册
	 * 
	 * @return
	 * @throws Exception 
	 */
	public void add() throws Exception {
		
		Req_Login login = (Req_Login) getRequestObject(Req_Login.class);
		
		User user = new User();
//		user.set("type", login.getFinalData().getType());
////		user.set("vipstarttime", getPara("vipstarttime"));
////		user.set("vipendtime", getPara("vipendtime"));
//		user.set("money", 0);
////		user.set("head", getPara("head"));
//		user.set("name", login.getUser());
//		user.set("pwd", login.getPwd());
//		user.set("email", getPara("email"));
//		user.set("sex", getPara("sex"));
//		user.set("mac", login.getFinalData().getMac());
		
		user.set("type", getPara("type"));
//		user.set("vipstarttime", getPara("vipstarttime"));
//		user.set("vipendtime", getPara("vipendtime"));
//		user.set("money", 0);
//		user.set("head", getPara("head"));
		user.set("name", getPara("name"));
		user.set("pwd", getPara("pwd"));
//		user.set("email", getPara("email"));
//		user.set("sex", getPara("sex"));
		user.set("mac", getPara("mac"));
		user.set("version", getPara("code"));
		
		Map<String, Boolean> result = new HashMap<String, Boolean>();
		if (userService.create(user)){
			result.put("flag", true);
		}else{
			result.put("flag", false);
		}
		renderJson(JsonKit.toJson(result));
	}
	
	/**
	 * 编辑用户信息
	 * @throws Exception 
	 * 
	 */
	public void edit() throws Exception {
		Req_Login login = (Req_Login) getRequestObject(Req_Login.class);

		User user = new User();
//		user.set("type", login.getFinalData().getType());
//	//	user.set("vipstarttime", getPara("vipstarttime"));
//	//	user.set("vipendtime", getPara("vipendtime"));
//		user.set("money", 0);
//	//	user.set("head", getPara("head"));
//		user.set("name", login.getUser());
//		user.set("pwd", login.getPwd());
//		user.set("email", getPara("email"));
//		user.set("sex", getPara("sex"));
//		user.set("mac", login.getFinalData().getMac());
		
		user.set("type", getPara("type"));
	//	user.set("vipstarttime", getPara("vipstarttime"));
	//	user.set("vipendtime", getPara("vipendtime"));
	//	user.set("money", 0);
	//	user.set("head", getPara("head"));
		user.set("name", getPara("name"));
		user.set("pwd", getPara("pwd"));
	//	user.set("email", getPara("email"));
	//	user.set("sex", getPara("sex"));
		user.set("mac", getPara("mac"));
		user.set("version", getPara("code"));
	
		Map<String, Boolean> result = new HashMap<String, Boolean>();
		if (userService.update(user)){
			result.put("flag", true);
		}else{
			result.put("flag", false);
		}
		renderJson(JsonKit.toJson(result));
	}
	
	/**
	 * 用户登录
	 * 
	 */
	public void login() {
		
		User user = User.dao.findLoginUser(getPara("name"), getPara("pwd"));
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("user", user);
		renderJson(JsonKit.toJson(result));
	}
}
