package com.mvc.request;

import java.util.List;

/**  
 * <һ�仰������������> 
 * request �������
 * 
 * @author ����   
 * @version ����ʱ�䣺2016��11��18�� ����9:42:46  
 */
public class Req_Venue_update {

	//�ش�����
	private FinalData finalData;
	private long id;
	//�û�ID
	private String userId;
	//�������ID
	private String styleId;
	//���ݴ������Id
	private String worshipId;
	//���߼��϶��󣬲ο��ĵ�Dead��
	private List<Req_Dead> deads;
	//����ID
	private String venueId;
	//���߼��϶��󣬲ο��ĵ�Dead��
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
