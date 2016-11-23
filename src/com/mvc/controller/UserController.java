package com.mvc.controller;

import com.common.core.BaseController;
import com.jfinal.kit.JsonKit;
import com.mvc.model.User;
import com.mvc.request.Req_Login;
import com.mvc.request.Req_User_add;
import com.mvc.request.Req_User_update;
import com.mvc.request.ReturnData;
import com.mvc.service.UserService;
import com.mvc.service.impl.UserServiceImpl;

/**  
 * �û���¼
 * 
 * @author ����   
 * @version ����ʱ�䣺2016��11��15�� ����8:48:21  
 */
public class UserController extends BaseController {

	UserService userService = new UserServiceImpl();
	
	/**
	 * �û�ע��
	 * 
	 * @return
	 * @throws Exception 
	 */
	public void add() throws Exception {
		
		Req_User_add userAdd = (Req_User_add) getRequestObject(Req_User_add.class);
		
		User user = new User();
		user.set("type", userAdd.getFinalData().getType());
		user.set("user", userAdd.getUser());
		user.set("pwd", userAdd.getPwd());
		user.set("mac", userAdd.getFinalData().getMac());
		user.set("code", userAdd.getFinalData().getCode());
		
		ReturnData data = new ReturnData();
		if (userService.create(user)) {
			data.setCode(200);
			data.setMsg("ע��ɹ���");
			renderJson(JsonKit.toJson(data));
		}else{
			data.setCode(201);
			data.setMsg("ע��ʧ�ܣ�");
			renderJson(JsonKit.toJson(data));
		}
	}
	
	/**
	 * �༭�û���Ϣ
	 * @throws Exception 
	 * 
	 */
	public void edit() throws Exception {
		Req_User_update user_update = (Req_User_update) getRequestObject(Req_User_update.class);

		User user = userService.findById(user_update.getUserId());
		
		user.set("email", user_update.getEmail());
		user.set("head", user_update.getHeadId());
		user.set("sex", user_update.getSex());
		user.set("name", user_update.getName());
	
		ReturnData data = new ReturnData();
		if (userService.update(user)) {
			data.setCode(200);
			data.setMsg("�༭�ɹ���");
			renderJson(JsonKit.toJson(data));
		}else{
			data.setCode(201);
			data.setMsg("�༭ʧ�ܣ�");
			renderJson(JsonKit.toJson(data));
		}
	}
	
	/**
	 * �û���¼
	 * @throws Exception 
	 * 
	 */
	public void login() throws Exception {
		
		Req_Login req_Login = (Req_Login) getRequestObject(Req_Login.class);
		
		User user = User.dao.findLoginUser(req_Login.getUser(), req_Login.getPwd());
//		user.set("code", req_Login.getFinalData().getMac());
//		userService.update(user);
		ReturnData data = new ReturnData();
		if (user != null) {
			data.setCode(200);
			data.setMsg("��½�ɹ�");
			renderJson(JsonKit.toJson(user));
		}else{
			data.setCode(201);
			data.setMsg("��½ʧ��");
			renderJson(JsonKit.toJson(user));
		}
	}
}
