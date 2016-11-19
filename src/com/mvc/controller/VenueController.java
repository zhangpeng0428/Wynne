package com.mvc.controller;

import com.common.core.BaseController;
import com.jfinal.kit.JsonKit;
import com.mvc.model.Venue;
import com.mvc.request.Req_Venue;
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
		
//		Req_Venue req_Venue = (Req_Venue) this.getRequestObject(Req_Venue.class); 
		
		Venue venue = new Venue();
		venue.set("userId", getPara("userId"));
		//�������ͣ�1 ���ˣ�2˫�� ��3 ����
		venue.set("type", getPara("type"));
		venue.set("grade", 0);
		//�������ID
		venue.set("styleId", getPara("styleId"));
		//���ݴ������Id
		venue.set("worshipId", getPara("worshipId"));
		venue.set("money", 0);
		venue.set("relationship", getPara("relationship"));
		//����
		venue.set("descnbe", getPara("descnbe"));
		venue.set("name", getPara("name"));
		
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
	 * �༭����
	 * 
	 */
	public void edit() {
		
//		Req_Venue req_Venue = this.getRequestObject(Req_Venue.class); 
		
		Venue venue = new Venue();
		venue.set("userId", getPara("userId"));
		//�������ͣ�1 ���ˣ�2˫�� ��3 ����
		venue.set("type", getPara("type"));
		venue.set("grade", 0);
		//�������ID
		venue.set("styleId", getPara("styleId"));
		//���ݴ������Id
		venue.set("worshipId", getPara("worshipId"));
		venue.set("money", 0);
		venue.set("relationship", getPara("relationship"));
		//����
		venue.set("descnbe", getPara("descnbe"));
		venue.set("name", getPara("name"));
		
		ReturnData data = new ReturnData();
		if (venueService.update(venue)) {
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
}
