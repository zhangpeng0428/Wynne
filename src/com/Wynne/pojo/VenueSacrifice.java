package com.Wynne.pojo;

import com.Wynne.BeseData.BaseEntity;

/**  
 * <一句话简述本类作用> 
 * 场馆祭品表
 * 
 * @author 张鹏   
 * @version 创建时间：2016年11月13日 下午4:27:27  
 */
public class VenueSacrifice extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//场馆ID
	private Integer venueId;
	//祭品ID
	private Integer sacrifice;
	
	public Integer getVenueId() {
		return venueId;
	}
	public void setVenueId(Integer venueId) {
		this.venueId = venueId;
	}
	public Integer getSacrifice() {
		return sacrifice;
	}
	public void setSacrifice(Integer sacrifice) {
		this.sacrifice = sacrifice;
	}
	
}
