package com.mvc.request;
/**  
 * <一句话简述本类作用> 
 * @author 张鹏   
 * @version 创建时间：2016年11月20日 上午12:15:35  
 */
public class Req_QueryAllVenue {

	
	public FinalData finalData;
	//用户ID
	public String userId;
	
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
	
	
}
