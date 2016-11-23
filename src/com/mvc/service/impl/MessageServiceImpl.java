package com.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.mvc.model.Message;
import com.mvc.request.Req_QueryPageMessage;
import com.mvc.service.MessageService;

/**  
 * <一句话简述本类作用> 
 * @author 张鹏   
 * @version 创建时间：2016年11月20日 上午12:35:19  
 */
public class MessageServiceImpl implements MessageService {

	@Override
	public Message findById(String id) {
		return Message.dao.findById(id);
	}

	@Override
	public List<Message> findByIds(String userids) {
		String[] ids = userids.split(",");
		String params = "";
		List<Object> paramObj = new ArrayList<Object>();
		for (String s:ids) {
			if ("".equals(params)){
				params="?";
				paramObj.add(s);
			}else{
				params=params+",?";
				paramObj.add(s);
			}
		}
		String sql = "select * from message where id in("+params+")";
		return Message.dao.find(sql, paramObj.toArray());
	}

	@Override
	public boolean create(Message message) {
		return message.save();
	}

	@Override
	public boolean update(Message message) {
		return message.update();
	}

	@Override
	public int delete(String idValues) {
		String[] ids = idValues.split(",");
		String params = "";
		List<Object> paramObj = new ArrayList<Object>();
		for (String s:ids) {
			if ("".equals(params)){
				params="?";
				paramObj.add(s);
			}else{
				params=params+",?";
				paramObj.add(s);
			}
		}
		return Db.update("delete from message where id in ("+params+")",paramObj.toArray());
	}

	@Override
	public Page<Message> getDataMessage(Req_QueryPageMessage pageMessage) {
		
		int pageNumber = pageMessage.getNowPage() == 0?1:pageMessage.getNowPage();
		int pageSize = pageMessage.getPageSize() == 0?10:pageMessage.getPageSize();
		
		String select = "select msg.* ";
		String formwhere = "from message msg where 1=1 ";
		formwhere = formwhere + " and msg.venueId = "+pageMessage.getVenueId()+"";
		formwhere = formwhere + " order by a.updatetime desc";
		return Message.dao.paginate(pageNumber, pageSize, select, formwhere);
	}

}
