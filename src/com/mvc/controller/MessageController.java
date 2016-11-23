package com.mvc.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;

import com.common.core.BaseController;
import com.jfinal.kit.JsonKit;
import com.jfinal.plugin.activerecord.Page;
import com.mvc.model.Message;
import com.mvc.request.Req_QueryPageMessage;
import com.mvc.request.Req_SendMessage;
import com.mvc.request.ReturnData;
import com.mvc.service.MessageService;
import com.mvc.service.impl.MessageServiceImpl;

/**  
 * <һ�仰������������> 
 * @author ����   
 * @version ����ʱ�䣺2016��11��20�� ����12:30:56  
 */
public class MessageController extends BaseController{

	MessageService messageService = new MessageServiceImpl();
	
	/**
	 * ��������
	 * 
	 * @return
	 * @throws Exception 
	 */
	public void sendMessage() throws Exception {
		
		Req_SendMessage message = this.getRequestObject(Req_SendMessage.class); 
		
		Message msg = new Message();
		
		msg.set("venueId", message.getVenueId());
		
		msg.set("content", message.getContent());
		
		msg.set("userId", message.getUserId());
		
		msg.set("type", message.getType());
		
		msg.set("createtime", new Date());
		
		ReturnData data = new ReturnData();
		if (messageService.create(msg)) {
			data.setCode(200);
			data.setMsg("���Գɹ�");
			renderJson(JsonKit.toJson(data));
		}else{
			data.setCode(201);
			data.setMsg("����ʧ��");
			renderJson(JsonKit.toJson(data));
		} 
	}
	
	/**
	 * �����б�
	 * 
	 */
	public void queryPageMessage() {
		
		Req_QueryPageMessage pageMessage = new Req_QueryPageMessage();
		
		String username = getPara(0,""); //�������������û����Ϊ��
		try {
			username = URLDecoder.decode(username, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		Page<Message> listmessage = null;
		listmessage = messageService.getDataMessage(pageMessage);
	
		ReturnData data = new ReturnData();
		data.setCode(200);
		data.setMsg("��ȡ�����б�");
		data.setData(listmessage);
		renderJson(JsonKit.toJson(data));
	}
}
