package com.mvc.service;

import java.util.List;

import com.jfinal.plugin.activerecord.Page;
import com.mvc.model.Message;
import com.mvc.request.Req_QueryPageMessage;

/**  
 * <һ�仰������������> 
 * @author ����   
 * @version ����ʱ�䣺2016��11��20�� ����12:32:37  
 */
public interface MessageService {

	public Message findById(String id);
	public List<Message> findByIds(String userids);
	public boolean create(Message message);
	public boolean update(Message message);
	public int delete(String idValues);
	public Page<Message> getDataMessage(Req_QueryPageMessage pageMessage);
}
