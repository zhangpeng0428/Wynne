package com.mvc.service;

import com.jfinal.plugin.activerecord.Page;
import com.mvc.model.Log;

public interface LogService {
	//�����־
	public boolean create(Log log);
	//��ȡ��־�б�
	public Page<Log> getListLog(int pageNumber, int pageSize, String username, String nickname, String request_name, String date_q, String date_z);
	//��ȡ����������
	public String getMethodName(String requestUrl);
	
	
}
