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
			return "�û���½";
		}
		if ("/system/loginout".equals(requestUrl)){
			return "�˳���½";
		}
		if ("/user/add".equals(requestUrl)){
			return "�û����";
		}
		if ("/user/edit".equals(requestUrl)){
			return "�û��޸�";
		}
		if ("/user/delete".equals(requestUrl)){
			return "�û�ɾ��";
		}
		if ("/role/add".equals(requestUrl)){
			return "��ɫ���";
		}
		if ("/role/edit".equals(requestUrl)){
			return "��ɫ�޸�";
		}
		if ("/role/delete".equals(requestUrl)){
			return "��ɫɾ��";
		}
		if ("/menu/add".equals(requestUrl)){
			return "�˵����";
		}
		if ("/menu/edit".equals(requestUrl)){
			return "�˵��޸�";
		}
		if ("/menu/delete".equals(requestUrl)){
			return "�˵�ɾ��";
		}
		if ("/dept/add".equals(requestUrl)){
			return "�������";
		}
		if ("/dept/edit".equals(requestUrl)){
			return "�����޸�";
		}
		if ("/dept/delete".equals(requestUrl)){
			return "����ɾ��";
		}
		return "��������δ����,����LogServiceImpl�ж���";
	}


}
