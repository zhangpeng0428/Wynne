package com.Wynne.pojo;

import com.Wynne.BeseData.BaseEntity;

/**  
 * <一句话简述本类作用> 
 * 祭品表
 * 
 * @author 张鹏   
 * @version 创建时间：2016年11月13日 下午4:24:48  
 */
public class Sacrifice extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//名称
	private String name;
	//图片路径
	private String image;
	//单价
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
