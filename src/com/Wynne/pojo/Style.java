package com.Wynne.pojo;

import com.Wynne.BeseData.BaseEntity;

/**  
 * <һ�仰������������> 
 * ����
 * @author ����   
 * @version ����ʱ�䣺2016��11��13�� ����4:13:46  
 */
public class Style extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//���� 1.���� 2.
	private String type;
	//����
	private String name;
	//����ͼƬ
	private String beakground;
	//���ͼƬ
	private String frame;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBeakground() {
		return beakground;
	}
	public void setBeakground(String beakground) {
		this.beakground = beakground;
	}
	public String getFrame() {
		return frame;
	}
	public void setFrame(String frame) {
		this.frame = frame;
	}
}