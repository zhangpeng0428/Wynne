package com.mvc.request;

import java.util.List;

import com.mvc.model.Dead;

/**  
 * <一句话简述本类作用> 
 * request 请求对象
 * 
 * @author 张鹏   
 * @version 创建时间：2016年11月18日 下午9:42:46  
 */
public class Req_Venue_add {

	//必传参数
	private FinalData finalData;
	//创建者ID
	private String userId;
	//场馆类型：1 个人，2双人 ，3 名人
	private String type;
	//大厅风格ID
	private String styleId;
	//祭拜大厅风格Id
	private String worshipId;
	//逝者集合对象，参考文档Dead类
	private List<Req_Dead> deads;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public List<Req_Dead> getDeads() {
		return deads;
	}

	public void setDeads(List<Req_Dead> deads) {
		this.deads = deads;
	}
}
