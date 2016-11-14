package com.mvc.service;

import com.jfinal.plugin.activerecord.Page;
import com.mvc.model.Log;

public interface LogService {
	//添加日志
	public boolean create(Log log);
	//获取日志列表
	public Page<Log> getListLog(int pageNumber, int pageSize, String username, String nickname, String request_name, String date_q, String date_z);
	//获取操作方法名
	public String getMethodName(String requestUrl);
	
	
}
