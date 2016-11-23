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
 * <一句话简述本类作用> 
 * @author 张鹏   
 * @version 创建时间：2016年11月20日 上午12:30:56  
 */
public class MessageController extends BaseController{

	MessageService messageService = new MessageServiceImpl();
	
	/**
	 * 发表留言
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
			data.setMsg("留言成功");
			renderJson(JsonKit.toJson(data));
		}else{
			data.setCode(201);
			data.setMsg("留言失败");
			renderJson(JsonKit.toJson(data));
		} 
	}
	
	/**
	 * 留言列表
	 * 
	 */
	public void queryPageMessage() {
		
		Req_QueryPageMessage pageMessage = new Req_QueryPageMessage();
		
		String username = getPara(0,""); //搜索条件，如果没有则为空
		try {
			username = URLDecoder.decode(username, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		Page<Message> listmessage = null;
		listmessage = messageService.getDataMessage(pageMessage);
	
		ReturnData data = new ReturnData();
		data.setCode(200);
		data.setMsg("获取留言列表！");
		data.setData(listmessage);
		renderJson(JsonKit.toJson(data));
	}
}
