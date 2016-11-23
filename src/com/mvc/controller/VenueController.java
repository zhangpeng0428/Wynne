package com.mvc.controller;

import java.util.List;

import com.common.core.BaseController;
import com.jfinal.kit.JsonKit;
import com.mvc.model.Dead;
import com.mvc.model.Venue;
import com.mvc.request.Req_Dead;
import com.mvc.request.Req_QueryAllVenue;
import com.mvc.request.Req_Venue_add;
import com.mvc.request.Req_Venue_update;
import com.mvc.request.ReturnData;
import com.mvc.service.VenueService;
import com.mvc.service.impl.VenueServiceImpl;

/**  
 * <һ�仰������������> 
 * @author ����   
 * @version ����ʱ�䣺2016��11��18�� ����9:48:28  
 */
public class VenueController  extends BaseController {

	VenueService venueService = new VenueServiceImpl();
	
	/**
	 * ��ӳ���
	 * @throws Exception 
	 * 
	 */
	public void add() throws Exception {
		
		Req_Venue_add req_Venue = (Req_Venue_add) this.getRequestObject(Req_Venue_add.class); 
		
		Venue venue = new Venue();
		venue.set("userId", req_Venue.getUserId());
		venue.set("type", req_Venue.getType());
		venue.set("styleId", req_Venue.getStyleId());
		venue.set("worshipId", req_Venue.getWorshipId());
		venue.save();
		List<Req_Dead> deads = req_Venue.getDeads();
		for (Req_Dead req_Dead : deads) {
			Dead dead = new Dead();
			dead.set("name", req_Dead.getName());
			dead.set("sex", req_Dead.getSex());
			dead.set("brithday", req_Dead.getBrithday());
			dead.set("death", req_Dead.getDeath());
			dead.set("tableId", req_Dead.getTableId());
			dead.set("head", req_Dead.getHead());
			dead.set("venueId", venue.get("id"));
			dead.save();
		}
		ReturnData data = new ReturnData();
		if (venueService.create(venue)) {
			data.setCode(200);
			data.setMsg("���ݴ����ɹ�");
			renderJson(JsonKit.toJson(data));
		}else{
			data.setCode(201);
			data.setMsg("���ݴ���ʧ��");
			renderJson(JsonKit.toJson(data));
		}
	}
	
	/**
	 * ��������
	 * @throws Exception 
	 * 
	 */
	public void update() throws Exception {
		
		Req_Venue_update req_Venue = (Req_Venue_update) this.getRequestObject(Req_Venue_update.class); 
		
		Venue venue = venueService.findById(String.valueOf(req_Venue.getId()));
		venue.set("userId", req_Venue.getUserId());
		venue.set("styleId", req_Venue.getStyleId());
		venue.set("worshipId", req_Venue.getWorshipId());
		venue.save();
		List<Req_Dead> deads = req_Venue.getDeads();
		for (Req_Dead req_Dead : deads) {
			Dead dead = new Dead();
			dead.set("name", req_Dead.getName());
			dead.set("sex", req_Dead.getSex());
			dead.set("brithday", req_Dead.getBrithday());
			dead.set("death", req_Dead.getDeath());
			dead.set("tableId", req_Dead.getTableId());
			dead.set("head", req_Dead.getHead());
			dead.set("venueId", venue.get("id"));
		}
		ReturnData data = new ReturnData();
		if (venueService.create(venue)) {
			data.setCode(200);
			data.setMsg("���ݴ����ɹ�");
			renderJson(JsonKit.toJson(data));
		}else{
			data.setCode(201);
			data.setMsg("���ݴ���ʧ��");
			renderJson(JsonKit.toJson(data));
		}
	}
	
	/**
	 * ɾ������
	 * 
	 * @return
	 */
	public void delete() {
		
//		Req_Venue req_Venue = this.getRequestObject(Req_Venue.class); 
		
		Venue venue = new Venue();
		venueService.delete("");
//			data.setCode(201);
//			data.setMsg("���ݴ���ʧ��");
//			renderJson(JsonKit.toJson(data));
	}
	
	/**
	 * �û����м����
	 * @throws Exception 
	 * 
	 */
	public void queryAll() throws Exception {
		
		Req_QueryAllVenue allVenue = this.getRequestObject(Req_QueryAllVenue.class); 
		
//		ReturnData data = new ReturnData();
//		if (venueService.update(venue)) {
//			data.setCode(200);
//			data.setMsg("���ݴ����ɹ�");
//			renderJson(JsonKit.toJson(data));
//		}else{
//			data.setCode(201);
//			data.setMsg("���ݴ���ʧ��");
//			renderJson(JsonKit.toJson(data));
//		} 
	}
}
