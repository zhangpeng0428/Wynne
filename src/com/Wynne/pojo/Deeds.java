package com.Wynne.pojo;

import com.Wynne.BeseData.BaseEntity;

/**  
 * <һ�仰������������> 
 * �¼���
 * 
 * @author ����   
 * @version ����ʱ�䣺2016��11��13�� ����4:21:16  
 */
public class Deeds extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//����ID
	private Integer venueId;
	//�¼�����
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
