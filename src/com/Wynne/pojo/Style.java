package com.Wynne.pojo;

import com.Wynne.BeseData.BaseEntity;

/**  
 * <一句话简述本类作用> 
 * 风格表
 * @author 张鹏   
 * @version 创建时间：2016年11月13日 下午4:13:46  
 */
public class Style extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//类型 1.大厅 2.
	private String type;
	//名称
	private String name;
	//背景图片
	private String beakground;
	//相框图片
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
