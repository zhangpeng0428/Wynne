package com.Wynne.pojo;

import com.Wynne.BeseData.BaseEntity;

/**  
 * <һ�仰������������> 
 * ���ݼ�Ʒ��
 * 
 * @author ����   
 * @version ����ʱ�䣺2016��11��13�� ����4:27:27  
 */
public class VenueSacrifice extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//����ID
	private Integer venueId;
	//��ƷID
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
