package com.mvc.controller;

import com.common.core.BaseController;
import com.jfinal.kit.JsonKit;
import com.mvc.model.Venue;
import com.mvc.request.Req_Venue;
import com.mvc.request.ReturnData;
import com.mvc.service.VenueService;
import com.mvc.service.impl.VenueServiceImpl;

/**  
 * <一句话简述本类作用> 
 * @author 张鹏   
 * @version 创建时间：2016年11月18日 下午9:48:28  
 */
public class VenueController  extends BaseController {

	VenueService venueService = new VenueServiceImpl();
	
	/**
	 * 添加场馆
	 * @throws Exception 
	 * 
	 */
	public void add() throws Exception {
		
//		Req_Venue req_Venue = (Req_Venue) this.getRequestObject(Req_Venue.class); 
		
		Venue venue = new Venue();
		venue.set("userId", getPara("userId"));
		//场馆类型：1 个人，2双人 ，3 名人
		venue.set("type", getPara("type"));
		venue.set("grade", 0);
		//大厅风格ID
		venue.set("styleId", getPara("styleId"));
		//祭拜大厅风格Id
		venue.set("worshipId", getPara("worshipId"));
		venue.set("money", 0);
		venue.set("relationship", getPara("relationship"));
		//详情
		venue.set("descnbe", getPara("descnbe"));
		venue.set("name", getPara("name"));
		
		ReturnData data = new ReturnData();
		if (venueService.create(venue)) {
			data.setCode(200);
			data.setMsg("场馆创建成功");
			renderJson(JsonKit.toJson(data));
		}else{
			data.setCode(201);
			data.setMsg("场馆创建失败");
			renderJson(JsonKit.toJson(data));
		}
	}
	
	/**
	 * 编辑场馆
	 * 
	 */
	public void edit() {
		
//		Req_Venue req_Venue = this.getRequestObject(Req_Venue.class); 
		
		Venue venue = new Venue();
		venue.set("userId", getPara("userId"));
		//场馆类型：1 个人，2双人 ，3 名人
		venue.set("type", getPara("type"));
		venue.set("grade", 0);
		//大厅风格ID
		venue.set("styleId", getPara("styleId"));
		//祭拜大厅风格Id
		venue.set("worshipId", getPara("worshipId"));
		venue.set("money", 0);
		venue.set("relationship", getPara("relationship"));
		//详情
		venue.set("descnbe", getPara("descnbe"));
		venue.set("name", getPara("name"));
		
		ReturnData data = new ReturnData();
		if (venueService.update(venue)) {
			data.setCode(200);
			data.setMsg("场馆创建成功");
			renderJson(JsonKit.toJson(data));
		}else{
			data.setCode(201);
			data.setMsg("场馆创建失败");
			renderJson(JsonKit.toJson(data));
		} 
	}
	
	/**
	 * 删除场馆
	 * 
	 * @return
	 */
	public void delete() {
		
//		Req_Venue req_Venue = this.getRequestObject(Req_Venue.class); 
		
		Venue venue = new Venue();
		venueService.delete("");
//			data.setCode(201);
//			data.setMsg("场馆创建失败");
//			renderJson(JsonKit.toJson(data));
	}
}
