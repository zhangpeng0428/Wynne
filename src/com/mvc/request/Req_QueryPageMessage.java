package com.mvc.request;
/**  
 * �����б�
 * 
 * @author ����   
 * @version ����ʱ�䣺2016��11��20�� ����12:46:43  
 */
public class Req_QueryPageMessage {

	public FinalData finalData;
	//����ID
	public String venueId;
	//ÿҳ����
	public Integer pageSize;
	//��ǰ��ҳĬ��1
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
