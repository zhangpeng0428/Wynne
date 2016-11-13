package com.Wynne.pojo;

import com.Wynne.BeseData.BaseEntity;

/**  
 * <一句话简述本类作用> 
 * 事迹表
 * 
 * @author 张鹏   
 * @version 创建时间：2016年11月13日 下午4:21:16  
 */
public class Deeds extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//场馆ID
	private Integer venueId;
	//事迹内容
	private String content;
	
	public Integer getVenueId() {
		return venueId;
	}
	public void setVenueId(Integer venueId) {
		this.venueId = venueId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
