package com.Wynne.pojo;

import com.Wynne.BeseData.BaseEntity;

/**  
 * <һ�仰������������> 
 * ������
 * 
 * @author ����   
 * @version ����ʱ�䣺2016��11��13�� ����4:03:42  
 */
public class Venue extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//���ͣ�1.����  2.˫�� 3.����
	private String type;
	//�ȼ�������ӵ�л���Ҽ��㣩
	private String grade;
	//���������
	private String money;
	//���ID
	private String styleId;
	//���ݴ������
	private String worshipId;
	//����
	private String name;
	//��ϵ
	private String relationship;
	//��ƽ
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
