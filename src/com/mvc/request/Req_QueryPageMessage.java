package com.mvc.request;
/**  
 * 留言列表
 * 
 * @author 张鹏   
 * @version 创建时间：2016年11月20日 上午12:46:43  
 */
public class Req_QueryPageMessage {

	public FinalData finalData;
	//场馆ID
	public String venueId;
	//每页数量
	public Integer pageSize;
	//当前分页默认1
	public Integer nowPage;
	
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
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getNowPage() {
		return nowPage;
	}
	public void setNowPage(Integer nowPage) {
		this.nowPage = nowPage;
	}
}
