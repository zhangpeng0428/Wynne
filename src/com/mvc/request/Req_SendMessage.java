package com.mvc.request;
/**  
 * <一句话简述本类作用> 
 * @author 张鹏   
 * @version 创建时间：2016年11月20日 上午12:22:44  
 */
public class Req_SendMessage {

	public FinalData finalData;
	//场馆ID
	public String venueId;
	//留言内容
	public String content;
	//类型：0游客 1平台用户 type==0时，用户ID为系统默认游客ID，type==1时，用户ID为当前登陆用户ID
	public Integer type;
	//用户ID
	public String userId;
	
	public FinalData getFinalData() {
		return finalData;
	}
	public void setFinalData(FinalData finalData) {
		this.finalData = finalData;
	}
	public String getVenueId() {
		return venueId;
	}
	public void setVenueId(String venueId) {
		this.venueId = venueId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
