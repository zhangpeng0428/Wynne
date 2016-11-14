package com.mvc.service.impl;

import com.jfinal.plugin.activerecord.Page;
import com.mvc.model.Log;
import com.mvc.service.LogService;

public class LogServiceImpl implements LogService {

	@Override
	public boolean create(Log log) {
		return log.save();
	}
	@Override
	public Page<Log> getListLog(int pageNumber, int pageSize, 
			String username, String nickname, String request_name, String date_q, String date_z) {
		String select = "select *";
		String formwhere = "from sys_log where username like '%"+username+"%'";
		formwhere = formwhere + " and nickname like '%"+nickname+"%'";
		formwhere = formwhere + " and request_name like '%"+request_name+"%'";
		if(!"".equals(date_q) && !"".equals(date_z)){
		formwhere = formwhere + " and DATE_FORMAT(operation_time,'%Y-%m-%d') BETWEEN '"+date_q+"' and '"+date_z+"'";
		}
		formwhere = formwhere + " order by operation_time desc";
		//System.out.println(formwhere);
		return Log.dao.paginate(pageNumber, pageSize, select, formwhere);
	}
	@Override
	public String getMethodName(String requestUrl){
		if ("/system/checklogin".equals(requestUrl)){
			return "用户登陆";
		}
		if ("/system/loginout".equals(requestUrl)){
			return "退出登陆";
		}
		if ("/user/add".equals(requestUrl)){
			return "用户添加";
		}
		if ("/user/edit".equals(requestUrl)){
			return "用户修改";
		}
		if ("/user/delete".equals(requestUrl)){
			return "用户删除";
		}
		if ("/role/add".equals(requestUrl)){
			return "角色添加";
		}
		if ("/role/edit".equals(requestUrl)){
			return "角色修改";
		}
		if ("/role/delete".equals(requestUrl)){
			return "角色删除";
		}
		if ("/menu/add".equals(requestUrl)){
			return "菜单添加";
		}
		if ("/menu/edit".equals(requestUrl)){
			return "菜单修改";
		}
		if ("/menu/delete".equals(requestUrl)){
			return "菜单删除";
		}
		if ("/dept/add".equals(requestUrl)){
			return "部门添加";
		}
		if ("/dept/edit".equals(requestUrl)){
			return "部门修改";
		}
		if ("/dept/delete".equals(requestUrl)){
			return "部门删除";
		}
		return "中文名称未定义,请在LogServiceImpl中定义";
	}


}
