package com.Wynne.pojo;

import com.Wynne.BeseData.BaseEntity;

/**  
 * <һ�仰������������> 
 * ��Ʒ��
 * 
 * @author ����   
 * @version ����ʱ�䣺2016��11��13�� ����4:24:48  
 */
public class Sacrifice extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//����
	private String name;
	//ͼƬ·��
	private String image;
	//����
	private String money;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
}
