package com.mvc.request;

import java.util.List;

/**  
 * <一句话简述本类作用> 
 * request 请求对象
 * 
 * @author 张鹏   
 * @version 创建时间：2016年11月18日 下午9:42:46  
 */
public class Req_Venue_update {

	//必传参数
	private FinalData finalData;
	private long id;
	//用户ID
	private String userId;
	//大厅风格ID
	private String styleId;
	//祭拜大厅风格Id
	private String worshipId;
	//逝者集合对象，参考文档Dead类
	private List<Req_Dead> deads;
	//场馆ID
	private String venueId;
	//逝者集合对象，参考文档Dead类
	private String name;
	
	public FinalData getFinalData() {
		return finalData;
	}

	public void setFinalData(FinalData finalData) {
		this.finalData = finalData;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStyleId() {
		return styleId;
	}

	public void setStyleId(String styleId) {
		this.styleId = styleId;
	}

	public String getWorshipId() {
		return worshipId;
	}

	public void setWorshipId(String worshipId) {
		this.worshipId = worshipId;
	}

	public String getVenueId() {
		return venueId;
	}

	public void setVenueId(String venueId) {
		this.venueId = venueId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Req_Dead> getDeads() {
		return deads;
	}

	public void setDeads(List<Req_Dead> deads) {
		this.deads = deads;
	}
	
}
