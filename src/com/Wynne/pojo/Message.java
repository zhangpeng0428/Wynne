package com.Wynne.pojo;

import com.Wynne.BeseData.BaseEntity;

/**  
 * <一句话简述本类作用> 
 * 留言表
 * 
 * @author 张鹏   
 * @version 创建时间：2016年11月13日 下午4:17:59  
 */
public class Message extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//场馆ID
	private Integer venueId;
	//内容
	private Integer content;
	//留言人ID
	private Integer userId;
	
	public Integer getVenueId() {
		return venueId;
	}
	public void setVenueId(Integer venueId) {
		this.venueId = venueId;
	}
	public Integer getContent() {
		return content;
	}
	public void setContent(Integer content) {
		this.content = content;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
