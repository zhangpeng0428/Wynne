package com.Wynne.pojo;

import com.Wynne.BeseData.BaseEntity;

/**  
 * <一句话简述本类作用> 
 * 场馆类
 * 
 * @author 张鹏   
 * @version 创建时间：2016年11月13日 下午4:03:42  
 */
public class Venue extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//类型：1.个人  2.双人 3.名人
	private String type;
	//等级（根据拥有怀念币计算）
	private String grade;
	//怀念币数量
	private String money;
	//风格ID
	private String styleId;
	//祭拜大厅风格
	private String worshipId;
	//名称
	private String name;
	//关系
	private String relationship;
	//生平
	private String descnbe;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getDescnbe() {
		return descnbe;
	}

	public void setDescnbe(String descnbe) {
		this.descnbe = descnbe;
	}
}
